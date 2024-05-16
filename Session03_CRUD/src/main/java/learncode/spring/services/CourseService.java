package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import learncode.spring.models.Courses;


public interface CourseService {
	void deleteAll();

	void deleteAll(List<Courses> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Courses entity);

	void deleteById(String id);

	long count();

	List<Courses> findAllById(List<String> ids);

	List<Courses> findAll();

	boolean existsById(String id);

	Optional<Courses> findById(String id);

	List<Courses> saveAll(List<Courses> entities);

	Courses save(Courses entity);

	List<Courses> findAllCourses();

}
