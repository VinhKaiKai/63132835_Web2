package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import learncode.spring.models.Courses;
import learncode.spring.models.Staffs;
import learncode.spring.models.Students;
import learncode.spring.models.User;

public interface StudentService {

	void deleteAll();

	void deleteAll(List<Students> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Students entity);

	void deleteById(String id);

	long count();

	

	Iterable<Students> findAll();

	boolean existsById(String id);

	Optional<Students> findById(String id);

	List<Students> saveAll(List<Students> entities);

	Students save(Students entity);

	List<Staffs> findallStaffs();

	List<Courses> findAllCourses();

	List<Students> findAllById(List<String> ids);

	//Tìm kiếm
		public List<Students> listAll(String keyword);
}
