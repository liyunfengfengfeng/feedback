package com.hrbust.feedback.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbust.feedback.dao.TeacherDao;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.domain.TeacherAndGrade;
import com.hrbust.feedback.domain.TeacherAndStudent;
import com.hrbust.feedback.util.Pager;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao {

	@Override
	public void addTeacher(Teacher teacher) {
		this.addEntity(teacher);
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		this.saveOrUpdateEntity(teacher);
	}

	@Override
	public void deleteTeacher(int teacherId) {
		this.deleteEntity(teacherId);
	}
	
	@Override
	public int loadTeacherAndGrade(int teacherId, int gradeId) {
		String sql = "select * from t_teacher_grade where teacher_id = ? and grade_id = ?";
		return this.getSession().createSQLQuery(sql)
								.setParameter(0, teacherId)
								.setParameter(1, gradeId)
								.list().size();
	}
	
	@Override
	public int loadTeacherAndStudent(int teacherId, int studentId) {
		String sql = "select * from t_teacher_student where teacher_id = ? and student_id = ?";
		return this.getSession().createSQLQuery(sql)
							  .setParameter(0, teacherId)
							  .setParameter(1, studentId)
							  .list().size();
	}
	/**
	 * 添加老师与学生的关系
	 */
	@Override
	public void addTeacherAndStudent(Teacher teacher, Student student) {
		/**
		 * 查询在老师与学生关系表中该条数据是否已存在
		 */
		int t = this.loadTeacherAndStudent(teacher.getId(), student.getId());
		if(t > 0) return;
		TeacherAndStudent ts = new TeacherAndStudent();
		ts.setTeacher(teacher);
		ts.setStudent(student);
		this.getSession().save(ts);
	}

	@Override
	public void addTeacherAndGrade(Teacher teacher, Grade grade) {
		int t = this.loadTeacherAndGrade(teacher.getId(), grade.getId());
		if(t > 0) return;
		TeacherAndGrade tg = new TeacherAndGrade();
		tg.setTeacher(teacher);
		tg.setGrade(grade);
		this.getSession().save(tg);
	}

	@Override
	public Pager<Teacher> findTeacherByCourse(int courseId) {
		String hql = "from Teacher t where t.course.id = ?";
		return this.findEntityByHQL(hql, courseId);
	}

	
	@Override
	public Teacher loadTeacher(int id) {
		return this.loadEntity(id);
	}
	/**
	 * 通过工号加载教师信息
	 * 查询到唯一结果
	 */
	@Override
	public Teacher loadTeacherByAccount(String account) {
		String hql = "from Teacher t where t.account = ?";
		return (Teacher) this.getSession().createQuery(hql).setParameter(0, account).uniqueResult();
	}

	@Override
	public Pager<Teacher> findTeachers() {
		String hql = "from Teacher";
		return this.findEntityByHQL(hql);
	}

	@Override
	public Pager<Teacher> findTeacherByCou_name(String name) {
		String hql = "from Teacher t where t.course.cou_name = ?";
		return this.findEntityByHQL(hql, name);
	}

	@Override
	public List<Teacher> listTeacherByName(String name) {
		String hql = "from Teacher t where t.tea_name = ?";
		return this.listEntityByHQL(hql, "%"+name+"%");
	}

	@Override
	public List<Teacher> listTeachers() {
		String hql = "from Teacher";
		return this.listEntityByHQL(hql);
	}

	@Override
	public List<Teacher> listTeacherByGrade(int gid) {
		String hql = "select tg.teacher from TeacherAndGrade tg where tg.grade.id = ?";
		return this.listEntityByHQL(hql, gid);
	}

	@Override
	public void deleteTeacherAndGrade(int id) {
		String sql = "delete from t_teacher_grade where teacher_id = ?";
		this.getSession().createSQLQuery(sql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void deleteTeacherAndStudent(int id) {
		String sql = "delete from t_teacher_student where teacher_id = ?";
		this.getSession().createSQLQuery(sql).setParameter(0, id).executeUpdate();
	}
	
}
