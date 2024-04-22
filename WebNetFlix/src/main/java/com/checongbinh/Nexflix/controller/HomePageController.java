package com.checongbinh.Nexflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.checongbinh.Nexflix.mapper.UserMapper;
import com.checongbinh.Nexflix.model.User;
import com.checongbinh.Nexflix.model.UserExample;

@Controller
public class HomePageController { // ten class trong controller 
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/") // goi cai tren thanh tim kiem
	public ModelAndView index() {
		
		ModelAndView modelAndView = new ModelAndView("index.html");
		//tao doi tuong modelandview dan den trang index
		
		
		UserExample example = new UserExample();
		List<User> listUser = userMapper.selectByExample(example);
		
		System.out.println("kiemtra:"+listUser.size());
		return modelAndView;
	}
}
