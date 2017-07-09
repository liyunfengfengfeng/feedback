package com.hrbust.feedback.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.service.StudentService;
import com.hrbust.feedback.util.CheckUtil;
import com.hrbust.feedback.util.PieScore;

@Controller
public class StudentController {
	private StudentService studentService;
	
	
	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/gostudent-info")
	public String goStudentInfo(HttpSession session, Model model) {
		Student student = (Student) session.getAttribute("loginUser");
		if(student == null) {
			return "login";
		}
		model.addAttribute("student", student);
		return "/student-info";
	}

	@RequestMapping("/studentchangepassword")
	public String changePassword(String oldPassword, String newPassword, String rePassword, Model model, HttpSession session){
		Student student = (Student) session.getAttribute("loginUser");
		if(student == null) {
			return "/login";
		}
		if(!newPassword.equals(rePassword)) {
			model.addAttribute("error","新密码两次输入不一致");
			return "/student-change";
		}
		if(CheckUtil.checkPassword(student.getPassword(), oldPassword)) {
			student.setPassword(newPassword);
			studentService.updateStudent(student);
			session.setAttribute("loginUser", student);
			return "/login";
		}
		model.addAttribute("error", "原密码不正确,请重试!");
		return "/login";
	}
	
	@RequestMapping("/querystudentscore")
	public String queryStudentScore(Model model, HttpSession session) {
		Student student = (Student) session.getAttribute("loginUser");
		if(student == null) {
			return "/login";
		}
		List<Score> list = studentService.listStudentScore(student.getId());
		model.addAttribute("score", list);
		return "/student-query";
	}
	
	@RequestMapping("/studentbar")
	public String queryStudentScoreBar(int id, Model model){
		List<Score> list = studentService.listStudentScore(id);
		List<String> course = new ArrayList<String>();
		List<Double> sc = new ArrayList<Double>();
		for (Score score : list) {
			course.add(score.getCourse().getCou_name());
			sc.add(score.getScore());
		}
		JSONArray json  = JSONArray.fromObject(course);
		JSONArray json2  = JSONArray.fromObject(sc);
		model.addAttribute("course",json);
		model.addAttribute("score", json2);
		return "/student-bar";
	}
	
	@RequestMapping("/studentpie")
	public String queryStudentScorePie(int id, Model model){
		List<Score> list = studentService.listStudentScore(id);
		List<PieScore> sc = new ArrayList<PieScore>();
		List<String> course = new ArrayList<String>();
		for (Score score : list) {
			course.add(score.getCourse().getCou_name());
			sc.add(new PieScore(score.getCourse().getCou_name(),score.getScore()));
		}
		JSONArray json  = JSONArray.fromObject(sc);
		JSONArray json2  = JSONArray.fromObject(course);
		model.addAttribute("score", json);
		model.addAttribute("course", json2);
		return "/student-pie";
	}
	
}
