package com.hrbust.feedback.util;

/**
 * ����û�����������Ƿ���ȷ
 */
public class CheckUtil {
	/**
	 * 
	 * @param pwd1   �û����������
	 * @param pwd2  �����ݿ��в�ѯ��������
	 * @return     ƥ����������ȷ
	 */
	public static boolean checkPassword(String pwd1, String pwd2) {
		if(pwd1.equals(pwd2)) {
			return true;
		}
		return false;
	}
}
