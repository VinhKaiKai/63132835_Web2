package com.learncode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
	@RequestMapping("/student/form")
	public String showForm() {
	
		return "student-form";
		
	}
	
	@RequestMapping("/student/save")
	public String saveData(HttpServletRequest request, ModelMap model) {
		
		String tenString = request.getParameter("name");
		String diemString= request.getParameter("mark");
		String chuyennghanhString= request.getParameter("major");
		
		model.addAttribute("TEN","Họ và tên: "+ tenString );
		model.addAttribute("DIEM","Điểm chuyên nghành: "+ diemString);
		model.addAttribute("CHUYENNGHANH","Chuyên nghành học: "+ chuyennghanhString);
		
		
		return "student-infor";
	}
}
