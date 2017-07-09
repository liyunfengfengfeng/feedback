package com.hrbust.feedback.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * 课程表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_course")
public class Course {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 课程名
	 */
	private String cou_name;
	/**
	 * 一个课程对应多个教师
	 */
	private Set<Teacher> teachers = new HashSet<Teacher>();
	
	/**
	 * 一个课程包含多个学生成绩
	 */
	private Set<Score> scores = new HashSet<Score>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}
	
	@OneToMany(mappedBy="course", cascade=(CascadeType.ALL))
	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	@OneToMany(mappedBy="course", cascade=(CascadeType.ALL))
	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
}
