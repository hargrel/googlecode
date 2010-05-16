package edu.itee.antipodes.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UtilityManager {

	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String myDate = simpleDateFormat.format(date);
		return myDate;
	} 	

	public static Date stringToDate(String date, String pattern) throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern);
		Date myDate = df.parse(date);
		return myDate;
	}
	
	public static Date stringToDate(String date) throws ParseException {
		return stringToDate(date, "dd/MM/yyyy");
	}
}

