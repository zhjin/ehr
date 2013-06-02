/**
 * Copyright zhangjin(zhjin@vip.163.com)
 * Licensed under GNU GENERAL PUBLIC LICENSE
 */
package com.zhjin.test;

import java.io.File;
import java.net.URL;
import java.util.Date;

import com.zhjin.util.User;

public class Testpg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
			System.out.println("0:abc".substring(2));

		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	private static User getUser() {
		return new User();
	}

}
