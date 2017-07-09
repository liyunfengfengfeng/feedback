package com.hrbust.feedback.service;

import java.util.List;

import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.util.Pager;

public interface StudentService {
	/**
	 * 鏌ョ湅鑷繁鐨勬垚缁�
	 * @param student_id
	 * @return
	 */
	public List<Score> listStudentScore(int id);
	/**
	 * 鏌ョ湅瀛︾敓鍩烘湰淇℃伅
	 * @param stuentId
	 * @return
	 */
	public Student loadStudent(int id);
	/**
	 * 淇敼瀛︾敓鐧诲綍瀵嗙爜
	 * @param student
	 */
	public void updateStudent(Student student);
	/**
	 * 通过学号加载学生
	 * @param account
	 * @return
	 */
	public Student loadStudentByAccount(String account);
	/**
	 * 閫氳繃瀛︾敓濮撳悕鏌ユ壘瀛︾敓
	 * @param name
	 * @return
	 */
	public List<Student> listStudentByName(String name);
	/**
	 * 閫氳繃鐝骇鍙锋煡璇㈠鐢燂紙鍒嗛〉锛�
	 * @param name
	 * @return
	 */
	public Pager<Student> findStudentByGra_name(String name);
	/**
	 * 添加学生与课程的关系
	 */
	public void addStudentAndCourse(int[] cid, Student student);
	/**
	 * 添加学生与老师的关系
	 * @param cid
	 * @param student
	 */
	public void addTeacherAndStudent(int cid, Student student);
	
}
