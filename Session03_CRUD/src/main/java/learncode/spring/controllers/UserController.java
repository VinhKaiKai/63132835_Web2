package learncode.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpSession;
import learncode.spring.models.User;
import learncode.spring.models.UserDAO;
import learncode.spring.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	
	//mới vô cho nó hiện trang đăng nhập. nếu không có tài khoản thì đăng ký.
	// đăng nhập oke xong nó vô trang index
	
	
	@GetMapping("/")
	public String dautien() {
		return "login";
	}
	
	@GetMapping("/trangchu")
	public String trangchu() {
		return "index";
	}
	
	
	//hàm này để dẫn tới trang "ĐĂNG KÝ"
	@GetMapping("/register")
	public String addOrEdit(ModelMap model) {
		User u = new User();
		model.addAttribute("USER", u);
		model.addAttribute("ACTION","saveOrUpdate"); // khi nhan submit thi se qua  @PostMapping("/saveOrUpdate")
		return "register-user";
	}
	
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate( ModelMap model , @ModelAttribute("USER") User user ) {
		userService.save(user);
		return "register-user";
	}
	
	
	// trang "ĐĂNG NHẬP"
	@RequestMapping("/list") // trong cái trang thêm người dùng mới của html có cái thẻ a hiển thị danh sách href chuyển hướng tới list trên requesmapping nên nó sẽ trả về trang hiển thị view 
	public String list(ModelMap model, HttpSession session) {
		if(session.getAttribute("USERNAME") != null)
		{
			model.addAttribute("USERS",userService.findAll());
			return "view-user";
		}
		return "login";
		
	}
	
	
	
	// Hàm CHỈNH SỬA 
	@RequestMapping("/edit/{username}") //bấm vào nút edit thì nó sẽ truyền cái username vô 
	public String edit(ModelMap model, @PathVariable(name = "username") String username) {
		Optional<User> u= userService.findById(username);
		
		if(u.isPresent()) {
			model.addAttribute("USER",u.get());
		}
		else {
			model.addAttribute("USER", new User()); // gán user rổng 
		}
		model.addAttribute("ACTION","/saveOrUpdate");
		return "register-user";
	}
	
	// HÀM XÓA
	@RequestMapping("/delete/{username}") //bấm vào nút edit thì nó sẽ truyền cái username vô 
	public String delete(ModelMap model, @PathVariable(name = "username") String username) {
		userService.deleteById(username);
		model.addAttribute("USERS",userService.findAll());
		return "view-user";
	}
	
	// login
	// trên cái form  khi bấm submit thì chuyển qua view-user 
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("/checklogin") // trùng với cái action của form 
	public String checkLogin(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {	
		if(userService.checkLogin(username,password))
		{
			System.out.println("Đăng nhập thành công");
			session.setAttribute("USERNAME", username);
			model.addAttribute("USERS",userService.findAll());
			return "index";
		}
		else {
			System.out.println("Đăng nhập thất bại");
			model.addAttribute("ERROR","Mật khẩu hoặc tài khoản ko tồn tại !");
		}
		return "login";
	}
	
	//hàm ĐĂNG XUẤT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USERNAME");
		return "redirect:/login";
	}
	
	
	//hàm tìm kiếm---------------------------------------------- 
	@RequestMapping("/list2")
	public String viewHomePage1(Model model, @Param("keyword") String keyword) {
		List<User> listUser = userService.listAll(keyword);
		
		model.addAttribute("USERS", listUser);
		model.addAttribute("keyword", keyword);
		return "view-user";
	}
	 
	
}
