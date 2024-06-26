package learncode.spring.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import learncode.spring.dto.StaffDTO;
import learncode.spring.dto.StudentDTO;
import learncode.spring.models.Courses;
import learncode.spring.models.Departs;
import learncode.spring.models.Staffs;
import learncode.spring.models.Students;
import learncode.spring.models.User;
import learncode.spring.services.CourseService;
import learncode.spring.services.DepartService;
import learncode.spring.services.StaffService;
import learncode.spring.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;

	@Autowired
	CourseService courseService;

	@Autowired
	StaffService staffService;

	@Autowired
	DepartService departService;

	@RequestMapping("/list")
	public String listStudent(ModelMap model) {
		// Lấy số lượng học sinh chưa đóng học phí
		long countHocSinhChuaDongHocPhi = studentService.countByHthocphi(false);
		model.addAttribute("countHocSinhChuaDongHocPhi", countHocSinhChuaDongHocPhi);

		// Thêm danh sách học sinh vào model
		model.addAttribute("LIST_STUDENT", studentService.findAll());

		return "view-students";
	}

	// hàm thêm add học sinh
	@GetMapping("/vinh")
	public String addOrEdit(ModelMap model) {
		StudentDTO student = new StudentDTO();
		model.addAttribute("STUDENTDTO", student);
		model.addAttribute("ACTION", "/students/saveOrUpdate");
		return "student";
	}

	@PostMapping("/saveOrUpdate")
	public String save(ModelMap model, @ModelAttribute("STUDENTDTO") StudentDTO dto) {
		
		//kiểm tra xem sinh viên với ID từ form có tồn tại trong cơ sở dữ liệu không
		Optional<Students> optionalStudent = studentService.findById(dto.getId());
		// đối tượng sẽ tạo ra 
		Students student = null;
		// ảnh mặc định
		String image = "Logo.png";
		// đường dẫn tới ảnh
		Path path = Paths.get("uploads/");
		
		if (optionalStudent.isPresent()) {
			// save
			//Nếu không có ảnh mới 
			//giữ nguyên ảnh hiện tại của sinh viên từ cơ sở dữ liệu 
			if (dto.getPhoto().isEmpty()) {
				image = optionalStudent.get().getPhoto();
			} else {
				try {
					//Nếu có ảnh mới, lưu ảnh mới vào thư mục uploads/ 
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),
							StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		} else {
			// add
			//Nếu không có ảnh được tải lên, sử dụng ảnh mặc định là "Logo.png".
			if (!dto.getPhoto().isEmpty()) {
				try {
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),
							StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

		//tạo học sinh mới 
		student = new Students(dto.getId(), dto.getName(), dto.isGender(), dto.getBirthday(), dto.getNgaydangkyhoc(),
				image, dto.getEmail(), dto.getPhone(), dto.isHthocphi(), new Courses(dto.getCourseId(), ""),
				new Staffs(dto.getStaffId(), ""));
		// tạo xong rồi lưu
		studentService.save(student);
		return "student";
	}

	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Optional<Students> opStudent = studentService.findById(id);
		StudentDTO dto = null;

		if (opStudent.isPresent()) {
			Students st = opStudent.get();
			File file = new File("uploads/" + st.getPhoto());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multiphoto = new MockMultipartFile("file", file.getName(), "text/plain",
						org.apache.commons.io.IOUtils.toByteArray(input));

				dto = new StudentDTO(st.getId(), st.getName(), st.isGender(), st.getBirthday(), st.getNgaydangkyhoc(),
						multiphoto, st.getEmail(), st.getPhone(), st.isHthocphi(), st.getCourses().getId(),
						st.getStaffs().getId());

			} catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			model.addAttribute("STUDENTDTO", dto);
		} else {
			model.addAttribute("STUDENTDTO", new StudentDTO());
		}
		model.addAttribute("ACTION", "/students/saveOrUpdate");
		return "student";
	}

	// hàm xóa
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name = "id") String id) {
		studentService.deleteById(id);
		model.addAttribute("LIST_STUDENT", studentService.findAll());
		return "view-students";
	}

	@ModelAttribute(name = "COURSES")
	public List<Courses> getAllDeparts() {
		return courseService.findAllCourses();
	}

	@ModelAttribute(name = "STAFFS")
	public List<Staffs> getallstaffs() {
		return staffService.findAllStaffs();
	}

	// hàm tìm kiếm---------------------------------------------- 
	@RequestMapping("/list2")
	public String viewHomePage1(Model model, @Param("keyword") String keyword, @RequestParam("p") Optional<Integer> p) {
		List<Students> listStudent = studentService.listAll(keyword);

		
		long countHocSinhChuaDongHocPhi = studentService.countByHthocphi(false);
		model.addAttribute("countHocSinhChuaDongHocPhi", countHocSinhChuaDongHocPhi);
		
		model.addAttribute("LIST_STUDENT", listStudent);
		
		model.addAttribute("keyword", keyword);
		return "view-students2";
	}

	@GetMapping("/list/page")
	public String page(Model model, @RequestParam("p") Optional<Integer> p) {

		long countHocSinhChuaDongHocPhi = studentService.countByHthocphi(false);
		model.addAttribute("countHocSinhChuaDongHocPhi", countHocSinhChuaDongHocPhi);

		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Students> page = studentService.findAllPage(pageable);
		model.addAttribute("LIST_STUDENT", page);
		return "view-students";
	}
}
