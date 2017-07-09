package com.hrbust.feedback.dao;

import java.util.List;

import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.util.Pager;

public interface GradeDao extends BaseDao<Grade> {
	/**
	 * 澧炲姞鐝骇
	 * @param grade
	 */
	public void addGrade(Grade grade);
	/**
	 * 鏇存柊鐝骇淇℃伅
	 * @param grade
	 */
	public void updateGrade(Grade grade);
	/**
	 * 鍒犻櫎鏌愮彮绾�
	 * @param id
	 */
	public void deleteGrade(int id);
	/**
	 * 查询所有的班级
	 * @return
	 */
	public List<Grade> listAllGrade();
	/**
	 * 鏍规嵁id鍔犺浇鐝骇
	 * @param id
	 * @return
	 */
	public Grade loadGrade(int id);
	/**
	 * 鏍规嵁鐝骇鍚嶅姞杞界彮绾�
	 * @param name
	 * @return
	 */
	public Grade loadGradeByName(String name);
	/**
	 * 鏌ョ湅鎵�湁鐝骇
	 * @return
	 */
	public Pager<Grade> findGrades();
	/**
	 * 鏍规嵁鏁欏笀ID鏌ヨ璇ユ暀甯堟墍鏁欑彮绾�
	 * @param teacherId
	 * @return
	 */
	public List<Grade> listGradeByTeacher(int teacherId);
	/**
	 * 鍒犻櫎鏁欏笀鍜岀彮绾у叧绯�
	 * @param id
	 */
	public void deleteTeacherAndGrade(int id);
 	
}
