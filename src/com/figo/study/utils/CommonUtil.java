package com.figo.study.utils;

public class CommonUtil {
	public static void printStacktrace(Exception e) {
		try {
			if (e != null) {
				e.printStackTrace();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
