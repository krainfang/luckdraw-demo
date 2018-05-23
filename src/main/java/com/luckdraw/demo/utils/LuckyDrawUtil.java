package com.luckdraw.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 名    称：LuckyDrawUtil
 * 功    能：
 * 创 建 人：K.K
 * 创建时间：2015/4/21 17:39
 * 修 改 人：
 * 修改时间：
 * 说    明：
 * 版 本 号：
 */
public class LuckyDrawUtil {
    private static final Logger logger = Logger.getLogger(LuckyDrawUtil.class);
    /**
     * 抽取
     *
     * @param originalRates
     * @return
     */
    public static int extract(List<Double> originalRates) {
        if (null == originalRates || originalRates.size() <= 0) {
            return -1;
        }

        double sumRate = 0d;
        for (double rate : originalRates) {
            sumRate += rate;
        }

        if (sumRate <= 0) {
            return -1;
        }

        int index = 0;
        Double tempSumRate = 0d;
        double nextDouble = Math.random() * sumRate;
        for (double rate : originalRates) {
            if (tempSumRate < nextDouble && nextDouble <= (tempSumRate += rate)) {
                break;
            }
            index++;
        }
        return index;
    }

    public static int getUserId(String authToken){
        try {
            logger.info("接收token：" + authToken);
            String userStr = CryptAES.AES_Decrypt(MyBase64.decode(authToken));
            logger.info("解密后：" + userStr);
            String[] items = userStr.split("\\|");
            if(items.length == 2){
                long timeMillis = Long.parseLong(items[1]) * 100;
                long now = System.currentTimeMillis();
                if(now - timeMillis > 120000L){
                    throw new BusinessException("超时, 请提供正确token");
                }
                return Integer.parseInt(items[0]);
            }
        } catch (NumberFormatException e) {
            logger.error("获得uid错误", e);
        }
        throw new BusinessException("错误, 请提供正确token");
    }

    public static JSONObject getUser(String token) {
        try {
            String appkey = "vtsd233495w22S1Esd0rrW3213w3SwQ?sdfkwl34UYj";
            String appid = "7";
            //token = URLDecoder.decode(token, "UTF-8");
            //token = Base64.encode(token.getBytes("UTF-8"));
            //token = URLEncoder.encode(token, "UTF-8");
            String itemurl = "https://passport.wdzj.com/service/user/auth_token?auth_token=" + token + "&appid=" + appid + "&appkey=" + appkey;
            HttpGet method = new HttpGet(itemurl);
            method.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse result = httpClient.execute(method);
            int statusCode=result.getStatusLine().getStatusCode();
            if (statusCode==200) {
                HttpEntity entity = result.getEntity();
                String json = EntityUtils.toString(entity);
//                logger.info("token json" +json);
                JSONObject jsonObject = JSON.parseObject(json);
                if (jsonObject.containsKey("error_code") && jsonObject.getIntValue("error_code") == 0) {
                    return JSON.parseObject(json).getJSONObject("data").getJSONObject("member");
                }
                return null;
            }
        } catch (Exception e) {
            logger.error("请求失败", e);
            throw new BusinessException("身份验证失败，请稍后再试");
        }
        throw new BusinessException("身份验证失败，请稍后再试");
    }

    /**
     * 生成bbs秘钥goldstore
     * @return
     */
    public static String encrypt(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String str = CryptAES.AES_Encrypt(sdf.format(new Date()));
        str = MyBase64.encodeToStr(str.getBytes());
        return str;
    }

    public static void main(String[] args){
//        System.out.print(getUserByUserId(new HashSet<String>(){{add("64019");add("28");}}));
        System.out.println(encrypt());
    }

    /**
     * 根据userId去bbs查询用户信息
     * @param uids
     * @return
     */
    public static JSONObject getUserByUserId(Set<String> uids){
        try {

            String itemurl = "http://bbs.wdzj.com/b_wdzj_houtai/javaserver/goldstore/userinfo";
            HttpPost method = new HttpPost(itemurl);
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("goldstore", encrypt()));
            params.add(new BasicNameValuePair("uid", StringUtils.join(uids, ",")));
            method.setEntity(new UrlEncodedFormEntity(params));
            method.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse result = httpClient.execute(method);
            int statusCode=result.getStatusLine().getStatusCode();
            if (statusCode==200) {
                HttpEntity entity = result.getEntity();
                String json = EntityUtils.toString(entity);
                logger.info("token json" +json);
                if(JSON.parseObject(json).getIntValue("error_code")==0) {
                    JSONArray array = JSON.parseObject(json).getJSONArray("data");
                    JSONObject users = new JSONObject();
                    if (array != null) {
                        for (int i = 0; i < array.size(); i++) {
                            users.put(array.getJSONObject(i).getString("uid"), array.getJSONObject(i));
                        }
                    }
                    return users;
                }
            }
        } catch (Exception e) {
            logger.error("请求用户信息异常", e);
            return null;
        }
        return null;
    }
}
