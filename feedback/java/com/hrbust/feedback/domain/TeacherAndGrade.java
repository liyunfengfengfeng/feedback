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
 * 老师和班级多对多的中间表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_teacher_grade")
public class TeacherAndGrade {
	private int id;
	private Teacher teacher;
	private Grade grade;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.ALL))
	@JoinColumn(name="teacher_id")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.ALL))
	@JoinColumn(name="grade_id")
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}	
