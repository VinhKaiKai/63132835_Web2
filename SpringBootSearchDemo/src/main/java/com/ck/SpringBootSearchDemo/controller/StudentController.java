package com.ck.SpringBootSearchDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ck.SpringBootSearchDemo.model.Student;
import com.ck.SpringBootSearchDemo.service.StudentServices;

@Controller
public class StudentController {

	@Autowired
	StudentServices service;

	@RequestMapping("index")
	public String viewHomePage1(Model model, @Param("keyword") String keyword) {
		List<Student> listStudent = service.listAll(keyword);
		
		model.addAttribute("listStudent", listStudent);
		model.addAttribute("keyword", keyword);
		return "index";
	}
	


}
