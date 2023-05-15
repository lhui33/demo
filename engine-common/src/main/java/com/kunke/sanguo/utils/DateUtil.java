package com.kunke.sanguo.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <b>类名：</b>DateUtil<br>
 * <b>功能：</b>日期时间工具类<br>
 * <li>版本&nbsp;&nbsp;&nbsp;&nbsp;修改日期&nbsp;&nbsp;&nbsp;&nbsp;部　　门&nbsp;&nbsp;&nbsp;&nbsp;作　者&nbsp;&nbsp;&nbsp;&nbsp;变更内容</li>
 * <hr>
 * <li>
 * v1.0&nbsp;&nbsp;&nbsp;&nbsp;20130531&nbsp;&nbsp;技术中心&nbsp;&nbsp;&nbsp;&nbsp;商良磊&nbsp;&nbsp;&nbsp;&nbsp;创建类
 * </li>
 * <br><br>
 * @author 商良磊
 * @version 20130531
 *
 */
public class DateUtil {
	
	/**
	 * 禁止实例化，形成单例类静态方法集
	 */
	private DateUtil() {}
	
	/**
	 * <b>功能描述：</b>Date转换为Calendar。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期类
	 * @return Calendar 日历类
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	/**
	 * <b>功能描述：</b>Calendar转换为Date。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历类
	 * @return Date 日期类
	 */
	public static Date calendarToDate(Calendar calendar) {
		return calendar.getTime();
	}
	
	/**
	 * <b>功能描述：</b>获得年份。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 年份
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	/**
	 * <b>功能描述：</b>获得年份。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 年份
	 */
	public static int getYear(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.YEAR);
		} else {
			return DateUtil.getYear();
		}
	}
	/**
	 * <b>功能描述：</b>获得年份。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 年份
	 */
	public static int getYear(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.YEAR);
		} else {
			return DateUtil.getYear();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得月份，从0开始计算，既月份为0-11。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 月份
	 */
	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}
	/**
	 * <b>功能描述：</b>获得月份，从0开始计算，既月份为0-11。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 月份
	 */
	public static int getMonth(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.MONTH);
		} else {
			return DateUtil.getMonth();
		}
	}
	/**
	 * <b>功能描述：</b>获得月份，从0开始计算，既月份为0-11。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 月份
	 */
	public static int getMonth(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.MONTH);
		} else {
			return DateUtil.getMonth();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得日（号）。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 日（号）
	 */
	public static int getDayOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * <b>功能描述：</b>获得日（号）。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 日（号）
	 */
	public static int getDayOfMonth(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.DAY_OF_MONTH);
		} else {
			return DateUtil.getDayOfMonth();
		}
	}
	/**
	 * <b>功能描述：</b>获得日（号）。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 日（号）
	 */
	public static int getDayOfMonth(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.DAY_OF_MONTH);
		} else {
			return DateUtil.getDayOfMonth();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得某月的天数。<br>
	 * <b>修订记录：</b><br>
	 * <li>20120929&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param year 年数
	 * @param month 月数
	 * @return int 月总共天数
	 */
	
	public static int getTotalDaysOfMonth(int year, int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,year);
		calendar.set(Calendar.MONTH, month - 1);//Java月份从0开始算
		return calendar.getActualMaximum(Calendar.DATE);
	}
	
	/**
	 * <b>功能描述：</b>获得星期几，周日为0，以此类推。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 星期几
	 */
	public static int getDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * <b>功能描述：</b>获得星期几，周日为1，以此类推。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <li>20121008&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;修改返回值说明</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 星期几
	 */
	public static int getDayOfWeek(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.DAY_OF_WEEK);
		} else {
			return DateUtil.getDayOfWeek();
		}
	}
	/**
	 * <b>功能描述：</b>获得星期几，周日为0，以此类推。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 星期几
	 */
	public static int getDayOfWeek(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.DAY_OF_WEEK);
		} else {
			return DateUtil.getDayOfWeek();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得小时，24小时制。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 小时
	 */
	public static int getHourOfDay() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}
	/**
	 * <b>功能描述：</b>获得小时，24小时制。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 小时
	 */
	public static int getHourOfDay(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.HOUR_OF_DAY);
		} else {
			return DateUtil.getHourOfDay();
		}
	}
	/**
	 * <b>功能描述：</b>获得小时，24小时制。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 小时
	 */
	public static int getHourOfDay(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.HOUR_OF_DAY);
		} else {
			return DateUtil.getHourOfDay();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得小时，12小时制。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 小时
	 */
	public static int getHour() {
		return Calendar.getInstance().get(Calendar.HOUR);
	}
	/**
	 * <b>功能描述：</b>获得小时，12小时制。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 小时
	 */
	public static int getHour(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.HOUR);
		} else {
			return DateUtil.getHour();
		}
	}
	/**
	 * <b>功能描述：</b>获得小时，12小时制。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 小时
	 */
	public static int getHour(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.HOUR);
		} else {
			return DateUtil.getHour();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得分钟。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 分钟
	 */
	public static int getMinute() {
		return Calendar.getInstance().get(Calendar.MINUTE);
	}
	/**
	 * <b>功能描述：</b>获得分钟。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 分钟
	 */
	public static int getMinute(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.MINUTE);
		} else {
			return DateUtil.getMinute();
		}
	}
	/**
	 * <b>功能描述：</b>获得分钟。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 分钟
	 */
	public static int getMinute(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.MINUTE);
		} else {
			return DateUtil.getMinute();
		}
	}
	
	/**
	 * <b>功能描述：</b>获得秒钟。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return int 秒钟
	 */
	public static int getSecond() {
		return Calendar.getInstance().get(Calendar.SECOND);
	}
	/**
	 * <b>功能描述：</b>获得秒钟。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date 日期对象
	 * @return int 秒钟
	 */
	public static int getSecond(Date date) {
		if(null != date) {
			return DateUtil.dateToCalendar(date).get(Calendar.SECOND);
		} else {
			return DateUtil.getSecond();
		}
	}
	/**
	 * <b>功能描述：</b>获得秒钟。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar 日历对象
	 * @return int 秒钟
	 */
	public static int getSecond(Calendar calendar) {
		if(null != calendar) {
			return calendar.get(Calendar.SECOND);
		} else {
			return DateUtil.getSecond();
		}
	}

	/**
	 * <b>功能描述：</b>转换字符串形式的日期为Date类型，字符串形式通过参数指定。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date String 字符串形式日期
	 * @param pattern String 时间格式
	 * @return Date 转换后的Date对象
	 * @throws ParseException
	 */
	public static Date stringToDate(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(null != date) {
			try {
				return sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
	/**
	 * <b>功能描述：</b>转换字符串形式的日期为Date类型，字符串形式为yyyy-MM-dd。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date String 字符串形式日期
	 * @return Date 转换后的Date对象
	 * @throws ParseException
	 */
	public static Date stringToDate(String date) {
		return DateUtil.stringToDate(date, "yyyy-MM-dd");
	}
	/**
	 * <b>功能描述：</b>转换字符串形式的时间为Date类型，字符串形式为HH:mm:ss。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param time String 字符串形式时间
	 * @return Date 转换后的Date对象
	 * @throws ParseException
	 */
	public static Date stringToTime(String time) throws ParseException {
		return DateUtil.stringToDate(time, "HH:mm:ss");
	}
	
	/**
	 * <b>功能描述：</b>转换字符串形式的日期为Calendar类型，字符串形式通过参数指定。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date String 字符串形式日期
	 * @param pattern String 时间格式
	 * @return Calendar 转换后的Calendar对象
	 * @throws ParseException
	 */
	public static Calendar stringToCalendar(String date, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(null != date) {
			return DateUtil.dateToCalendar(sdf.parse(date));
		} else {
			return null;
		}
	}
	/**
	 * <b>功能描述：</b>转换字符串形式的日期为Calendar类型，字符串形式为yyyy-MM-dd。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date String 字符串形式日期
	 * @return Calendar 转换后的Calendar对象
	 * @throws ParseException
	 */
	public static Calendar stringToCalendar(String date) throws ParseException {
		return DateUtil.stringToCalendar(date, "yyyy-MM-dd");
	}
	
	/**
	 * <b>功能描述：</b>转换Date类型为字符串形式，字符串形式通过参数指定。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date Date对象
	 * @param pattern String 时间格式
	 * @return String 日期指定格式的字符串形式
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(null != date) {
			return sdf.format(date);
		} else {
			return null;
		}
	}
	/**
	 * <b>功能描述：</b>转换当前时间为字符串形式，字符串形式通过参数指定。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param pattern String 时间格式
	 * @return String 日期指定格式的字符串形式
	 */
	public static String dateToString(String pattern) {
		return DateUtil.dateToString(new Date(), pattern);
	}
	/**
	 * <b>功能描述：</b>转换Date类型为字符串形式，字符串形式为yyyy-MM-dd。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param date Date Date对象
	 * @return String yyyy-MM-dd格式日期字符串
	 */
	public static String dateToString(Date date) {
		return DateUtil.dateToString(date, "yyyy-MM-dd");
	}
	/**
	 * <b>功能描述：</b>转换当前时间为字符串形式，字符串形式为yyyy-MM-dd。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return String yyyy-MM-dd格式日期字符串
	 */
	public static String dateToString() {
		return DateUtil.dateToString("yyyy-MM-dd");
	}
	/**
	 * <b>功能描述：</b>转换当前时间为字符串形式，字符串形式为yyyy-MM-dd。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return String yyyy-MM-dd格式日期字符串
	 */
	public static String dateTimeToString(Date date) {
		return DateUtil.dateToString("yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * <b>功能描述：</b>转换Date类型为字符串形式，字符串形式为HH:mm:ss。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param time 对象
	 * @return String HH:mm:ss格式日期字符串
	 */
	public static String timeToString(Date time) {
		return DateUtil.dateToString(time, "HH:mm:ss");
	}
	/**
	 * <b>功能描述：</b>转换当前时间为字符串形式，字符串形式为HH:mm:ss。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @return String HH:mm:ss格式日期字符串
	 */
	public static String timeToString() {
		return DateUtil.dateToString("HH:mm:ss");
	}
	
	/**
	 * <b>功能描述：</b>转换Calendar类型为字符串形式，字符串形式通过参数指定。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar calendar对象
	 * @param pattern String 时间格式
	 * @return String 日期指定格式的字符串形式
	 */
	public static String calendarToString(Calendar calendar, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if(null != calendar) {
			return sdf.format(calendar);
		} else {
			return null;
		}
	}
	/**
	 * <b>功能描述：</b>转换Calendar类型为字符串形式，字符串形式为yyyy-MM-dd。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar calendar对象
	 * @return String yyyy-MM-dd格式日期字符串
	 */
	public static String dateToString(Calendar calendar) {
		return DateUtil.calendarToString(calendar, "yyyy-MM-dd");
	}
	/**
	 * <b>功能描述：</b>转换Calendar类型为字符串形式，字符串形式为HH:mm:ss。<br>
	 * <b>修订记录：</b><br>
	 * <li>20130531&nbsp;&nbsp;|&nbsp;&nbsp;商良磊&nbsp;&nbsp;|&nbsp;&nbsp;创建方法</li>
	 * <br><br>
	 * @param calendar Calendar calendar对象
	 * @return String HH:mm:ss格式日期字符串
	 */
	public static String timeToString(Calendar calendar) {
		return DateUtil.calendarToString(calendar, "HH:mm:ss");
	}

	/**
	 * 本日开始
	 * @param n 0为今天 1为明天 -1为昨天
	 * @return
	 */
	public static Date getDayBegin(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 本日结束
	 * @param n 0为今天 1为明天 -1为昨天
	 * @return
	 */
	public static Date getDayEnd(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取周开始日期，0为本周 -1为上周 1为下周，以此类推
	 * @return
	 */
	public static Date getWeekBeginDay(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n * 7);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取周结束日期，0为本周 -1为上周 1为下周，以此类推
	 * @return
	 */
	public static Date getWeekEndDay(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n * 7);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取月第一天 0当月 -1上月 1下月 以此类推
	 * @param n
	 * @return
	 */
	public static Date getMonthBegin(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, n);
		cal.set(Calendar.DAY_OF_MONTH, 1);//1:本月第一天
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取月最后一天 0当月 -1上月 1下月 以此类推
	 * @param n
	 * @return
	 */
	public static Date getMonthEnd(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, n);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));//本月最后一天
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取年第一天 0当年 -1去年 1明年 以此类推
	 * @param n
	 * @return
	 */
	public static Date getYearBegin(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, n);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取年最后一天 0当年 -1去年 1明年 以此类推
	 * @param n
	 * @return
	 */
	public static Date getYearEnd(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, n);
		cal.set(Calendar.DAY_OF_YEAR, cal.getActualMaximum(Calendar.DAY_OF_YEAR));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 季度第一天
	 * @param lastSeason true 上季度 false 本季度
	 * @return
	 */
	public static Date getSeasonBegin(boolean lastSeason) {
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH) + 1;
		int season = 0;
		if (currentMonth >= 1 && currentMonth <= 3) {
			season = 1;
		} else if (currentMonth >= 4 && currentMonth <= 6) {
			season = 2;
		} else if (currentMonth >= 7 && currentMonth <= 9) {
			season = 3;
		} else if (currentMonth >= 10 && currentMonth <= 12) {
			season = 4;
		}

		if (lastSeason) {
			season = season - 1;
			if (season == 0) {
				cal.add(Calendar.YEAR, -1);
				season = 4;
			}
		}

		switch (season) {
			case 1:
				cal.set(Calendar.MONTH, Calendar.JANUARY);
				break;
			case 2:
				cal.set(Calendar.MONTH, Calendar.APRIL);
				break;
			case 3:
				cal.set(Calendar.MONTH, Calendar.JULY);
				break;
			case 4:
				cal.set(Calendar.MONTH, Calendar.OCTOBER);
				break;
		}

		cal.set(Calendar.DAY_OF_MONTH, 1);//1:本月第一天
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	/**
	 * 季度最后一天
	 * @param lastSeason true 上季度 false 本季度
	 * @return
	 */
	public static Date getSeasonEnd(boolean lastSeason) {
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH) + 1;
		int season = 0;
		if (currentMonth >= 1 && currentMonth <= 3) {
			season = 1;
		} else if (currentMonth >= 4 && currentMonth <= 6) {
			season = 2;
		} else if (currentMonth >= 7 && currentMonth <= 9) {
			season = 3;
		} else if (currentMonth >= 10 && currentMonth <= 12) {
			season = 4;
		}

		if (lastSeason) {
			season = season - 1;
			if (season == 0) {
				cal.add(Calendar.YEAR, -1);
				season = 4;
			}
		}

		switch (season) {
			case 1:
				cal.set(Calendar.MONTH, Calendar.MARCH);
				break;
			case 2:
				cal.set(Calendar.MONTH, Calendar.JUNE);
				break;
			case 3:
				cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
				break;
			case 4:
				cal.set(Calendar.MONTH, Calendar.DECEMBER);
				break;
		}

		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));//本月最后一天
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}


	public static Date getPassDay(int n) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, n);

		return cal.getTime();
	}

	public static Date getPassMonth(int n, Date date) {
		Calendar cal = DateUtil.dateToCalendar(date);
		cal.add(Calendar.MONTH, n);

		return cal.getTime();
	}

	/**
	 * 获取今天是本年第几周，0开始，与mysql对齐
	 * @return
	 */
	public static int getYearOfWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		return calendar.get(Calendar.WEEK_OF_YEAR) - 1;
	}

	/**
	 * 获取今天是本年第几周，0开始，与mysql对齐
	 * @return
	 */
	public static int getYearOfWeek(Date date) {
		Calendar calendar = DateUtil.dateToCalendar(date);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		return calendar.get(Calendar.WEEK_OF_YEAR) - 1;
	}

	/**
	 * 获取今天是本年第几周，0开始，与mysql对齐
	 * @return
	 */
	public static String getYearOfWeekPass(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, n * 7);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		Integer week = calendar.get(Calendar.WEEK_OF_YEAR) - 1;
		return week < 10 ? "0" + week : week.toString();
	}

	/**
	 * 获取今天是本年第几周，0开始，与mysql对齐
	 * @return
	 */
	public static Date getYearOfWeekPassDate(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, n * 7);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		return calendar.getTime();
	}

	/**
	 * 获取秒级时间戳
	 * @param date
	 * @return
	 */
	public static Integer getSecondTimestamp(Date date) {
		Long time = date.getTime();
		Long secondsTime = time / 1000L;
		return secondsTime.intValue();
	}

	public static Calendar dataToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	public static Date calendarToData(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();//日历类的实例化
		calendar.set(year, month - 1, day);//设置日历时间，月份必须减一
		Date date = calendar.getTime(); // 从一个 Calendar 对象中获取 Date 对象
		return date;
	}

	/**
	 * 过去了几个小时，不足一小时不算
	 * @param prev		开始时间
	 * @param current	结束时间
	 * @return	小时
	 */
	public static Integer passHours(Date prev, Date current) {
		long hourTimeStamp = 3600 * 1000L;
		long passMis = current.getTime() - prev.getTime();
		double passHour = Math.floor((double) passMis / (double) hourTimeStamp);
		return (int) passHour;
	}


	public static void main(String[] args) {
		String pattern = "yyyy-MM-dd HH:mm:ss";
//		String res = DateUtil.dateToString(DateUtil.getPassDay(-14), pattern);
//		System.out.println(res);
//		System.out.println(DateUtil.getYear());
		Date prev = DateUtil.stringToDate("2023-03-07 9:58:23", pattern);
		Date current = DateUtil.stringToDate("2023-03-07 10:59:23", pattern);
	}
	
}