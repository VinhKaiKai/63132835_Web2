package com.learncode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CalCulatorController {
	@RequestMapping("/cal")
	public String showForm()
	{
		return "calculator";
	}
	
	@RequestMapping(value = "/result", params = "tong")
	public String calTong(HttpServletRequest request, ModelMap model)
	{
		double soa = Double.parseDouble(request.getParameter("soA"));
		double sob = Double.parseDouble(request.getParameter("soB"));
		double ketqua = soa+ sob;
		model.addAttribute("CHUYENA", soa);
		model.addAttribute("CHUYENB", sob);
		model.addAttribute("DAU", "+");
		model.addAttribute("KETQUA", ketqua);
		System.out.println("Kết quả là: "+ (ketqua));
		return "ketqua";
	}
	@RequestMapping(value = "/result" , params = "Tru")
	public String calTru(HttpServletRequest request , ModelMap model)
	{
		double soa = Double.parseDouble(request.getParameter("soA"));
		double sob = Double.parseDouble(request.getParameter("soB"));
		double ketqua = soa- sob;
		model.addAttribute("CHUYENA", soa);
		model.addAttribute("CHUYENB", sob);
		model.addAttribute("DAU", "-");
		model.addAttribute("KETQUA", ketqua);
		System.out.println("Kết quả là: "+ (ketqua));
		return "ketqua";
	}
}
