package com.hrbust.feedback.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrbust.feedback.domain.Score;
import com.hrbust.feedback.domain.Student;
import com.hrbust.feedback.domain.Teacher;
import com.hrbust.feedback.service.StudentService;
import com.hrbust.feedback.service.TeacherService;
import com.hrbust.feedback.util.CheckUtil;
import com.hrbust.feedback.util.StudentScore;

@Controller
public class TeacherController {
	
	private TeacherService teacherService;
	private StudentService studentService;
	
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

	@RequestMapping("/goteacherinfo")
	public String goTeacherInfo(HttpSession session, Model model) {
		if(session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Teacher teacher = (Teacher) session.getAttribute("loginUser");
		model.addAttribute("teacher", teacher);
		return "/teacher-info";
	}
	
	@RequestMapping("/goteacherchange")
	public String goTeacherChange() {
		return "/teacher-change";
	}
	@RequestMapping("/teacherqueryscore")
	public String goTeacherQuery(){
		return "/teacher-query";
	}
	
	@RequestMapping("/changteacherpassword")
	public String changePassword(String oldPassword, String newPassword, String rePassword, Model model, HttpSession session) {
		if(session.getAttribute("loginUser") == null) {
			return "/login";
		}
		Teacher teacher = (Teacher) session.getAttribute("loginUser");
		
		if(!newPassword.equals(rePassword)) {
			model.addAttribute("error","新密码两次输入不一致");
			return "/teacher-change";
		}
		if(CheckUtil.checkPassword(teacher.getPassword(), oldPassword)) {
			teacher.setPassword(newPassword);
			teacherService.updateTeacher(teacher);
			session.setAttribute("loginUser", teacher);
			return "/login";
		}
		model.addAttribute("error", "原密码不正确,请重试!");
		return "/login";
	}
	
	@RequestMapping("/teacherquery")
	public String queryStudentScore(HttpSession session, String target, String message, Model model){
		if(session.getAttribute("loginUser") == null) return "/login";
		if(message != null && message.trim().length() != 0){
			byte[] arr;
			try {
				arr = message.getBytes("iso-8859-1");
				message = new String(arr, "UTF-8");
			} catch (UnsupportedEncodingException e1) {
			}
		}
		if(target != null && target.trim().length() != 0){
			if(target.equals("name")){
				List<Student> list = studentService.listStudentByName(message);
				model.addAttribute("list", list);
				model.addAttribute("type", "student");
				return "/teacher-query";
			} else if(target.equals("account")) {
				Student student = studentService.loadStudentByAccount(message);
				if(student == null) {
					model.addAttribute("error", "用户不存在");
				}
				List<Score> list = studentService.listStudentScore(student.getId());
				model.addAttribute("list", list);
				model.addAttribute("stu_name", student.getStu_name());
				model.addAttribute("type", "score");
				return "/teacher-query";
			} else if(target.equals("grade")) {
				List<Student> list = teacherService.listStudentByGrade(message);
				model.addAttribute("list", list);
				model.addAttribute("type", "student");
				return "/teacher-query";
			} 
		}
		return "error";
	}
	
	@RequestMapping("/student")
	public String Students(int id, Model model, HttpSession session) {
		if(session.getAttribute("loginUser") == null) return "/login";
		Teacher teacher = (Teacher) session.getAttribute("loginUser");
		List<Student> list = teacherService.listStudentByTeacher(id);
		List<StudentScore> data = new ArrayList<StudentScore> ();
		int course_id = teacher.getCourse().getId();
		for (Student student : list) {
			Score score = teacherService.loadScoreByCourse(student.getId(), course_id);
			double s;
			if(score == null) {
				s = 0;
			} else {
				s = score.getScore();
			}
			data.add(new StudentScore(student.getGrade().getGra_name(), student.getStu_name(), s));
		}
		model.addAttribute("list", data);
		return "/teacher-students";
	}
	
	@RequestMapping("/newscore")
	public String newScore(int id, Model model,HttpSession session) {
		if(session.getAttribute("loginUser") == null) return "/login";
		Teacher teacher = (Teacher) session.getAttribute("loginUser");
		List<Student> list = teacherService.listStudentByTeacher(id);
		int course_id = teacher.getCourse().getId();
		ListIterator<Student> it = list.listIterator();
		while(it.hasNext()) {
			Student student = it.next();
			Score score = teacherService.loadScoreByCourse(student.getId(), course_id);
			if (score != null){
				it.remove();
			}
		}
		model.addAttribute("list", list);
		return "/teacher-newscore";
	}
	
	@RequestMapping("/addscore")
	public String addScore(Model model, HttpSession session,int student) {
		if(session.getAttribute("loginUser") == null) return "/login";
		Student stu= studentService.loadStudent(student);
		model.addAttribute("data",stu);
		return "/teacher-addscore";
	}
	
	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String Score(Model model, HttpSession session, int student, double score) {
		if(session.getAttribute("loginUser") == null) return "/login";
		Teacher teacher = (Teacher) session.getAttribute("loginUser");
		Student stu = studentService.loadStudent(student);
		Score scor = new Score();
		scor.setCourse(teacher.getCourse());
		scor.setStudent(stu);
		scor.setScore(score);
		teacherService.addScore(scor);
		
		List<Student> list = teacherService.listStudentByTeacher(teacher.getId());
		int course_id = teacher.getCourse().getId();
		ListIterator<Student> it = list.listIterator();
		while(it.hasNext()) {
			Student stud = it.next();
			Score sco = teacherService.loadScoreByCourse(stud.getId(), course_id);
			if (sco != null){
				it.remove();
			}
		}
		model.addAttribute("list", list);
		return "/teacher-newscore";
	}
}
