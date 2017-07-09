package com.hrbust.feedback.service;

import java.util.List;

import com.hrbust.feedback.domain.Admin;
import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.util.Pager;

public interface AdminService{
	/**
	 * 澧炲姞鏁欏笀瑙掕壊
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	/**
	 * 鎵归噺澧炲姞鏁欏笀瑙掕壊
	 * @param teacher
	 */
	public void addTeacher(List<Teacher> teacher);
	/**
	 * 添加学生到数据库
	 * @param student
	 */
	public void addStudent(Student student);
	/**
	 * 鎵归噺澧炲姞瀛︾敓瑙掕壊
	 * @param list
	 */
	public void addStudent(List<Student> list);
	/**
	 * 鍒犻櫎瀛︾敓瑙掕壊
	 * @param id
	 */
	public void deleteStudent(int id);
	/**
	 * 鎵归噺鍒犻櫎瀛︾敓
	 * @param list
	 */
	public void deleteStudent(List<Integer> list);
	/**
	 * 鍒犻櫎鑰佸笀瑙掕壊
	 * @param id
	 */
	public void deleteTeacher(int id);
	/**
	 * 鎵归噺鍒犻櫎瀛︾敓
	 * @param list
	 */
	public void deleteTeacher(List<Integer> list);
	/**
	 * 澧炲姞璇剧▼
	 * @param course
	 */
	public void addCourse(Course course);
	/**
	 * 鍒犻櫎璇剧▼
	 * @param id
	 */
	public void deleteCourse(int id);
	/**
	 * 澧炲姞鐝骇瀵硅薄
	 * @param garde
	 */
	public void addGrade(Grade grade);
	/**
	 * 鏇存柊鐝骇瀵硅薄
	 * @param grade
	 */
	public void updateGrade(Grade grade);
	/**
	 * 鍒犻櫎鐝骇瀵硅薄
	 * @param id
	 */
	public void deleteGrade(int id);
	/**
	 * 通过管理员工号查询管理员
	 * @param account
	 * @return
	 */
	public Admin loadAdminByAccount(String account);
	/**
	 * 鏍规嵁id鍔犺浇绠＄悊鍛樺璞�
	 * @param id
	 * @return
	 */
	public Admin loadAdminById(int id);
	/**
	 * 查询所有的班级
	 * @return
	 */
	public List<Grade> listAllGrade();
	/**
	 * 鏌ョ湅鎵�湁璇剧▼
	 * @return
	 */
	public List<Course> listAllCourse();
	/**
	 * 鏍规嵁id鍔犺浇鐝骇
	 * @param id
	 * @return
	 */
	public Grade loadGrade(int id);
	/**
	 * 鏍规嵁璇剧▼鍚嶅姞杞借绋�
	 * @param name
	 * @return
	 */
	public Course loadCourseByName(String name);
	/**
	 * 鏍规嵁鐝骇鍚嶅姞杞界彮绾�
	 * @param name
	 * @return
	 */
	public Grade loadGradeByName(String name);
	/**
	 * 鏌ョ湅鎵�湁瀛︾敓
	 * @return
	 */
	public Pager<Student> findStudents();
	/**
	 * 鏌ョ湅鎵�湁璇剧▼
	 * @return
	 */
	public Pager<Course> findCourses();
	/**
	 * 鏌ョ湅鎵�湁鏁欏笀
	 * @return
	 */
	public Pager<Teacher> findTeachers();
	/**
	 * 鏌ョ湅鎵�湁鐝骇
	 * @return
	 */
	public Pager<Grade> findGrades();
	/**
	 * 鏌ョ湅鎵�湁鏁欏笀
	 * @return
	 */
	public List<Teacher> listTeachers();
	/**
	 * 鏍规嵁鐝骇id鏌ョ湅鐝骇鎵��鐨勮绋�
	 */
	public List<Course> listCourseByGrade(int id);
	
}
