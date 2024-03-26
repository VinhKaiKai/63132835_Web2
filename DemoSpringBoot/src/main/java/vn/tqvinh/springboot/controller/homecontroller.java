package vn.tqvinh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class homecontroller {
	@GetMapping("/")
	public String trangchu() 
	{
		return "index";
	}
}
