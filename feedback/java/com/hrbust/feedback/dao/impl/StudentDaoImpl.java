package com.hrbust.feedback.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrbust.feedback.dao.StudentDao;
import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.StudentAndCourse;
import com.hrbust.feedback.util.Pager;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

	@Override
	/**
	 * ���ѧ��
	 */
	public void addStudent(Student student) {
		this.addEntity(student);
	}

	@Override
	public void updateStudent(Student student) {
		this.saveOrUpdateEntity(student);
	}

	@Override
	public void deleteStudent(int id) {
		this.deleteEntity(id);
	}
	
	@Override
	public Pager<Student> findStudentByGrade(int gradeId) {
		String hql = "from Student st where st.grade.id = ?";
		return this.findEntityByHQL(hql, gradeId);
	}

	@Override
	public List<Student> listStudentByGrade(int gradeId) {
		String hql = "from Student st where st.grade.id = ?";
		return this.listEntityByHQL(hql, gradeId);
	}
	/**
	 * ͨ��ѧ��id�γ�id���в�ѯ
	 */
	@Override
	public int loadStudentAndCourse(int studentId, int courseId) {
		String sql = "select * from t_student_course where student_id = ? and course_id = ?";
		return this.getSession().createSQLQuery(sql)
							   .setParameter(0, studentId)
							   .setParameter(1, courseId)
							   .list().size();
	}
	/**
	 * ���ѧ����γ̵Ĺ�ϵ
	 */
	@Override
	public void addStudentAndCourse(Student student, Course course) {
		/**
		 * �����������ѧ����γ̵Ĺ�ϵ���˳�
		 */
		int s = this.loadStudentAndCourse(student.getId(), course.getId());
		if(s > 0) return;
		StudentAndCourse sc = new StudentAndCourse();
		sc.setStudent(student);
		sc.setCourse(course);
		this.getSession().save(sc);
	}

	@Override
	public Student loadStudent(int id) {
		return this.loadEntity(id);
	}
	/**
	 * ͨ��ѧ�ż���ѧ������
	 */
	@Override
	public Student loadStudentByAccount(String account) {
		String hql = "from Student s where s.account = ?";
		/**
		 * ��sessionFactory��ȡsessionִ�в�ѯ������ò������ؽ��Ψһ
		 */
		return (Student) this.getSession().createQuery(hql).setParameter(0, account).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudentByName(String name) {
		String hql = "from Student s where s.stu_name like ?";
		return this.getSession().createQuery(hql).setString(0, "%"+name+"%").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudentByGra_ame(String name) {
		String hql = "from Student s where s.grade.gra_name like ?";
		return this.getSession().createQuery(hql).setString(0, name+"%").list();
	}

	@Override
	public Pager<Student> findStudents() {
		String hql = "from Student";
		return this.findEntityByHQL(hql);
	}

	@Override
	public Pager<Student> findStudentByGra_name(String name) {
		String hql = "from Student s where s.grade.gra_name like ?";
		return this.findEntityByHQL(hql, name+"%");
	}
	
	@Override
	public List<Student> listStudentByTeacher(int teacherId) {
		String hql = "select ts.student from TeacherAndStudent ts where ts.teacher.id = ?";
		return this.list(hql, teacherId);
	}

	@Override
	public void deleteTeacherAndStudent(int id) {
		String sql = "delete from t_teacher_student where student_id = ?";
		this.getSession().createSQLQuery(sql).setParameter(0, id).executeUpdate();
	}

	@Override
	public void deleteStudentAndCourse(int id) {
		String sql = "delete from t_student_course where student_id = ?";
		this.getSession().createSQLQuery(sql).setParameter(0, id).executeUpdate();
	}

}
