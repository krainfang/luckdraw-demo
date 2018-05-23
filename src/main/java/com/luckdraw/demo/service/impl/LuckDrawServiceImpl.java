package com.luckdraw.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luckdraw.demo.entity.PrizeCategorie;
import com.luckdraw.demo.entity.PrizeList;
import com.luckdraw.demo.entity.WinnerList;
import com.luckdraw.demo.mapper.WinnerListMapper;
import com.luckdraw.demo.service.LuckDrawService;
import com.luckdraw.demo.service.OtherService;
import com.luckdraw.demo.utils.BusinessException;
import com.luckdraw.demo.utils.DateUtil;
import com.luckdraw.demo.utils.Keys;
import com.luckdraw.demo.utils.LuckyDrawUtil;
import com.luckdraw.demo.vo.LuckDrawVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("luckDrawService")
public class LuckDrawServiceImpl implements LuckDrawService {
    private static final Logger logger = LoggerFactory.getLogger(LuckDrawServiceImpl.class);
//    @Autowired
//    private OtherSourceMapper otherSourceMapper;
    @Autowired
    private OtherService otherService;
    @Autowired
    private WinnerListMapper winnerListMapper;

    @Override
    public Map<String, Object> luckDraw(LuckDrawVo luckDraw) {
        //参数校验
        paramCheck(luckDraw);
        //抽奖前活动校验
        activityCheck(luckDraw);

        //活动规则校验并返回扣金币数
        Integer coinNum = activityRoleCheck(luckDraw);

        Map<String, Object> resltMap = new HashMap<>();
        PrizeList prize = null;
        try {
            //开始逻辑抽奖
            prize = getLuckyGift(false, luckDraw);
            winnerCheck(prize, luckDraw);//重复中奖检测
            resltMap = this.doGo(prize, luckDraw);
        } catch (Exception e) {
            logger.error("xxx", e);
            prize = null;//防止finally执行的是逻辑抽奖的结果
            logger.warn("用户{}抽奖出错：{};返回默认奖", JSON.toJSONString(luckDraw), e.getMessage());
            prize = getLuckyGift(true, luckDraw);
            try {
                resltMap = this.doGo(prize, luckDraw);
            } catch (Exception e1) {
                logger.error("用户{}默认奖入库异常：{}", JSON.toJSONString(luckDraw), e1.getMessage());
            }
        }finally {
            logger.info("用户{}获得奖品：{}", JSON.toJSONString(luckDraw), JSON.toJSONString(prize));
            if(prize != null){
                checkThanks(prize, luckDraw);
                resltMap.put("plId", prize.getPlId());
                resltMap.put("pcId", prize.getPcId());
                resltMap.put("plName", prize.getPlName());
                resltMap.put("plType", prize.getPlType());
                resltMap.put("plDetail", prize.getPlDetail());
                resltMap.put("paId", prize.getPaId());
                resltMap.put("pcImgUrl", prize.getPcImgUrl());
                resltMap.put("coinNum", coinNum);
//                try {
//                    resltMap.put("plPlat", activitySupplierStrategy.getSupplier(prize.getPaId().intValue(), prize.getAsId()).getAsName());
//                } catch (Exception e) {
//                }
//                try {
//                    ActivitySupplierImage activitySupplierImage = activitySupplierStrategy.getImage(prize.getAsId(), "pcLogo");
//                    if (activitySupplierImage != null) {
//                        resltMap.put("pcLogo", activitySupplierImage.getAsImgPath());
//                    }
//                } catch (Exception e) {
//                }
            }
        }
        return resltMap;
    }

    private PrizeList getLuckyGift(boolean isDefault, LuckDrawVo luckDraw) {
        List<PrizeList> prizeList = getPrizeList(luckDraw.getPaId());
        if (prizeList.size() <= 0) {
            logger.warn("没有可抽奖的奖品：{}", JSONObject.toJSONString(luckDraw));
            throw new BusinessException("很抱歉，您来晚了，奖品抽光了");
        }
        List<PrizeList> list = new ArrayList<>();
        List<Double> level = new ArrayList<>();
        List<Double> level1 = new ArrayList<>();
        List<Double> level2 = new ArrayList<>();
        List<Double> level3 = new ArrayList<>();
        for (PrizeList prize : prizeList) {
            if (isDefault && prize.getIsDefault() != 1) {//如果参数需要的是默认奖，则只选择默认奖，非默认奖直接排除
                continue;
            }
            list.add(prize);
            //如果有权重且奖品是非默认奖，则调整中奖概率，权重范围0-1
            if (prize.getIsDefault() != 1 && luckDraw.getWeight() != null) {
                level1.add(prize.getPlProbability() * luckDraw.getWeight());
            } else {
                level1.add(prize.getPlProbability());
            }
            level2.add(prize.getPlHuiProbability());
            level3.add(prize.getPlBuyProbability());
        }

        int index = -1;
        if (luckDraw.getUserId() == null
//                || userListStrategy.checkGray(Integer.toString(luckDraw.getUserId()))
                ) {
            level = level2;
            index = LuckyDrawUtil.extract(level2);
        } else if(luckDraw.getBuy() == 1) {
            level = level3;
            index = LuckyDrawUtil.extract(level3);
        } else {
            level = level1;
            index = LuckyDrawUtil.extract(level1);
        }
        if (index == -1) {
            logger.warn("抽奖队列异常：{}", JSONObject.toJSONString(level));
            throw new BusinessException("很抱歉，您来晚了，奖品抽光了");
        }
        return list.get(index);
    }

    private void winnerCheck(PrizeList prize, LuckDrawVo luckDrawVo) {
        if(prize.getIsDefault() == 1){
            return;
        }
        /*if(prize.getMaxPlTime() != null
                && luckDrawVo.getUserId() != null && luckDrawVo.getUserId() > 0){
            String key = String.format(Keys.PRIZELIST_WINNERED, prize.getPlId());
            Integer count = 1;
            if(jedisClusterService.hexists(key, Integer.toString(luckDrawVo.getUserId()))){
                count = jedisClusterService.vhget(Integer.class, key, Integer.toString(luckDrawVo.getUserId()));
                if(++count > prize.getMaxPlTime()){
                    throw new BusinessException("超过单个奖品每人最大中奖次数plId:" + prize.getPlId() + ";userId:" + luckDrawVo.getUserId());
                }
            }
            jedisClusterService.hset(key, Integer.toString(luckDrawVo.getUserId()), Integer.toString(count));
        }

        ActivitySupplier supplier = activitySupplierStrategy.getSupplier(prize.getPaId().intValue(), prize.getAsId());
        if(supplier != null && supplier.getAsLotteryCount() != null
                && luckDrawVo.getUserId() != null && luckDrawVo.getUserId() > 0){
            String key = String.format(Keys.SUPPLIER_WINNERED, supplier.getAsId());
            Integer count = 1;
            if(jedisClusterService.hexists(key, Integer.toString(luckDrawVo.getUserId()))){
                count = jedisClusterService.vhget(Integer.class, key, Integer.toString(luckDrawVo.getUserId()));
                if(++count > supplier.getAsLotteryCount()){
                    throw new BusinessException("超过每个供应商每人最大中奖次数asId:" + supplier.getAsId() + ";userId:" + luckDrawVo.getUserId());
                }
            }
            jedisClusterService.hset(key, Integer.toString(luckDrawVo.getUserId()), Integer.toString(count));
        }*/
    }

    @Transactional
    public Map<String, Object> doGo(PrizeList prize, LuckDrawVo luckDrawVo) {
        Map<String, Object> result = new HashMap<>();
        if (prize == null) {
            logger.warn("gift is null:" + JSON.toJSONString(prize));
            throw new BusinessException("奖品为空");
        }
        String usedCount = String.format(Keys.DATE_PRIZELIST_USERD_COUNT, DateUtil.formatDate(new Date(), DateUtil.DATE_YYYYMMDD), prize.getPlId());
        String overCount = String.format(Keys.PRIZELIST_OVER_COUNT, prize.getPlId());
        String finalVerificationCode = null;
        try {
            PrizeList vo = otherService.GetPrizeList(luckDrawVo.getPaId(), prize.getPlId());
            /*if(vo == null || (vo.getIsDefault() == 0 && jedisClusterService.incr(usedCount) > vo.getPlPutNum())){
                jedisClusterService.decr(usedCount);
                logger.warn("usedCount is full:" + prize.getPlId());
                throw new BusinessException("今日抽奖数已满。plId:" + prize.getPlId());
            }*/
            /*if(vo.getIsDefault() == 0 && jedisClusterService.decr(overCount) < 0) {
                jedisClusterService.incr(overCount);
                logger.warn("overCount is 0:" + prize.getPlId());
                throw new BusinessException("已无库存。plId:" + prize.getPlId());
            }*/
            //金币奖和谢谢参与奖只记数不走流水
            if(prize.getPlType() == 1 || prize.getPlType() == 5){
                logger.warn("gift is default:" + prize.getPlId());
                return result;
            }
            WinnerList winner = new WinnerList();
            winner.setUserId(luckDrawVo.getUserId());
            winner.setUserName(luckDrawVo.getUserName());
            winner.setUserMobile(luckDrawVo.getUserMobile());
            winner.setIpAddress(luckDrawVo.getIpAddress());
            winner.setPlId(prize.getPlId());
            winner.setVerificationCode(finalVerificationCode);
            winner.setWlTime(new Date());
            winner.setWlDate(new Date());
            winner.setWlIsReal((byte) 1);
            winner.setPaId(prize.getPaId());
            int count = winnerListMapper.insertSelective(winner);
            if (count <= 0) {
                // 新增中奖名单失败，异常
                logger.warn("add record is fail:" + prize.getPlId());
                throw new BusinessException("新增中奖名单失败，异常。winner:" + JSON.toJSONString(winner));
            }

            // 卡牌类型，添加中奖日志
            /*if (prize.getPlType() == 6) {
                WinnersListLog winnersListLog = new WinnersListLog();
                winnersListLog.setPaId(prize.getPaId());
                winnersListLog.setUserId(luckDrawVo.getUserId());
                winnersListLog.setWlActivityName("之家翻翻乐");
                winnersListLog.setWlId(winner.getWlId());
                winnersListLog.setWlDesc("翻牌获得\""+prize.getPlName()+"\"字卡牌");
                winnersListLog.setWlTime(new Date());
                winnersListLogMapper.insertSelective(winnersListLog);
            }*/

            //为未登录用户准备代码，暂时抛弃
            /*if(luckDrawVo.getUserId() == null || luckDrawVo.getUserId() == 0){
                jedisClusterService.set("ACTIVITY_LOTTERY_USER_LAST_WINNER_ID_" + luckDrawVo.getUserId(), Long.toString(winner.getWlId()));
            }*/
            return result;
        } catch (Exception e) {
            if(e instanceof BusinessException){
                throw e;
            }
            logger.error(e.getMessage(), e);
            throw new BusinessException("流程异常，退出");
        }
    }

    public List<PrizeList> getPrizeList(Long paCode) {
        List<PrizeList> result = new ArrayList<>();
        List<PrizeCategorie> categories = otherService.GetCategories(paCode);
        if (categories == null) {
            logger.warn("没有可用类型：{}", paCode);
        }
        if(categories != null){
            Date now = new Date();
            List<Long> caIds = new ArrayList<>();
            for (PrizeCategorie category : categories) {
                if (
                    //禁用的类型
                        category.getPcStatus() == 0
                                //超过使用时间的类型
                                ||(now.compareTo(category.getPcStartTime()) < 0 || now.compareTo(category.getPcEndTime()) > 0)
                        ){
                    caIds.add(category.getPcId());
                }
            }
            List<PrizeList> list = otherService.GetPrizeListByPaCode(paCode);
            for (PrizeList prize : list) {
                if(prize.getPlStatus() == 0){//奖品禁用
                    continue;
                }
                if(caIds.contains(prize.getPcId())){//奖品类别禁用
                    continue;
                }
                if(now.compareTo(prize.getPlValidStartTime()) < 0
                        || now.compareTo(prize.getPlValidEndTime()) > 0){ //不在活动时间
                    continue;
                }
                if(prize.getIsDefault() == 0){
                    String prizeCount = String.format(Keys.DATE_PRIZELIST_USERD_COUNT,
                            DateUtil.formatDate(new Date(), DateUtil.DATE_YYYYMMDD), prize.getPlId());
                    /*if(jedisClusterService.exists(prizeCount) && jedisClusterService.vget(Integer.class, prizeCount) >= prize.getPlPutNum()){ //当日已抽奖数归0
                        continue;
                    }
                    String overCount = String.format(Keys.PRIZELIST_OVER_COUNT, prize.getPlId());
                    if(jedisClusterService.exists(overCount) && jedisClusterService.vget(Integer.class, overCount) <= 0){ //库存为0
                        continue;
                    }*/
                }
                result.add(prize);
            }
        }
        return result;
    }

    /**
     * 为用户添加奖品中的金币
     * @param prize
     * @param luckDrawVo
     */
    public void checkThanks(PrizeList prize, LuckDrawVo luckDrawVo){
    }

    private Integer activityRoleCheck(LuckDrawVo luckDrawVo) {
        return 1;
    }

    private void activityCheck(LuckDrawVo luckDraw) {

    }

    private void paramCheck(LuckDrawVo luckDraw) {

    }
}
