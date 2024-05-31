package learncode.spring.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import learncode.spring.models.Staffs;
import learncode.spring.models.Students;

@Repository
public interface StaffRepository extends JpaRepository<Staffs,String>{

	// chức năng tìm kiếm nam và nữ , chưa và rồi
	@Query("SELECT s FROM Staffs s WHERE CONCAT(s.id, ' ', s.name, ' ', CASE WHEN s.gender = true THEN 'nam' ELSE 'nu' END, ' ', s.salary, ' ', s.departs.name) LIKE %?1%")
	    List<Staffs> search(String keyword);
  	

	public Staffs findBygender(Boolean gender);
	
	// Tạo phương thức để lấy danh sách nhân viên theo trang
    //Page<Staffs> findAll(Pageable pageable);
	
    
    
    
	
	
}
