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
 * 教师表
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
	 * 教师姓名
	 */
	private String tea_name;
	/**
	 * 教师账号
	 */
	private String account;
	/**
	 * 教师登录密码
	 */
	private String password;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 教师所教授的课程
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
