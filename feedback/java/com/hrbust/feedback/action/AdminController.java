package com.hrbust.feedback.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrbust.feedback.domain.Course;
import com.hrbust.feedback.domain.Grade;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.service.AdminService;
import com.hrbust.feedback.service.StudentService;
import com.hrbust.feedback.service.TeacherService;
import com.hrbust.feedback.util.Pager;
import com.hrbust.feedback.util.SystemContext;

@Controller
public class AdminController {
	
	private AdminService adminService;
	private StudentService studentService;
	private TeacherService teacherService;
	
	public TeacherService getTeacherService() {
		return teacherService;
	}
	@Resource(name = "teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	@Resource(name = "adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	/**
	 * 点击添加学生
	 * @param model
	 * @return
	 */
	@RequestMapping("/addstudent")
	public String addStudent(Model model){
		/**
		 * 查询所有的班级
		 */
		List<Grade> list = adminService.listAllGrade();
		/**
		 * 查询所有的学生
		 */
		List<Course> clist = adminService.listAllCourse();
		/**
		 * 存入model
		 */
		model.addAttribute("list", list);
		model.addAttribute("course", clist);
		return "/admin-addstudent";
	}
	/**
	 * 点击添加教师
	 * @param model
	 * @return
	 */
	@RequestMapping("/addteacher")
	public String addTeacher(Model model){
		/**
		 * 查询所有课程
		 */
		List<Course> list = adminService.listAllCourse();
		model.addAttribute("list", list);
		return "/admin-addteacher";
	}
	/**
	 * 点击添加班级
	 * @param model
	 * @return
	 */
	@RequestMapping("/addgrade")
	public String addGrade(Model model){
		List<Teacher> list = adminService.listTeachers();
		model.addAttribute("data", list);
		return "/admin-addgrade";
	}
	/**
	 * 添加课程
	 * @return
	 */
	@RequestMapping("/addcourse")
	public String addCourse(){
		return "/admin-addcourse";
	}
	/**
	 * 将添加的学生信息加入到数据库
	 * @param session
	 * @param model
	 * @param account
	 * @param stu_name
	 * @param password
	 * @param grade
	 * @param gender
	 * @param birthday
	 * @param nation
	 * @return
	 */
	@RequestMapping(value = "/newstudent",method = RequestMethod.POST)
	public String newStudent(HttpSession session, Model model, String account, String stu_name, String password, int grade, String gender, String birthday, String nation){
		/**
		 * 若用户没有登录则进行登录
		 */
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		/*
		 * GET请求需要转码
		 * try {
			byte [] b = stu_name.getBytes("iso-8859-1");
			stu_name = new String(b, "UTF-8");
			b = gender.getBytes("iso-8859-1");
			gender = new String(b, "UTF-8");
			b = nation.getBytes("iso-8859-1");
			nation = new String(b, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}*/
		/**
		 * 添加的学号已经在数据库中存在
		 */
		if(studentService.loadStudentByAccount(account) != null){
			model.addAttribute("error", "账号已存在");
			return "/admin-addstudent";
		}
		
		Student student = new Student();
		student.setAccount(account);
		student.setStu_name(stu_name);
		student.setPassword(password);
		/**
		 * 通过班级id查询到该班级
		 */
		Grade g = adminService.loadGrade(grade);
		student.setGrade(g);
		student.setGender(gender);
		student.setBirthday(birthday);
		student.setNation(nation);
		/**
		 * 添加学生到数据库
		 */
		adminService.addStudent(student);
		/**
		 * 通过班级id查询该班所上的课程
		 */
		List<Course> grades = adminService.listCourseByGrade(g.getId());
		int id[] = new int [grades.size()];
		for (int i = 0; i< grades.size(); i++) {
			/**
			 * grades.get(i).getId()  课程id存入数组中
			 */
			id[i] = grades.get(i).getId();
		}	
		/**
		 * 添加学生与课程的关系
		 */
		studentService.addStudentAndCourse(id, student);
		/**
		 * 添加老师与学生的关系
		 */
		studentService.addTeacherAndStudent(grade, student);
		/**
		 * 查询所有的班级
		 */
		List<Grade> list = adminService.listAllGrade();
		/**
		 * 查询所有的课程
		 */
		List<Course> clist = adminService.listAllCourse();
		model.addAttribute("list", list);
		model.addAttribute("course", clist);
		model.addAttribute("success", "学生添加成功");
		//返回到添加学生页面
		return "/admin-addstudent";
	}
	/**
	 * 添加教师信息
	 * @param session
	 * @param model
	 * @param account
	 * @param tea_name
	 * @param password
	 * @param course
	 * @param gender
	 * @param birthday
	 * @param nation
	 * @return
	 */
	@RequestMapping(value="/newteacher",method = RequestMethod.POST)
	public String newTeacher(HttpSession session, Model model, String account, String tea_name, String password, int course, String gender, String birthday, String nation) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		if(teacherService.loadTeacherByAccount(account) != null) {
			model.addAttribute("error", "账号已存在");
			return "/admin-addteacher";
		}
		Teacher teacher = new Teacher();
		teacher.setAccount(account);
		teacher.setTea_name(tea_name);
		teacher.setPassword(password);
		Course c = teacherService.loadCourse(course);
		teacher.setCourse(c);
		teacher.setGender(gender);
		teacher.setBirthday(birthday);
		teacher.setNation(nation);
		adminService.addTeacher(teacher);
		List<Course> list = adminService.listAllCourse();
		model.addAttribute("list", list);
		
		model.addAttribute("success", "教师添加成功");
		return "/admin-addteacher";
	}
	/**
	 * 添加课程到数据库
	 * @param session
	 * @param model
	 * @param cou_name
	 * @return
	 */
	@RequestMapping(value = "/newcourse", method = RequestMethod.POST)
	public String newCourse(HttpSession session, Model model, String cou_name) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		if (adminService.loadCourseByName(cou_name) != null) {
			model.addAttribute("error", "课程已经存在");
			return "/admin-addcourse";
		}
		Course course = new Course();
		course.setCou_name(cou_name);
		adminService.addCourse(course);
		model.addAttribute("success","课程添加成功");
		return "/admin-addcourse";
	}
	/**
	 * 添加班级到数据库
	 * @param session
	 * @param model
	 * @param cou_name
	 * @return
	 */
	@RequestMapping(value = "/newgrade", method = RequestMethod.POST)
	public String newGrade(HttpSession session, Model model, int [] id, String gra_name) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		if (adminService.loadGradeByName(gra_name) != null) {
			model.addAttribute("error", "班级已存在");
			return "/admin-addgrade";
		}
		Grade grade = new Grade();
		grade.setGra_name(gra_name);
		adminService.addGrade(grade);
		teacherService.addTeacherAndGrade(id, grade);
		List<Teacher> list = adminService.listTeachers();
		model.addAttribute("data", list);
		model.addAttribute("success", "班级添加成功");
		return "/admin-addgrade"; 
	}
	/**
	 * 查询所有学生
	 */
	@RequestMapping("/allstudent")
	public String allStudent(Model model,String currpage){
		if(currpage == null) {
			currpage = "0";
		}
		int start = Integer.valueOf(currpage);
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(start*SystemContext.getPageSize());
		Pager<Student> pager = adminService.findStudents();
		model.addAttribute("list", pager);
		return "/admin-allstudent";
	}
	
	@RequestMapping("/allteacher")
	public String allTeacher(Model model, String currpage) {
		if(currpage == null) {
			currpage = "0";
		}
		int start = Integer.valueOf(currpage);
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(start*SystemContext.getPageSize());
		Pager<Teacher> pager = adminService.findTeachers();
		model.addAttribute("list", pager);
		return "/admin-allteacher";
	}
	
	@RequestMapping("/allcourse")
	public String allCourse(Model model, String currpage) {
		if(currpage == null) {
			currpage = "0";
		}
		int start = Integer.valueOf(currpage);
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(start*SystemContext.getPageSize());
		Pager<Course> pager = adminService.findCourses();
		model.addAttribute("list", pager);
		return "/admin-allcourse";
	}
	
	@RequestMapping("/allgrade")
	public String allGrade(Model model, String currpage) {
		if(currpage == null) {
			currpage = "0";
		}
		int start = Integer.valueOf(currpage);
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(start*SystemContext.getPageSize());
		Pager<Grade> pager = adminService.findGrades();
		model.addAttribute("list", pager);
		return "/admin-allgrade";
	}
	
	@RequestMapping("/adminquery")
	public String adminQuery(Model model, String currpage){
		if(currpage == null) {
			currpage = "0";
		}
		int start = Integer.valueOf(currpage);
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(start*SystemContext.getPageSize());
		
		return "/admin-query";
	}
	
	@SuppressWarnings("null")
	@RequestMapping("/query")
	public String query(Model model, String currpage, String type, String target, String message) {
		if (message == null && message.trim().length() == 0) {
			model.addAttribute("error", "请输入正确信息");
		}
		model.addAttribute("types", type);
		model.addAttribute("target", target);
		model.addAttribute("message", message);
		
		try {
			byte[] b = message.getBytes("iso-8859-1");
			message = new String(b, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (type.equals("student")) {
			Pager<Student> pager = new Pager<Student> ();
			if (target.equals("account")) {
				Student student = studentService.loadStudentByAccount(message);
				List<Student> list = new ArrayList<Student>();
				list.add(student);
				pager.setDatas(list);
			} else if (target.equals("name")) {
				List<Student> list = studentService.listStudentByName(message);
				pager.setDatas(list);
			} else if (target.equals("couorgra")) {
				pager = studentService.findStudentByGra_name(message);
			} else {
				return "/error";
			}
			model.addAttribute("type", "student");
			model.addAttribute("list", pager);
			
		} else if (type.equals("teacher")) {
			Pager<Teacher> pager = new Pager<Teacher>();
			if (target.equals("account")) {
				Teacher teacher = teacherService.loadTeacherByAccount(message);
				List<Teacher> list = new ArrayList<Teacher>();
				list.add(teacher);
				pager.setDatas(list);
			} else if (target.equals("name")) {
				List<Teacher> list = teacherService.listTeacherByName(message);
				pager.setDatas(list);
			} else if (target.equals("couorgra")) {
				pager = teacherService.findTeacherByCou_name(message);
			} else {
				return "/error";
			}
			model.addAttribute("type", "teacher");
			model.addAttribute("list", pager);
		} else {
			return "/error";
		}
		return "/admin-query";
	}
	/**
	 * 删除学生信息
	 */
	@RequestMapping("/deletestudent")
	public String deleteStudent(Model model, HttpSession session,int id){
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Student student = studentService.loadStudent(id);
		if (student != null) {
			adminService.deleteStudent(id);
			model.addAttribute("success","删除成功");
		} else {
			model.addAttribute("error","删除失败");
		}
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		Pager<Student> pager = adminService.findStudents();
		model.addAttribute("list", pager);
		return "/admin-allstudent";
	}
	/**
	 * 更新学生信息
	 * @param model
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/updatestudent")
	public String updateStudent(Model model, HttpSession session, int id) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Student student = studentService.loadStudent(id);
		List<Grade> list = adminService.listAllGrade();
		model.addAttribute("list", list);
		model.addAttribute("data", student);
		return "/admin-updatestudent";
	}
	
	@RequestMapping(value = "/upstudent", method = RequestMethod.POST)
	public String upStudent(HttpSession session, Model model,int id, String account, String stu_name, String password, int grade, String gender, String birthday, String nation){
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Student student = new Student();
		student.setId(id);
		student.setAccount(account);
		student.setStu_name(stu_name);
		student.setPassword(password);
		Grade g = adminService.loadGrade(grade);
		student.setGrade(g);
		student.setGender(gender);
		student.setBirthday(birthday);
		student.setNation(nation);
		studentService.updateStudent(student);
		
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		Pager<Student> pager = adminService.findStudents();
		model.addAttribute("list", pager);
		model.addAttribute("success", "学生更新成功");
		return "/admin-allstudent";
	}
	
	@RequestMapping("/deleteteacher")
	public String deleteTeacher(Model model, HttpSession session,int id){
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Teacher teacher = teacherService.loadTeacher(id);
		if (teacher != null) {
			adminService.deleteTeacher(id);
			model.addAttribute("success","删除成功");
		} else {
			model.addAttribute("error","删除失败");
		}
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		Pager<Teacher> pager = adminService.findTeachers();
		model.addAttribute("list", pager);
		return "/admin-allteacher";
	}
	
	@RequestMapping("/updateteacher")
	public String updateTeacher(Model model, HttpSession session, int id) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Teacher teacher = teacherService.loadTeacher(id);
		List<Course> list = adminService.listAllCourse();
		model.addAttribute("list", list);
		model.addAttribute("data", teacher);
		return "/admin-updateteacher";
	}
	
	@RequestMapping(value = "/upteacher", method = RequestMethod.POST)
	public String upTeacher(HttpSession session, Model model, int id, String account, String tea_name, String password, int course, String gender, String birthday, String nation) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setAccount(account);
		teacher.setTea_name(tea_name);
		teacher.setPassword(password);
		Course c = teacherService.loadCourse(course);
		teacher.setCourse(c);
		teacher.setGender(gender);
		teacher.setBirthday(birthday);
		teacher.setNation(nation);
		teacherService.updateTeacher(teacher);
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		Pager<Teacher> pager = adminService.findTeachers();
		model.addAttribute("list", pager);
		model.addAttribute("success", "教师更新成功");
		return "/admin-allteacher";
	}
	
	@RequestMapping("/deletegrade")
	public String deleteGrade(Model model, int id, HttpSession session) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Grade grade = adminService.loadGrade(id);
		if(grade != null){
			adminService.deleteGrade(id);
			model.addAttribute("success", "课程删除成功");
		} else {
			model.addAttribute("error", "课程删除失败");
		}
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		Pager<Grade> pager = adminService.findGrades();
		model.addAttribute("list", pager);
		return "/admin-allgrade";
	}
	
	@RequestMapping("/deletecourse")
	public String deleteCourse(Model model, int id, HttpSession session) {
		if (session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Course course = teacherService.loadCourse(id);
		if (course != null) {
			adminService.deleteCourse(id);
			model.addAttribute("success", "课程删除成功");
		} else {
			model.addAttribute("error", "课程删除失败");
		}
		SystemContext.setPageSize(10);
		SystemContext.setPageOffset(0);
		Pager<Course> pager = adminService.findCourses();
		model.addAttribute("list", pager);
		return "/admin-allcourse";
	}

} 
