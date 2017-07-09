package com.hrbust.feedback.service;

import java.util.List;

import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.util.Pager;

public interface TeacherService {
	
	/**
	 * 鏍规嵁鏁欏笀ID鍔犺浇鏁欏笀瀵硅薄 
	 * @param id
	 * @return
	 */
	public Teacher loadTeacher(int id);
	/**
	 * 淇敼鏁欏笀瀵嗙爜
	 * @param teacher
	 */
	public void updateTeacher(Teacher teacher);
	/**
	 * 通过教师工号加载学生对象
	 * @param account
	 * @return
	 */
	public Teacher loadTeacherByAccount(String account);
	/**
	 * 鏍规嵁瀛︾敓ID鏌ョ湅鏌愬鐢熸垚缁�
	 * @param id
	 * @return
	 */
	public List<Score> listStudentScore(int id);
	/**
	 * 鏍规嵁鐝骇鍙锋煡璇㈢彮绾у鐢�
	 * @param grade
	 * @return
	 */
	public List<Student> listStudentByGrade(String grade);
	/**
	 * 鏍规嵁璇剧▼id鍔犺浇璇剧▼
	 * @param course
	 * @return
	 */
	public Course loadCourse(int course);
	/**
	 * 閫氳繃璇剧▼鍚嶆煡璇㈡墍鏈夋暀鎺堣璇剧▼鐨勬暀甯�
	 * @param name
	 * @return
	 */
	public Pager<Teacher> findTeacherByCou_name(String name);
	/**
	 * 鏍规嵁鏁欏笀濮撳悕鏌ヨ鏁欏笀
	 * @param name
	 * @return
	 */
	public List<Teacher> listTeacherByName(String name);
	/**
	 * 澧炲姞鏁欏笀鍜岀彮绾т箣闂寸殑鍏崇郴
	 * @param tid
	 * @param grade
	 */
	public void addTeacherAndGrade(int []tid, Grade grade);
	/**
	 * 閫氳繃鏁欏笀id鍔犺浇鎵�暀鐨勫鐢�
	 * @param id
	 * @return
	 */
	public List<Student> listStudentByTeacher(int id);
	/**
	 * 鏌ヨ鏌愬绉戝鐢熺殑鎴愮哗
	 * @param stu_id
	 * @param course_id
	 * @return
	 */
	public Score loadScoreByCourse(int stu_id, int course_id);
	/**
	 * 澧炲姞鎴愮哗
	 * @param score
	 */
	public void addScore(Score score);
	
} 
