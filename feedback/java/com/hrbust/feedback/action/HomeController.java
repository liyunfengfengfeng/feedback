package com.hrbust.feedback.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;

@Controller
public class HomeController {
	@RequestMapping("/homepage")
	public String homePage() {
		return "/homepage";
	}
	/**
	 * µã»÷µÇÂ½µ½´ïlogin.jsp
	 * @return
	 */
	@RequestMapping("/gologin")
	public String login() {
		return "/login";
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session){
		if(session.getAttribute("loginUser") != null){
			session.removeAttribute("loginUser");
		}
		return "/homepage";
	}

	@RequestMapping("/changestudentpassword")
	public String goStudentChangePassword(HttpSession session) {
		Student student = (Student) session.getAttribute("loginUser");
		if(student == null) {
			return "login";
		}
		return "/student-change";
	}
	
	@RequestMapping("/changeteacherpassword")
	public String goTeacherChangePassword(HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("loginUser");
		if(teacher == null) {
			return "/login";
		}
		return "/teacher-change";
	}
}
