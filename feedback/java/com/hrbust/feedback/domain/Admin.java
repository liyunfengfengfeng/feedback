package com.hrbust.feedback.domain;
/**
 * ����Ա��
 * @author Administrator
 *
 */
public class Admin {
	/**
	 * ID
	 */
	private int id;
	/**
	 * ����Ա����
	 */
	private String name;
	/**
	 * ����Ա�˺�
	 */
	private String account;
	/**
	 * ����Ա��¼����
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
