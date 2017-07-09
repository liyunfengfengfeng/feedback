package com.hrbust.feedback.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hrbust.feedback.dao.CourseDao;
import com.hrbust.feedback.dao.ScoreDao;
import com.hrbust.feedback.dao.StudentDao;
import com.hrbust.feedback.dao.TeacherDao;
import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.service.StudentService;
import com.hrbust.feedback.util.Pager;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	private ScoreDao scoreDao;
	private CourseDao courseDao;
	private TeacherDao teacherDao;

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}
	@Resource(name = "teacherDao")
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	public CourseDao getCourseDao() {
		return courseDao;
	}
	@Resource(name = "courseDao")
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	@Resource(name="studentDao")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public ScoreDao getScoreDao() {
		return scoreDao;
	}
	@Resource(name="scoreDao")
	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	@Override
	public List<Score> listStudentScore(int id) {
		return scoreDao.listScoreByStudent(id);
	}

	@Override
	public Student loadStudent(int id) {
		return studentDao.loadStudent(id);
	}

	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}
	/**
	 * ͨ��ѧ�ż���ѧ������
	 */
	@Override
	public Student loadStudentByAccount(String account) {
		return studentDao.loadStudentByAccount(account);
	}
	@Override
	public List<Student> listStudentByName(String name) {
		return studentDao.listStudentByName(name);
	}
	@Override
	public Pager<Student> findStudentByGra_name(String name) {
		return studentDao.findStudentByGra_name(name);
	}
	/**
	 * ���ѧ����γ̵Ĺ�ϵ
	 */
	@Override
	public void addStudentAndCourse(int[] cid, Student student) {
		for (int i : cid) {
			/**
			 * ͨ��id��ѯ�γ�
			 */
			Course course = courseDao.loadCourse(i);
			/**
			 * ���ѧ����γ̵Ĺ�ϵ
			 */
			studentDao.addStudentAndCourse(student, course);
		}
	}
	/**
	 * ���ѧ������ʦ�Ĺ�ϵ
	 */
	@Override
	public void addTeacherAndStudent(int gid, Student student) {
		/**
		 * ͨ���༶id��ѯ���༶���е���ʦ
		 */
			List<Teacher> list = teacherDao.listTeacherByGrade(gid);
			for (Teacher t : list) {
				teacherDao.addTeacherAndStudent(t, student);
			}
	}

}
