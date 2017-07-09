package com.hrbust.feedback.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbust.feedback.dao.CourseDao;
import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.util.Pager;

@Repository("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {

	@Override
	public void addCourse(Course course) {
		this.addEntity(course);
	}

	@Override
	public void deleteCourse(int id) {
		this.deleteEntity(id);
	}

	@Override
	public void updateCourse(Course course) {
		this.saveOrUpdateEntity(course);
	}

	@Override
	public List<Course> listCourseByStudent(int studentId) {
		String hql = "select sc.course from StudentAndCourse sc where sc.student.id = ?";
		return this.list(hql, studentId);
	}

	@Override
	public List<Course> listAllCourse() {
		String hql = "from Course";
		return this.listEntityByHQL(hql);
	}

	@Override
	public Course loadCourse(int id) {
		return this.loadEntity(id);
	}

	@Override
	public Course loadCourseByName(String name) {
		String hql = "from Course where cou_name = ?";
		return (Course) this.getSession().createQuery(hql).setParameter(0, name).uniqueResult();
	}

	@Override
	public Pager<Course> findCourses() {
		String hql = "from Course";
		return this.findEntityByHQL(hql);
	}

	@Override
	public void deleteStudentAndCourse(int id) {
		String sql = "delete from t_student_course where course_id = ?";
		this.getSession().createSQLQuery(sql).setParameter(0, id).executeUpdate();
	}

	@Override
	public Course listCourseByGrade(int id) {
		String hq = "select t.course from Teacher t where t.id = ?";
		Course c =(Course) this.getSession().createQuery(hq).setParameter(0, id).uniqueResult();
		return c;
	}
	
}
