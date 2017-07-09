package com.hrbust.feedback.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hrbust.feedback.dao.CourseDao;
import com.hrbust.feedback.dao.GradeDao;
import com.hrbust.feedback.dao.ScoreDao;
import com.hrbust.feedback.dao.StudentDao;
import com.hrbust.feedback.dao.TeacherDao;
import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.service.TeacherService;
import com.hrbust.feedback.util.Pager;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	private TeacherDao teacherDao;
	private StudentDao studentDao;
	private ScoreDao scoreDao;
	private GradeDao gradeDao;
	private CourseDao courseDao;
	
	public CourseDao getCourseDao() {
		return courseDao;
	}
	@Resource(name = "courseDao")
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}
	@Resource(name="teacherDao")
	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
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

	public GradeDao getGradeDao() {
		return gradeDao;
	}

	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	@Override
	public Teacher loadTeacher(int id) {
		return teacherDao.loadTeacher(id);
	}
	/**
	 * 通过教师工号加载学生信息
	 */
	@Override
	public Teacher loadTeacherByAccount(String account) {
		return teacherDao.loadTeacherByAccount(account);
	}

	@Override
	public List<Score> listStudentScore(int id) {
		return scoreDao.listScoreByStudent(id);
	}
	
	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDao.addTeacher(teacher);
	}
	@Override
	public List<Student> listStudentByGrade(String grade) {
		return studentDao.listStudentByGra_ame(grade);
	}
	@Override
	public Course loadCourse(int id) {
		return courseDao.loadCourse(id);
	}
	@Override
	public Pager<Teacher> findTeacherByCou_name(String name) {
		return teacherDao.findTeacherByCou_name(name);
	}
	@Override
	public List<Teacher> listTeacherByName(String name) {
		return teacherDao.listTeacherByName(name);
	}
	@Override
	public void addTeacherAndGrade(int[] tid, Grade grade) {
		for (int i : tid) {
			Teacher teacher = teacherDao.loadTeacher(i);
			teacherDao.addTeacherAndGrade(teacher, grade);
		}
	}
	@Override
	public List<Student> listStudentByTeacher(int id) {
		return studentDao.listStudentByTeacher(id);
	}
	@Override
	public Score loadScoreByCourse(int stu_id, int course_id) {
		return scoreDao.loadScoreByCourse(stu_id, course_id);
	}
	@Override
	public void addScore(Score score) {
		scoreDao.addScore(score);
	}

}
