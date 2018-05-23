package com.luckdraw.demo.utils;

/**
 * 名    称：Keys
 * 功    能：
 * 创 建 人：K.K
 * 创建时间：2015/7/20 14:22
 * 修 改 人：
 * 修改时间：
 * 说    明：
 * 版 本 号：
 */
public final class Keys {
    // 活动缓存KEY
    public static final String ACTIVITY = "WDZJ_LUCKY_DRAW:ACTIVITY_%s";
    // 活动缓存KEY
    public static final String ACTIVITY_ID = "WDZJ_LUCKY_DRAW:ACTIVITY_ID_%s";
    // 活动缓存KEY
    public static final String RULE = "WDZJ_LUCKY_DRAW:RULE_%s";
    // 分类缓存KEY
    public static final String CATEGORY = "WDZJ_LUCKY_DRAW:CATEGORY_%s";
    // T码缓存KEY
    public static final String CUSTOM_AMOUNT = "WDZJ_LUCKY_DRAW:CUSTOM_AMOUNT";
    public static final String CUSTOM_AMOUNT_ADD_UP = "WDZJ_LUCKY_DRAW:CUSTOM_AMOUNT_ADD_UP";
    public static final String CUSTOM_AMOUNT_ADD_UP_LOGS = "WDZJ_LUCKY_DRAW:CUSTOM_AMOUNT_ADD_UP_LOGS";
    public static final String INIT_AMOUNT = "WDZJ_LUCKY_DRAW:INIT_AMOUNT";
    public static final String RANDOM_AMOUNT_ADDS = "WDZJ_LUCKY_DRAW:RANDOM_AMOUNT_ADDS";
    // 获奖名单
    public static final String WINNER_LIST = "WDZJ_LUCKY_DRAW:WINNER_LIST_%s";
    // 获奖名单人次
    public static final String WINNER_LIST_COUNT = "WDZJ_LUCKY_DRAW:WINNER_LIST_COUNT";
    // 奖品信息缓存KEY
    public static final String PRIZELIST = "WDZJ_LUCKY_DRAW:PRIZELIST_%s";
    // 奖品剩余库存缓存KEY
    public static final String PRIZELIST_OVER_COUNT = "WDZJ_LUCKY_DRAW:PRIZELIST_OVER_%s";
    // 奖品日期已抽缓存KEY
    public static final String DATE_PRIZELIST_USERD_COUNT = "WDZJ_LUCKY_DRAW:PRIZELIST_USERD_%s_%s";
    // 日期谢谢参与次数KEY
    public static final String WINNER_DEFAULT_DATE_KEY = "WDZJ_LUCKY_DRAW:WINNER_DEFAULT_DATE_%s";

    //当日抽奖次数
    public static final String DATE_LOTTERYED = "WDZJ_LUCKY_DRAW:DATE_LOTTERYED_%s_%s";
    public static final String DATE_LOTTERYED2 = "WDZJ_LUCKY_DRAW:DATE_LOTTERYED_%s";
    //当日够买概率次数
    public static final String DATE_BUY_LOTTERYED = "WDZJ_LUCKY_DRAW:DATE_BUY_LOTTERYED_%s_%s";
    // 每天全局固定抽奖次数
    public static final String DATE_PRIZELIST_LOTTERYED = "WDZJ_LUCKY_DRAW:DATE_PRIZELIST_LOTTERYED_%s";
    // 单人每天每平台抽奖次数
    public static final String DATE_SUPPLIER_PRIZELIST_LOTTERYED = "WDZJ_LUCKY_DRAW:DATE_SUPPLIER_PRIZELIST_LOTTERYED_%d_%s";
    // 单个奖品每人最大中奖数
    public static final String PRIZELIST_WINNERED = "WDZJ_LUCKY_DRAW:PRIZELIST_WINNERED_%s";
    // 每个供应商每人最大中奖次数
    public static final String SUPPLIER_WINNERED = "WDZJ_LUCKY_DRAW:SUPPLIER_WINNERED_%s";
    // 每次活动用户的奖品数量
    public static final String ACTIVITY_USER_WINNERED_COUNT = "WDZJ_LUCKY_DRAW:ACTIVITY_USER_WINNERED_COUNT";
    // 某活动参与人次（hash）
    public static final String ACTIVITY_GIFT_COUNT = "WDZJ_LUCKY_DRAW:ACTIVITY_GIFT_COUNT";
    /** 个人账户信息 (hash) */
    public static final String REDIS_KEY_ACTIVITY_ACCOUNT_INFO = "WDZJ_LUCKY_DRAW:ACTIVITY_ACCOUNT_INFO";

    /**
     * 首投限制设置
     */
    public static final String REDIS_KEY_INVEST_SETTING = "WDZJ_LUCKY_DRAW:INVEST_SETTING";
    //每人每天的首投提交次数
    public static final String REDIS_KEY_INVEST_DATE_USER = "WDZJ_LUCKY_DRAW:INVEST_DATE_%s";
    //首投可用名单列表
    public static final String REDIS_KEY_INVEST_QUEUE_USER = "WDZJ_LUCKY_DRAW:INVEST_USER_QUEUE_%s";

    //分享获得方块大通关次数
    public static final String RES_KEY_FANGKUAI_TIMES = "WDZJ_LUCKY_DRAW:FANGKUAI_TIMES_";
    //518活动用户积分
    public static final String RES_KEY_USER_SCORE = "WDZJ_LUCKY_DRAW:USER_SOCRE";
   //供应商点击加1钻石
    public static final String REDIS_KEY_SUPPLIER_HIT_DATE_USER = "WDZJ_LUCKY_DRAW:SUPPLIER_HIT_DATE_%s";    //518用户排名
    public static final String RES_KEY_USER_RANKING = "WDZJ_LUCKY_DRAW:USER_RANKING_";
    //518用户钻石
    public static final String RES_KEY_USER_FUNDS = "WDZJ_LUCKY_DRAW:USER_FUNDS_";
    //518用户钻石访问次数
    public static final String RES_KEY_USER_FUNDS_TIME = "WDZJ_LUCKY_DRAW:USER_FUNDS_TIMES_";
    //518用户钻石记录
    public static final String RES_KEY_USER_FUNDS_RECORDS = "WDZJ_LUCKY_DRAW:USER_FUNDS_RECORDS_";
    //用户交易redis锁key
    public static final String RES_KEY_USER_FUNDS_ADD = "WDZJ_LUCKY_DRAW:USER_FUNDS_ADD_";
    //用户兑换redis锁key
    public static final String RES_KEY_USER_EXCHANGE_PRIZE = "WDZJ_LUCKY_DRAW:USER_EXCHANGE_PRIZE_";

    //方块大通关游戏开始时间
    public static final String RES_KEY_USER_FANGKUAI_BEGIN_TIME = "WDZJ_LUCKY_DRAW:FANGKUAI_BEGIN_TIME_";
    //统计活动活动币
    public static final String RES_KEY_ACTIVITY_COIN_NUN = "WDZJ_LUCKY_DRAW:ACTIVITY_COIN_NUN";
    // 每日每活动最大抽奖次数
    public static final String DAY_PA_MAX_TIME = "WDZJ_LUCKY_DRAW:DAY_PA_MAX_TIME_%s_%s";
    public static final String REDIS_KEY_SHARE = "WDZJ_LUCKY_DRAW:REDIS_KEY_SHARE_%s_%s";
    public static final String REDIS_KEY_WINNERS_LIST_STATISTIC = "WDZJ_LUCKY_DRAW_WINNERS_LIST_STATISTIC_";
}
