package com.learncode.controllers;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloworldController {
	
	@RequestMapping("/hello")
	public String showHello()
	{
		return "helloworld";
	}
	
	@GetMapping("/HelloName")
	public String helloName() 
	{
		return "helloworld";
	}
	
	@GetMapping("/NoiDung")
	public String NoiDung(HttpServletRequest request) 
	{
		String name = request.getParameter("name");
		System.out.println("=>" + name);
		request.setAttribute("NAME",name);
		return "NoiDung";
	}
}
