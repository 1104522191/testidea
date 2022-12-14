package com.test.util;

public class StringUtils {
	// ˽�еĹ��췽�����������಻�����ⲿʵ����
	private StringUtils() {
	}

	/**
	 * ����ַ�������null��ȥ�ո�����""���򷵻�true�����򷵻�false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isBlank(String s) {
		boolean b = false;
		if (null == s || s.trim().equals("")) {
			b = true;
		}
		return b;
	}
	
	/**
	 * ����ַ���������null��ȥ�ո�󲻵���""���򷵻�true�����򷵻�false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNotBlank(String s) {
		return !isBlank(s);
	}

}
