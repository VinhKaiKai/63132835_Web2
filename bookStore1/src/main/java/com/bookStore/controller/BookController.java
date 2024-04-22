package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.entity.Book;
import com.bookStore.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/bookregister")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	@GetMapping("/availablebook")
	public String getAllBook() {
		return "booklist";
	}
	
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		
		service.save(b);
		return "redirect:/availablebook";//đi tới cái trang availableBook
	}
}
