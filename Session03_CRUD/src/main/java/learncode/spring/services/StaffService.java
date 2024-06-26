package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import learncode.spring.models.Courses;
import learncode.spring.models.Departs;
import learncode.spring.models.Staffs;
import learncode.spring.models.Students;


public interface StaffService {

	void deleteAll();

	void deleteAll(List<Staffs> entities);

	void deleteAllById(Iterable<? extends String> ids);

	void delete(Staffs entity);

	void deleteById(String id);

	long count();

	List<Staffs> findAllById(List<String> ids);

	Iterable<Staffs> findAll();

	boolean existsById(String id);

	Optional<Staffs> findById(String id);

	List<Staffs> saveAll(List<Staffs> entities);

	Staffs save(Staffs entity);

	List<Departs> findAllDeparts();

	List<Staffs> findAllStaffs();

	//Tìm kiếm
	public List<Staffs> listAll(String keyword);

	// Thêm phương thức để lấy danh sách nhân viên theo trang
    Page<Staffs> findAll(Pageable pageable);

	
}
