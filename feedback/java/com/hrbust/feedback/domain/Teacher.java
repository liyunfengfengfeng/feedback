package com.hrbust.feedback.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ��ʦ��
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {
	/**
	 * ID
	 */
	private int id;
	/**
	 * ��ʦ����
	 */
	private String tea_name;
	/**
	 * ��ʦ�˺�
	 */
	private String account;
	/**
	 * ��ʦ��¼����
	 */
	private String password;
	/**
	 * �Ա�
	 */
	private String gender;
	/**
	 * ��������
	 */
	private String birthday;
	/**
	 * ����
	 */
	private String nation;
	/**
	 * ��ʦ�����ڵĿγ�
	 */
	private Course course;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.ALL))
	@JoinColumn(name = "course_id")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	
}
