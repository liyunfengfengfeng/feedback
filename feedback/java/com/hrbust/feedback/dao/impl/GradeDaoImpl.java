package com.hrbust.feedback.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbust.feedback.dao.GradeDao;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.util.Pager;

@Repository("gradeDao")
public class GradeDaoImpl extends BaseDaoImpl<Grade> implements GradeDao {

	@Override
	public void addGrade(Grade grade) {
		this.addEntity(grade);
	}

	@Override
	public void updateGrade(Grade grade) {
		this.saveOrUpdateEntity(grade);
	}

	@Override
	public void deleteGrade(int id) {
		this.deleteEntity(id);
	}
	/**
	 * 查询所有的班级
	 */
	@Override
	public List<Grade> listAllGrade() {
		String hql = "from Grade";
		return this.listEntityByHQL(hql);
	}

	@Override
	public Grade loadGrade(int id) {
		return this.loadEntity(id);
	}

	@Override
	public Grade loadGradeByName(String name) {
		String hql = "from Grade where gra_name = ?";
		return (Grade) this.getSession().createQuery(hql).setParameter(0, name).uniqueResult();
	}

	@Override
	public Pager<Grade> findGrades() {
		String hql = "from Grade";
		return this.findEntityByHQL(hql);
	}
	
	@Override
	public List<Grade> listGradeByTeacher(int teacherId) {
		String hql = "select tg.grade from TeacherAndGrade tg where tg.teacher.id = ?";
		return this.list(hql, teacherId);
	}

	@Override
	public void deleteTeacherAndGrade(int id) {
		String sql = "delete from t_teacher_grade where grade_id = ?";
		this.getSession().createSQLQuery(sql).setParameter(0, id).executeUpdate();
	}


}
