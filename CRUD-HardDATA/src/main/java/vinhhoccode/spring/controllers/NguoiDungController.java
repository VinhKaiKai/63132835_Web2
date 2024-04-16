package vinhhoccode.spring.controllers;

import javax.swing.event.TableColumnModelListener;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vinhhoccode.spring.models.NguoiDung;
import vinhhoccode.spring.models.UserDao;

@Controller
public class NguoiDungController {
	
	@GetMapping("/")
	public String ThemVaXoa(ModelMap model)
	{
		NguoiDung u = new NguoiDung();
		//u.setUsername("Trầm Quang Vinh");
		model.addAttribute("USER",u);
		model.addAttribute("ACTION","saveOrUpdate");
		return "register-user";
	}
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user ) {
		UserDao dao = new UserDao();
		dao.save(user);
		return "register-user";
	}
	
	@RequestMapping("/list")
	public String DanhSach()
	{
		return "view-user";
	}
	
	
}
