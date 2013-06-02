/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import com.zhjin.util.ArgMap;
import com.zhjin.util.Utility;

public class TestJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(Utility.encoderPassword("a2", "a2"));
	}
	
	private static void a(String s, String argname, TreeMap<Integer, String> sear) {
		int length = argname.length();
		int position = 0;
		while ((position = s.indexOf(":" + argname, position)) != -1 ) {
			sear.put(position, argname);
			position = position + length;
		}
	}

}
