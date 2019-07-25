package com.clark.online.edu.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期处理工具类
 * @author 大仙
 *
 */
public class DateUtil {
	/**
	 * 年月日时分秒
	 */
	public static final String YMDHMS = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 年月日
	 */
	public static final String YMD  = "yyyy-MM-dd";
	/**
	 * 时分
	 */
	public static final String HM = "HH:mm";
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getNowDateTime() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(YMDHMS);
		return LocalDateTime.now().format(format);
	}

}
