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
 * 成绩表
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_score")
public class Score {
	/**
	 * ID 
	 */
	private int id;
	/**
	 * 学生成绩
	 */
	private double score;
	/**
	 * 成绩所属科目
	 */
	private Course course;
	/**
	 * 成绩所属的学生
	 */
	private Student student;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.ALL))
	@JoinColumn(name="course_id")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@ManyToOne(fetch=FetchType.LAZY, cascade=(CascadeType.ALL))
	@JoinColumn(name="student_id")
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
