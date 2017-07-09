package com.hrbust.feedback.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrbust.feedback.domain.Admin;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.service.AdminService;
import com.hrbust.feedback.service.StudentService;
import com.hrbust.feedback.service.TeacherService;
import com.hrbust.feedback.util.CheckUtil;

@Controller
public class LoginController {
	
	private AdminService adminService;
	private StudentService studentService;
	private TeacherService teacherService;
	
	public AdminService getAdminService() {
		return adminService;
	}
	@Resource(name="adminService")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public StudentService getStudentService() {
		return studentService;
	}
	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}
	@Resource(name="teacherService")
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	/**
	 * 用户输入登陆密码到达这里
	 * @param account   获取前台页面name属性
	 * @param password  获取前台页面password属性
	 * @param target    获取前台页面target属性
	 * @param model     将信息反馈给前台页面
	 * @param session   保存当前登录用户
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String account, String password,String target,Model model, HttpSession session){
		if (target.equals("student")) {
			/**
			 * 通过学号加载到唯一的学生对象
			 */
			Student student = studentService.loadStudentByAccount(account);
			if(student == null) {
				/**
				 * 放到model中  可在前台页面展示  ${error}
				 */
				model.addAttribute("error", "账号不存在,请重新输入！");
				return "/login";
			}
			/**
			 * 检查输入的密码是否正确
			 */
			if(CheckUtil.checkPassword(password, student.getPassword())) {
				model.addAttribute("student", student);
				session.setAttribute("loginUser", student);
				return "/student-info";
			} else {
				model.addAttribute("error", "账号和密码不匹配");
			}
			return "/login";
		} else if (target.equals("teacher")) {
			Teacher teacher = teacherService.loadTeacherByAccount(account);
			if(teacher == null) {
				model.addAttribute("error", "账号不存在,请重新输入！");
				return "/login";
			}
			if(CheckUtil.checkPassword(password, teacher.getPassword())) {
				model.addAttribute("teacher", teacher);
				session.setAttribute("loginUser", teacher);
				return "/teacher-info";
			} else {
				model.addAttribute("error", "账号和密码不匹配");
			}
			return "/login";
		} else if (target.equals("admin")) {
			Admin admin = adminService.loadAdminByAccount(account);
			if(admin == null) {
				model.addAttribute("error", "账号不存在,请重新输入！");
				return "/login";
			}
			if(CheckUtil.checkPassword(password, admin.getPassword())) {
				session.setAttribute("loginUser", admin);
				return "/admin-welcome";
			} else {
				model.addAttribute("error", "账号和密码不匹配");
			}
			return "/login";
		} else {
			model.addAttribute("error", "账号和密码不匹配");
			return "/error";
		}
	}
	
	

}
