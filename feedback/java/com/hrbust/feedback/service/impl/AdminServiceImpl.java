package com.hrbust.feedback.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hrbust.feedback.dao.AdminDao;
import com.hrbust.feedback.dao.CourseDao;
import com.hrbust.feedback.dao.GradeDao;
import com.hrbust.feedback.dao.StudentDao;
import com.hrbust.feedback.dao.TeacherDao;
import com.hrbust.feedback.domain.Admin;
import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.service.AdminService;
import com.hrbust.feedback.util.Pager;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;
	private TeacherDao teacherDao;
	private StudentDao studentDao;
	private CourseDao courseDao;
	private GradeDao gradeDao;
	
	public CourseDao getCourseDao() {
		return courseDao;
	}
	@Resource(name="courseDao")
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public GradeDao getGradeDao() {
		return gradeDao;
	}
	@Resource(name="gradeDao")
	public void setGradeDao(GradeDao gradeDao) {
		this.gradeDao = gradeDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}
	@Resource(name="adminDao")
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
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

	@Override
	public void addTeacher(Teacher teacher) {
			teacherDao.addTeacher(teacher);
	}

	@Override
	public void addTeacher(List<Teacher> teacher) {
		// TODO Auto-generated method stub
	}
	/**
	 * 添加学生到数据库
	 */
	@Override
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	@Override
	public void addStudent(List<Student> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
		studentDao.deleteTeacherAndStudent(id);
		studentDao.deleteStudentAndCourse(id);
	}

	@Override
	public void deleteStudent(List<Integer> list) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteTeacher(int id) {
		teacherDao.deleteTeacher(id);
		teacherDao.deleteTeacherAndGrade(id);
		teacherDao.deleteTeacherAndStudent(id);
	}

	@Override
	public void deleteTeacher(List<Integer> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}
	
	@Override
	public void addGrade(Grade grade) {
		gradeDao.addGrade(grade);
	}
	
	@Override
	public void updateGrade(Grade grade) {
		gradeDao.updateGrade(grade);
	}
	
	@Override
	public void deleteGrade(int id) {
		gradeDao.deleteGrade(id);
		gradeDao.deleteTeacherAndGrade(id);
	}
	/**
	 * 通过管理员工号查询管理员
	 * @param account
	 * @return
	 */
	@Override
	public Admin loadAdminByAccount(String account) {
		return adminDao.loadAdminByAccount(account);
	}
	@Override
	public Admin loadAdminById(int id) {
		return adminDao.loadAdmin(id);
	}
	/**
	 * 查询所有的班级
	 */
	@Override
	public List<Grade> listAllGrade() {
		/**
		 * 调用dao层查询所有的班级
		 */
		return gradeDao.listAllGrade();
	}
	@Override
	public List<Course> listAllCourse() {
		return courseDao.listAllCourse();
	}
	@Override
	public Grade loadGrade(int id) {
		return gradeDao.loadGrade(id);
	}
	@Override
	public Course loadCourseByName(String name) {
		return courseDao.loadCourseByName(name);
	}
	@Override
	public Grade loadGradeByName(String name) {
		return gradeDao.loadGradeByName(name);
	}
	@Override
	public Pager<Student> findStudents() {
		return studentDao.findStudents();
	}
	@Override
	public Pager<Course> findCourses() {
		return courseDao.findCourses();
	}
	@Override
	public Pager<Teacher> findTeachers() {
		return teacherDao.findTeachers();
	}
	@Override
	public Pager<Grade> findGrades() {
		return gradeDao.findGrades();
	}
	@Override
	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);
		courseDao.deleteStudentAndCourse(id);
	}
	@Override
	public List<Teacher> listTeachers() {
		return teacherDao.listTeachers();
	}
	@Override
	public List<Course> listCourseByGrade(int id) {
		List<Teacher> list = teacherDao.listTeacherByGrade(id);
		List<Course> result = new ArrayList<Course>();
		for (Teacher t : list) {
			Course course = courseDao.listCourseByGrade(t.getId());
			result.add(course);
		}
		return result;
	}
	
}
