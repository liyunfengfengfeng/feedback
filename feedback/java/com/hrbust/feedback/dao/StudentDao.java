package com.hrbust.feedback.dao;


import java.util.List;

import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.util.Pager;

public interface StudentDao extends BaseDao<Student> {
	/**
	 * 添加学生
	 * @param student
	 */
	public void addStudent(Student student);
	/**
	 * 鏇存柊瀛︾敓璁板綍
	 * @param student
	 */
	public void updateStudent(Student student);
	/**
	 * 鍒犻櫎瀛︾敓璁板綍
	 * @param id
	 */
	public void deleteStudent(int id);
	/**
	 * 鏍规嵁瀛︾敓ID鍔犺浇瀛︾敓瀵硅薄
	 * @param id
	 * @return
	 */
	public Student loadStudent(int id);
	/**
	 * 鏍规嵁鐝骇ID鏌ヨ瀛︾敓
	 * @param gradeId
	 * @return
	 */
	public Pager<Student> findStudentByGrade(int gradeId);
	/**
	 * 鏍规嵁鐝骇ID鏌ヨ瀛︾敓
	 * @param gradeId
	 * @return
	 */
	public List<Student> listStudentByGrade(int gradeId);
	/**
	 * 添加学生与课程的关系
	 * @param student
	 * @param course
	 */
	public void addStudentAndCourse(Student student ,Course course);
	/**
	 * 鍔犺浇瀛︾敓鍜岃绋嬬殑鍏崇郴
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public int loadStudentAndCourse(int studentId ,int courseId);
	/**
	 * 通过学号加载学生对象
	 * @param account
	 * @return
	 */
	public Student loadStudentByAccount(String account);
	/**
	 * 閫氳繃濮撳悕鏌ユ壘瀛︾敓
	 * @param name
	 * @return
	 */
	public List<Student> listStudentByName(String name);
	/**
	 * 閫氳繃鐝骇鍙锋煡璇㈢彮绾у鐢�娌℃湁鍒嗛〉)
	 * @return
	 */
	public List<Student> listStudentByGra_ame(String name);
	/**
	 * 鏌ョ湅鎵�湁瀛︾敓锛堝垎椤碉級
	 * @return
	 */
	public Pager<Student> findStudents();
	/**
	 * 閫氳繃鐝骇鍙锋煡璇㈢彮绾у鐢�鏈夊垎椤�
	 * @return
	 */
	public Pager<Student> findStudentByGra_name(String name);
	/**
	 * 鏍规嵁鏁欏笀ID鏌ヨ鎵�湁璇ユ暀甯堟暀鐨勫鐢�
	 * @param teacherId
	 * @return
	 */
	public List<Student> listStudentByTeacher(int teacherId);
	/**
	 * 鍒犻櫎鏁欏笀鍜屽鐢熷叧绯�
	 * @param id
	 */
	public void deleteTeacherAndStudent(int id);
	/**
	 * 鍒犻櫎瀛︾敓鍜岃绋嬪叧绯�
	 * @param id
	 */
	public void deleteStudentAndCourse(int id);
	
} 
