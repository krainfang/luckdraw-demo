package com.luckdraw.demo.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 类描述：日期工具类
 * 创建人：liming
 * 创建时间：2014-11-17下午1:29:41
 */
public class DateUtil {
	private static Log log = LogFactory.getLog(DateUtil.class);
	public static final String DATE_YYYY = "yyyy";
	public static final String DATE_M = "M";
	public static final String DATE_YYYYMM = "yyyyMM";
	public static final String DATE_YYYY_MM = "yyyy-MM";
	public static final String DATE_YYYY_YEAR_MM_MONTH = "yyyy年MM月";
	public static final String DATE_YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DATE_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_YYMMDDHHMM="yyyyMMddHHmm";
	public static final String DATE_YYMMDDHHMMSS="yyyyMMddHHmmss";
	public static final String DATE_YY_MM_DD_HHMM="yyyy-MM-dd HH:mm";
	public static final String DATE_YY_MM_DD_HHMMSS="yyyy-MM-dd HH:mm:ss";
	public static final String DATE_YYYY_YEAR_MM_MONTH_DAY = "yyyy年MM月dd日";
	public static final String DD_HHMMSS="dd天HH小时mm分ss秒";
	
	/**
	 * 
	 * 方法描述：格式化日期
	 * @param date
	 * @param pattern
	 * @return
	 * String
	 */
	public static String formatDate(Date date, String pattern){
		SimpleDateFormat sdf =new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 
	 * 方法描述：字符串日期转换
	 * @param dateStr
	 * @param pattern
	 * @return
	 * Date
	 */
	public static Date parseDate(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	Date date=null;
    	try {
			date= sdf.parse(dateStr);
		} catch (ParseException e) {
			log.error("日期转换异常", e);
		}
    	return date;
	}
	
	/**
	 * 
	 * 方法描述：计算两个日期相隔毫秒数<br/>
	 * @param startDate
	 * @param endDate
	 * @return
	 * long
	 */
	public static long calcDiffMillisecond(Date startDate, Date endDate){
		long start = startDate.getTime();
		long end = endDate.getTime();
		return end-start;
	}
	
	public static long getCurrentMinute(Date date){
		String dateStr=DateUtil.formatDate(date,DateUtil.DATE_YYMMDDHHMM);
		return Long.parseLong(dateStr);
	}
	
	 /**
     * 
     * 方法描述：在指定日期加几天
     * @param date
     * @param num
     * @return
     * @throws Exception
     * Date
     */
    public static Date addDay(Date date, Integer num) {
    	if(date==null || num==null){
    		log.error("参数不能为空");
    	}
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	int day=cal.get(Calendar.DATE);
    	cal.set(Calendar.DATE, day+num);
    	return cal.getTime();
    }
	
	public static Date addMinute(String dateStr, Integer num){
		Calendar cal = Calendar.getInstance();
    	cal.setTime(parseDate(dateStr,DATE_YY_MM_DD_HHMM));
    	cal.add(cal.MINUTE,num);
    	return cal.getTime();
    	
	}

	public static String getSystemDateYYYYMMDDHHmmss() {
		SimpleDateFormat bartDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return bartDateFormat.format(date);
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println(addMinute("2016-05-18 10:00",15));
		
		Date activityDate=DateUtil.parseDate("2016-05-18 22:15",DateUtil.DATE_YY_MM_DD_HHMM);
		
		System.out.println(DateUtil.addDay(activityDate, 3));
	}

	public static Date getTodyBegin() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}
}
