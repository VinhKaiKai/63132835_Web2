package thiGK.ntu63132835.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learncode.services.SinhvienService;

import thiGK.ntu63132835.models.SinhVien;
import thiGK.ntu63132835.services.SinhVienService;


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
	
	
	@Autowired
	 private SinhvienService svService;
	 
	@GetMapping("/danhsachSV")
	public String listStudent(Model model,  
								@RequestParam("page") Optional<Integer> page,
								@RequestParam("size") Optional<Integer> size)
	{
		final int currentPage = page.orElse(1);
      final int pageSize = size.orElse(5);
      Page<SinhVien> svPage = svService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
		model.addAttribute("dsSV", svPage);
		
		int totalPages = svPage.getTotalPages();
      if (totalPages > 0) {
          List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
              .boxed()
              .collect(Collectors.toList());
          model.addAttribute("pageNumbers", pageNumbers);
      }
      return "sinhvien_getAll_Paged";
	}
	
}
