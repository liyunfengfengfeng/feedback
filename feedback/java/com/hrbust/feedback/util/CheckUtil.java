package com.hrbust.feedback.util;

/**
 * 检查用户输入的密码是否正确
 */
public class CheckUtil {
	/**
	 * 
	 * @param pwd1   用户输入的密码
	 * @param pwd2  从数据库中查询到的密码
	 * @return     匹配则输入正确
	 */
	public static boolean checkPassword(String pwd1, String pwd2) {
		if(pwd1.equals(pwd2)) {
			return true;
		}
		return false;
	}
}
