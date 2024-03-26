package thiGK.ntu63132835.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SinhVienController {

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/ThongTin")
	public String ThongTin() {
		return "ThongTin";
	}
	
	@RequestMapping("/Anh")
	public String Anh() {
		return "Anh";
	}
	
}
