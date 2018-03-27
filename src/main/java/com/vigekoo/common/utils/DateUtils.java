package com.vigekoo.common.utils;

import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import com.vigekoo.common.exception.AppException;

/**
 * @author sxia
 * @Description: TODO(日期处理)
 * @date 2017-6-23 15:07
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/** 时间格式( HH:mm:ss) */
	public final static String TIME_PATTERN = "HH:mm:ss";

	public static String format(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 统计两个日期之间包含的天数。
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDayDiff(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			throw new InvalidParameterException("date1 and date2 cannot be null!");
		}
		long millSecondsInOneDay = 24 * 60 * 60 * 1000;
		return (int) ((date1.getTime() - date2.getTime()) / millSecondsInOneDay);
	}

	/**
	 * 根据用户输入 的时间转换成int类型
	 * 
	 * @param timeStr
	 * @return
	 */
	public static int timeToSec(String timeStr) {
		if (StringUtils.isEmpty(timeStr)) {
			throw new InvalidParameterException("time string cannot be null!");
		}
		int hours = 0;
		int mins = 0;
		int secs = 0;
		// format HH:mm:ss
		String[] timeArr = timeStr.split(":");
		if (ArrayUtils.isNotEmpty(timeArr) && timeArr.length >= 3) {
			hours = Integer.parseInt(timeArr[0]);
			mins = Integer.parseInt(timeArr[1]);
			secs = Integer.parseInt(timeArr[2]);
		} else if (Pattern.matches("(\\d{0,2}时){0,1}(\\d{0,2}分){0,1}(\\d{0,2}秒)", timeStr)) {
			hours = getNumByIndex(timeStr, "时"); 
			
			timeStr = timeStr.substring(timeStr.indexOf("时") +1);
			mins = getNumByIndex(timeStr, "分"); 
			
			timeStr = timeStr.substring(timeStr.indexOf("分")+1);
			secs = getNumByIndex(timeStr, "秒"); 
		} else {
			throw new AppException("请输入正确的时长格式");
		}

		return hours * 3600 + mins * 60 + secs;
	}

	private static int getNumByIndex(String timeStr,String chars) {
		int num = 0;
		if (timeStr.indexOf(chars) != -1) { 
			int hoursIndex = timeStr.indexOf(chars) - 2 >= 0 ? timeStr.indexOf(chars) - 2 : timeStr.indexOf(chars) - 1;
			num = Integer.valueOf(timeStr.substring(hoursIndex, timeStr.indexOf(chars)));
		}
		return num;
	}

	public static String secToTime(int time) {
		String timeStr = null;
		int hour = 0;
		int minute = 0;
		int second = 0;
		if (time <= 0)
			return "00:00";
		else {
			minute = time / 60;
			if (minute < 60) {
				second = time % 60;
				timeStr = unitFormat(minute) + ":" + unitFormat(second);
			} else {
				hour = minute / 60;
				if (hour > 99)
					return "99:59:59";
				minute = minute % 60;
				second = time - hour * 3600 - minute * 60;
				timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
			}
		}
		return timeStr;
	}

	private static String unitFormat(int i) {
		String retStr = null;
		if (i >= 0 && i < 10)
			retStr = "0" + Integer.toString(i);
		else
			retStr = "" + i;
		return retStr;
	}
}
