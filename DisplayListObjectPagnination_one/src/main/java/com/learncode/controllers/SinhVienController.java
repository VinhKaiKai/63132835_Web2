package com.learncode.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learncode.models.SinhVien;
import com.learncode.services.SinhvienService;


@Controller
public class SinhVienController {
	
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
	
	// Trong package controller
	@RestController
	@RequestMapping("/students")
	public class StudentController {

	    @Autowired
	    private StudentService studentService;

	    @GetMapping
	    public List<SinhVien> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @GetMapping("/{id}")
	    public SinhVien getStudentById(@PathVariable int id) {
	        return studentService.getStudentById(id);
	    }

	    @PostMapping
	    public ResponseEntity<String> addStudent(@RequestBody SinhVien student) {
	        studentService.addStudent(student);
	        return ResponseEntity.ok("Student added successfully with ID: " + student.getMaSoSV());
	    }
	}
}
