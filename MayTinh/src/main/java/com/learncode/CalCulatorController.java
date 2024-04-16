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
	
	@RequestMapping(value = "/result", params = "tong") // cái đầu là cái khi 8080/result // cái thứ 2 là cái name của view calculator 
	public String calTong(HttpServletRequest request, ModelMap model)
	{
		double soa = Double.parseDouble(request.getParameter("soA")); // lấy 2 số từ cái view calculator 
		double sob = Double.parseDouble(request.getParameter("soB")); // tương tự lấy 2 số từ cái view calculator
		double ketqua = soa+ sob; // kết quả từ 2 cái số trên
		model.addAttribute("CHUYENA", soa); // dùng model để đưa cái số a qua view ketqua để hiển thị 
		model.addAttribute("CHUYENB", sob); // tương tự
		model.addAttribute("DAU", "+"); 	// chuyển dấu cộng qua để hiện lên cho đẹp
		model.addAttribute("KETQUA", ketqua); 	// chuyển kết quả đã tính qua trang view ketqua
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
