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
 * 班级表
 * @author Administrator
 *
 */
@Entity
@Table(name="t_grade")
public class Grade {
	/**
	 * ID
	 */
	private int id;
	/**
	 * 班级名
	 */
	private String gra_name;
	/**
	 * 班级所包含的学生
	 */
	private Set<Student> students = new HashSet<Student>();
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGra_name() {
		return gra_name;
	}
	public void setGra_name(String gra_name) {
		this.gra_name = gra_name;
	}
	@OneToMany(mappedBy="grade",cascade=(CascadeType.ALL))
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
