package com.learncode;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
	
	@RequestMapping("/")
	public String getPeople(Model model) {
		model.addAttribute("something","vinh dep trai");
		model.addAttribute("people", Arrays.asList(
				new Person("Lập", 20),
				new Person("Huy",22),
				new Person("Vinh",22)
				));
		return "people";
	}
}
