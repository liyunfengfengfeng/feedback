package com.hrbust.feedback.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ѧ����
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_student")
public class Student {
	private int id;
	/**
	 * ѧ������
	 */
	private String stu_name;
	/**
	 * ѧ���˺�
	 */
	private String account;
	/**
	 * ѧ����¼����
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
	 * ѧ����Ӧ�ĳɼ�
	 */
	private Set<Score> scores = new HashSet<Score>();
	/**
	 * ѧ�������༶
	 */
	private Grade grade;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy="student", cascade=(CascadeType.ALL))
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	@ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.ALL))
	@JoinColumn(name = "grade_id")
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
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
