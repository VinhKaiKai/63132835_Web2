package com.ck.SpringBootSearchDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ck.SpringBootSearchDemo.model.Student;
import com.ck.SpringBootSearchDemo.repository.StudentRepository;

@Service
public class StudentServices {

	@Autowired
	private StudentRepository repo;
	
	/* Code given below use for search and list */
	public List<Student> listAll(String keyword) {
		if (keyword  != null) {
			return repo.search(keyword);
		}else
		
		return (List<Student>) repo.findAll();
	}
	
	


}
