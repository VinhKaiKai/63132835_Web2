package com.learncode.controllers;

import java.security.KeyStore.Entry.Attribute;
import java.util.List;

import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learncode.models.Major;
import com.learncode.models.MajorDao;
import com.learncode.models.Student;
import com.learncode.models.StudentDao;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	MajorDao mdao = new MajorDao();
	StudentDao sdao = new StudentDao();
	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		model.addAttribute("STUDENT", new Student(0,"",0, new Major(0,"")));
		return "student-form";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model,@ModelAttribute("STUDENT") Student st) {
		Major m = mdao.findByID(st.getMajor().getId());
		st.setMajor(m);
		sdao.add(st);
		return "student-form";
	}
	
	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("LIST_STUDENT", sdao.getAll());
		return "view-student";
	}
	
	@ModelAttribute("list_major")
	public List<Major> getMajor(){
		return mdao.getAll();
	}
	
	
}
