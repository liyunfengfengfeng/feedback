package com.hrbust.feedback.dao;

import java.util.List;

import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.util.Pager;

public interface ScoreDao extends BaseDao<Score> {
	/**
	 * 增加一条分数记录
	 * @param score
	 */
	public void addScore(Score score);
	/**
	 * 更新一条记录
	 * @param score
	 */
	public void updateScore(Score score);
	/**
	 * 删除一条记录
	 * @param score
	 */
	public void delteScore(int id);
	/**
	 * 根据课程ID查出所有本课程成绩(没有分页)
	 * @param courseId
	 * @return
	 */
	public List<Score> listScoreByCourse(int courseId);
	/**
	 * 根据课程ID查出所有本课程成绩(有分页)
	 * @param courseId
	 * @return
	 */
	public Pager<Score> findScoreByCourse(int courseId);
	/**
	 * 根据学生ID查出该学生成绩(没有分页)
	 * @param studentId
	 * @return
	 */
	public List<Score> listScoreByStudent(int studentId);
	/**
	 * 根据学生ID查出该学生成绩(有分页)
	 * @param studentId
	 * @return
	 */
	public Pager<Score> findScoreByStudent(int studenId);
	/**
	 * 查询某学科学生的成绩
	 * @param stu_id
	 * @param cou_id
	 * @return
	 */
	public Score loadScoreByCourse(int stu_id, int cou_id);

}   
