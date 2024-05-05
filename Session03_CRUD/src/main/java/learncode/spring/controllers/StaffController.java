package learncode.spring.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import learncode.spring.dto.StaffDTO;
import learncode.spring.models.Departs;
import learncode.spring.models.Staffs;
import learncode.spring.services.DepartService;
import learncode.spring.services.StaffService;

@Controller
@RequestMapping("/staffs")
public class StaffController {
	@Autowired
	StaffService staffService;
	
	@Autowired
	DepartService departService;
	
	
	@RequestMapping("/list")
	public String listStaff(ModelMap model)
	{
		model.addAttribute("LIST_STAFF", staffService.findAll());
		return "view-staffs";
	}
	
	
	@GetMapping("/")
	public String addOrEdit(ModelMap model)
	{
		StaffDTO staff = new StaffDTO();
		model.addAttribute("STAFFDTO", staff);
		model.addAttribute("ACTION", "/staffs/saveOrUpdate");
		return "staff";
	}
	
	
	@PostMapping("/saveOrUpdate")
	public String save(ModelMap model, @ModelAttribute("STAFFDTO") StaffDTO dto) {
		Optional<Staffs> optionalStaff= staffService.findById(dto.getId());
		Staffs staff = null;
		
		String image ="Logo.png";
		Path path = Paths.get("uploads/");
		
		
		if(optionalStaff.isPresent()) {
			//save
			
		}
		else {
			// add
			if(!dto.getPhoto().isEmpty()) {
				try {
					InputStream inputStream = dto.getPhoto().getInputStream();
					Files.copy(inputStream, path.resolve(dto.getPhoto().getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
					image = dto.getPhoto().getOriginalFilename().toString();
				}
				catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		staff = new Staffs(dto.getId(), dto.getName(), dto.isGender(), dto.getBirthday(),image, dto.getEmail(),dto.getPhone(), dto.getSalary(), dto.getNotes(),
				new Departs(dto.getDepartId(),""));
		
		staffService.save(staff);
		return "staff";
	}
	
	@ModelAttribute(name = "DEPARTS")
	public List<Departs> getAllDeparts(){
		return staffService.findAllDeparts();
	}
	
}
