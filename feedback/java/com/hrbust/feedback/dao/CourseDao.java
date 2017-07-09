package com.hrbust.feedback.dao;

import java.util.List;

import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.util.Pager;

public interface CourseDao extends BaseDao<Course>{
	/**
	 * 增加课程
	 * @param course
	 */
	public void addCourse(Course course);
	/**
	 * 根据ID删除课程
	 * @param id
	 */
	public void deleteCourse(int id);
	/**
	 * 更新课程信息
	 * @param course
	 */
	public void updateCourse(Course course);
	/**
	 * 根据学生ID查询学生所选课程
	 * @param studentId
	 * @return
	 */
	public List<Course> listCourseByStudent(int studentId); 
	/**
	 * 查看所有课程
	 * @return
	 */
	public List<Course> listAllCourse();
	/**
	 * 根据课程id加载课程
	 * @param id
	 * @return
	 */
	public Course loadCourse(int id);
	/**
	 * 根据课程名加载课程
	 * @param name
	 * @return
	 */
	public Course loadCourseByName(String name);
	/**
	 * 查看所有课程
	 * @return
	 */
	public Pager<Course> findCourses();
	/**
	 * 删除学生和班级关系
	 * @param id
	 */
	public void deleteStudentAndCourse(int id);
	/**
	 * 根据教师id查看班级所选的课程
	 */
	Course listCourseByGrade(int id);
}
