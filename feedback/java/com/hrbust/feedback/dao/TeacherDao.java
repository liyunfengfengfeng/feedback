package com.hrbust.feedback.dao;

import java.util.List;

import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.util.Pager;

public interface TeacherDao extends BaseDao<Teacher> {
	/**
	 * 澧炲姞鏁欏笀
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);
	/**
	 * 鏇存柊鏁欏笀淇℃伅
	 * @param teacher
	 */
	public void updateTeacher(Teacher teacher);
	/**
	 * 鍒犻櫎鏁欏笀淇℃伅
	 * @param teacherId
	 */
	public void deleteTeacher(int teacherId);
	/**
	 * 鏍规嵁鏁欏笀ID鍔犺浇鏁欏笀瀵硅薄
	 * @param id
	 * @return
	 */
	public Teacher loadTeacher(int id);
	/**
	 * 添加老师与学生的关系
	 * @param teacher
	 * @param student
	 */
	public void addTeacherAndStudent(Teacher teacher ,Student student);
	/**
	 * 娣诲姞鑰佸笀鍜岀彮绾т箣闂寸殑鍏崇郴
	 * @param teacher
	 * @param grade
	 */
	public void addTeacherAndGrade(Teacher teacher ,Grade grade);
	/**
	 * 鍔犺浇鏁欏笀鍜屽鐢熷叧绯�
	 * @param teacherId
	 * @param studentId
	 * @return
	 */
	public int loadTeacherAndStudent(int teacherId ,int studentId);
	/**
	 * 鍔犺浇鏁欏笀鍜屾垚缁╁叧绯�
	 * @param teacherId
	 * @param gradeId
	 * @return
	 */
	public int loadTeacherAndGrade(int teacherId ,int gradeId);
	/**
	 * 鏍规嵁璇剧▼ID鏌ヨ鏁欏笀
	 * @param courseId
	 * @return
	 */
	public Pager<Teacher> findTeacherByCourse(int courseId);
	/**
	 * 通过工号查询学生信息
	 * @param account
	 * @return
	 */
	public Teacher loadTeacherByAccount(String account);
	/**
	 * 鏌ョ湅鎵�湁鏁欏笀
	 * @return
	 */
	public Pager<Teacher> findTeachers();
	/**
	 * 鏌ョ湅鎵�湁鏁欏笀
	 * @return
	 */
	public List<Teacher> listTeachers();
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
	 * 鏍规嵁鐝骇id鍔犺浇鏁欏笀
	 * @param gid
	 * @return
	 */
	public List<Teacher> listTeacherByGrade(int gid);
	/**
	 * 鍒犻櫎鏁欏笀鍜岀彮绾у叧绯�
	 * @param id
	 */
	public void deleteTeacherAndGrade(int id);
	/**
	 * 鍒犻櫎鏁欏笀鍜屽鐢熷叧绯�
	 * @param id
	 */
	public void deleteTeacherAndStudent(int id);
}
