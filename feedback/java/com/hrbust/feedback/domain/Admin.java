package com.hrbust.feedback.domain;
/**
 * 管理员表
 * @author Administrator
 *
 */
public class Admin {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 管理员名称
	 */
	private String name;
	/**
	 * 管理员账号
	 */
	private String account;
	/**
	 * 管理员登录密码
	 */
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
