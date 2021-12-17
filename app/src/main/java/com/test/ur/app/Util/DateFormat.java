package com.test.ur.app.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	public static String dateToString(String dateFormat) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
}
