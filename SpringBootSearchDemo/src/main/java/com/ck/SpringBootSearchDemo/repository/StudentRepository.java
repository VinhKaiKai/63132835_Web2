package com.ck.SpringBootSearchDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ck.SpringBootSearchDemo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("SELECT student FROM Student student WHERE CONCAT(student.sid, ' ', student.sname, ' ', student.scity) LIKE %?1%")
	public List<Student> search(String keyword);
	public Student findBySname(String sname);


}
