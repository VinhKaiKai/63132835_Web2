package learncode.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learncode.spring.models.Staffs;
import learncode.spring.models.Students;

@Repository
public interface StaffRepository extends CrudRepository<Staffs,String>{

	// chức năng tìm kiếm nam và nữ , chưa và rồi
	@Query("SELECT s FROM Staffs s WHERE CONCAT(s.id, ' ', s.name, ' ', CASE WHEN s.gender = true THEN 'nam' ELSE 'nu' END, ' ', s.salary, ' ', s.departs.name) LIKE %?1%")
	    List<Staffs> search(String keyword);
  	

	public Staffs findBygender(Boolean gender);
	
}
