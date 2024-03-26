package com.vinh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.vinh.springboot.model.User;



@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@PostMapping("/register")
	public String userregister(@ModelAttribute User user, Model model ) {
		System.out.println(user.toString());
		//dữ liệu
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getDob());
		System.out.println(user.getEmail());
		model.addAttribute("ho", user.getFname());
		model.addAttribute("ten", user.getLname());
		model.addAttribute("ngaysinh",user.getDob());
		return "vinh";
	}
}
