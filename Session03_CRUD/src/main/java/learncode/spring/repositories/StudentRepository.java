package learncode.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



import learncode.spring.models.Students;


@Repository
public interface StudentRepository extends CrudRepository<Students,String>{

	// chức năng tìm kiếm
		//@Query("SELECT s FROM Students s WHERE CONCAT(s.id, ' ', s.name, ' ', s.gender, ' ', s.hthocphi) LIKE %?1% ")
		//public List<Students> search(String keyword);
	
	// chức năng tìm kiếm nam và nữ , chưa và rồi
	  	@Query("SELECT s FROM Students s WHERE CONCAT(s.id, ' ', s.name, ' ', CASE WHEN s.gender = true THEN 'nam' ELSE 'nu' END, ' ', CASE WHEN s.hthocphi = true THEN 'rồi' ELSE 'chưa' END) LIKE %?1%")
	  	List<Students> search(String keyword);

		public Students findByhthocphi(Boolean hthocphi);
}
