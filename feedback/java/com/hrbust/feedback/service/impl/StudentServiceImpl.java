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
	 * 通过学号加载学生对象
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
	 * 添加学生与课程的关系
	 */
	@Override
	public void addStudentAndCourse(int[] cid, Student student) {
		for (int i : cid) {
			/**
			 * 通过id查询课程
			 */
			Course course = courseDao.loadCourse(i);
			/**
			 * 添加学生与课程的关系
			 */
			studentDao.addStudentAndCourse(student, course);
		}
	}
	/**
	 * 添加学生与老师的关系
	 */
	@Override
	public void addTeacherAndStudent(int gid, Student student) {
		/**
		 * 通过班级id查询到班级所有的老师
		 */
			List<Teacher> list = teacherDao.listTeacherByGrade(gid);
			for (Teacher t : list) {
				teacherDao.addTeacherAndStudent(t, student);
			}
	}

}
