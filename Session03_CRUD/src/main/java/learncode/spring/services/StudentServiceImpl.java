package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learncode.spring.models.Courses;
import learncode.spring.models.Departs;
import learncode.spring.models.Staffs;
import learncode.spring.models.Students;
import learncode.spring.models.User;
import learncode.spring.repositories.CourseRepository;
import learncode.spring.repositories.DepartRepository;
import learncode.spring.repositories.StaffRepository;
import learncode.spring.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StaffRepository staffRepository;

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public List<Courses> findAllCourses(){
		return (List<Courses>)courseRepository.findAll();
	}
	@Override
	public List<Staffs> findallStaffs(){
		return (List<Staffs>)staffRepository.findAll();
	}
	
	@Override
	public Students save(Students entity) {
		return studentRepository.save(entity);
	}

	@Override
	public List<Students> saveAll(List<Students> entities) {
		return (List<Students>)studentRepository.saveAll(entities);
	}

	@Override
	public Optional<Students> findById(String id) {
		return studentRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return studentRepository.existsById(id);
	}

	@Override
	public Iterable<Students> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Students> findAllById(List<String> ids) {
		return (List<Students>)studentRepository.findAllById(ids);
	}
	
	

	@Override
	public long count() {
		return studentRepository.count();
	}

	@Override
	public void deleteById(String id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void delete(Students entity) {
		studentRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		studentRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Students> entities) {
		studentRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		studentRepository.deleteAll();
	}
	//Tìm kiếm 
		@Override
		public List<Students> listAll(String keyword) {
			if (keyword  != null) {
				return studentRepository.search(keyword);
			}else
			
			return (List<Students>) studentRepository.findAll();
		}
}
