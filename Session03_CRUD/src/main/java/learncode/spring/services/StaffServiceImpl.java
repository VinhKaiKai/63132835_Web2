package learncode.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import learncode.spring.models.Courses;
import learncode.spring.models.Departs;
import learncode.spring.models.Staffs;
import learncode.spring.models.Students;
import learncode.spring.repositories.DepartRepository;
import learncode.spring.repositories.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{
	@Autowired
	StaffRepository staffRepository;

	@Autowired
	DepartRepository departRepository;
	
	@Override
	public List<Departs> findAllDeparts(){
		return (List<Departs>)departRepository.findAll();
	}
	@Override
	public List<Staffs> findAllStaffs(){
		return (List<Staffs>)staffRepository.findAll();
	}
	
	@Override
	public Staffs save(Staffs entity) {
		return staffRepository.save(entity);
	}

	@Override
	public List<Staffs> saveAll(List<Staffs> entities) {
		return (List<Staffs>)staffRepository.saveAll(entities);
	}

	@Override
	public Optional<Staffs> findById(String id) {
		return staffRepository.findById(id);
	}

	@Override
	public boolean existsById(String id) {
		return staffRepository.existsById(id);
	}

	@Override
	public Iterable<Staffs> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public List<Staffs> findAllById(List<String> ids) {
		return (List<Staffs>)staffRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return staffRepository.count();
	}

	@Override
	public void deleteById(String id) {
		staffRepository.deleteById(id);
	}

	@Override
	public void delete(Staffs entity) {
		staffRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		staffRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Staffs> entities) {
		staffRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		staffRepository.deleteAll();
	}
	
	//Tìm kiếm 
			@Override
			public List<Staffs> listAll(String keyword) {
				if (keyword  != null) {
					return staffRepository.search(keyword);
				}else
				
				return (List<Staffs>) staffRepository.findAll();
			}
	
	
			
		    
		    
		
	
			@Override
		    public Page<Staffs> findAll(Pageable pageable) {
		        // Implement method logic here
		        // For example, interact with a repository to fetch the data
		        return staffRepository.findAll(pageable);
		    }
			
			
	
	
}
