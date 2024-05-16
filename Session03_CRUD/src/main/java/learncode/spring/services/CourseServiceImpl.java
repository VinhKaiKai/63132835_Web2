package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import learncode.spring.models.Courses;
import learncode.spring.models.Staffs;
import learncode.spring.repositories.CourseRepository;


@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseRepository courseRepository;

	
	@Override
	public Courses save(Courses entity) {
		return courseRepository.save(entity);
	}

	@Override
	public List<Courses> saveAll(List<Courses> entities) {
		return (List<Courses>)courseRepository.saveAll(entities);
	}

	@Override
	public Optional<Courses> findById(String id) {
		return courseRepository.findById(id);
	}
	
	@Override
	public List<Courses> findAllCourses(){
		return (List<Courses>)courseRepository.findAll();
	}

	@Override
	public boolean existsById(String id) {
		return courseRepository.existsById(id);
	}

	@Override
	public List<Courses> findAll() {
		return (List<Courses>)courseRepository.findAll();
	}

	@Override
	public List<Courses> findAllById(List<String> ids) {
		return (List<Courses>)courseRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return courseRepository.count();
	}

	@Override
	public void deleteById(String id) {
		courseRepository.deleteById(id);
	}

	@Override
	public void delete(Courses entity) {
		courseRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		courseRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Courses> entities) {
		courseRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		courseRepository.deleteAll();
	}
}
