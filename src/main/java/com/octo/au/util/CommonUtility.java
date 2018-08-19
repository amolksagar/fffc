package com.octo.au.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Amol Kshirsagar
 *
 */
public class CommonUtility {

	public static String quote(String aText) {
		String QUOTE = "'";
		return QUOTE + aText + QUOTE;
	}

	public static String dateFormatConverter(String sourceDate, String targetFormat) {
		LocalDate date = LocalDate.parse(sourceDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(targetFormat);
		return formatter.format(date).toString();
	}
}
