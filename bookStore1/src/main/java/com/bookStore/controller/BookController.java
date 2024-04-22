package com.bookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
	@GetMapping("/bookregister")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	@GetMapping("/availablebook")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBook();
//		ModelAndView m = new ModelAndView();
//		m.setViewName("booklist");
//		m.addObject("book",list);
		return new ModelAndView("booklist","book", list);
	}
	
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		
		service.save(b);
		return "redirect:/availablebook";//đi tới cái trang availableBook
	}
	
	
	
	@GetMapping("/my_books")
	public String getMyBooks() {
		return "myBooks";
	}
	
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b= service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
}