package com.hrbust.feedback.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbust.feedback.dao.ScoreDao;
import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.util.Pager;

@Repository("scoreDao")
public class ScoreDaoImpl extends BaseDaoImpl<Score> implements ScoreDao {

	@Override
	public void addScore(Score score) {
		this.addEntity(score);
	}

	@Override
	public void updateScore(Score score) {
		this.saveOrUpdateEntity(score);
	}

	@Override
	public void delteScore(int id) {
		this.deleteEntity(id);
	}

	@Override
	public List<Score> listScoreByCourse(int courseId) {
		String hql = "from Score sc where sc.course.id = ?";
		return this.listEntityByHQL(hql, courseId);
	}

	@Override
	public Pager<Score> findScoreByCourse(int courseId) {
		String hql = "from Score sc where sc.course.id = ?";
		return this.findEntityByHQL(hql, courseId);
	}

	@Override
	public List<Score> listScoreByStudent(int studentId) {
		String hql = "from Score sc where sc.student.id = ?";
		return this.listEntityByHQL(hql, studentId);
	}

	@Override
	public Pager<Score> findScoreByStudent(int studentId) {
		String hql = "from Score sc where sc.student.id = ?";
		return this.findEntityByHQL(hql, studentId);
	}

	@Override
	public Score loadScoreByCourse(int stu_id, int cou_id) {
		String hql = "from Score sc where sc.student.id = ? and sc.course.id = ?";
		return (Score) this.getSession().createQuery(hql).setParameter(0, stu_id).setParameter(1, cou_id).uniqueResult();
	}

}
