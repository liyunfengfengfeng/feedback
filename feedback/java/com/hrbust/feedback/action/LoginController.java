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
	 * �û������½���뵽������
	 * @param account   ��ȡǰ̨ҳ��name����
	 * @param password  ��ȡǰ̨ҳ��password����
	 * @param target    ��ȡǰ̨ҳ��target����
	 * @param model     ����Ϣ������ǰ̨ҳ��
	 * @param session   ���浱ǰ��¼�û�
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String account, String password,String target,Model model, HttpSession session){
		if (target.equals("student")) {
			/**
			 * ͨ��ѧ�ż��ص�Ψһ��ѧ������
			 */
			Student student = studentService.loadStudentByAccount(account);
			if(student == null) {
				/**
				 * �ŵ�model��  ����ǰ̨ҳ��չʾ  ${error}
				 */
				model.addAttribute("error", "�˺Ų�����,���������룡");
				return "/login";
			}
			/**
			 * �������������Ƿ���ȷ
			 */
			if(CheckUtil.checkPassword(password, student.getPassword())) {
				model.addAttribute("student", student);
				session.setAttribute("loginUser", student);
				return "/student-info";
			} else {
				model.addAttribute("error", "�˺ź����벻ƥ��");
			}
			return "/login";
		} else if (target.equals("teacher")) {
			Teacher teacher = teacherService.loadTeacherByAccount(account);
			if(teacher == null) {
				model.addAttribute("error", "�˺Ų�����,���������룡");
				return "/login";
			}
			if(CheckUtil.checkPassword(password, teacher.getPassword())) {
				model.addAttribute("teacher", teacher);
				session.setAttribute("loginUser", teacher);
				return "/teacher-info";
			} else {
				model.addAttribute("error", "�˺ź����벻ƥ��");
			}
			return "/login";
		} else if (target.equals("admin")) {
			Admin admin = adminService.loadAdminByAccount(account);
			if(admin == null) {
				model.addAttribute("error", "�˺Ų�����,���������룡");
				return "/login";
			}
			if(CheckUtil.checkPassword(password, admin.getPassword())) {
				session.setAttribute("loginUser", admin);
				return "/admin-welcome";
			} else {
				model.addAttribute("error", "�˺ź����벻ƥ��");
			}
			return "/login";
		} else {
			model.addAttribute("error", "�˺ź����벻ƥ��");
			return "/error";
		}
	}
	
	

}
