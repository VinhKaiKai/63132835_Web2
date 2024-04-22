package com.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {
	
	
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b)
	{
		bRepo.save(b);
	}
}
