package com.checongbinh.Nexflix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController { // ten class trong controller 
	@GetMapping("/") // goi cai tren thanh tim kiem
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("index.html"); //tao doi tuong modelandview dan den trang index
		return modelAndView;
	}
}
