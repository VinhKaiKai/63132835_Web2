package learncode.spring.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import learncode.spring.models.User;

// nhưng thay đổi cái CrudRepository thành cái  JpaRepository

public interface UserRepository extends JpaRepository<User, String>{ // String này là khóa chính dùng dì thì dùng đó

	// chức năng tìm kiếm
	@Query("SELECT Users FROM User Users WHERE CONCAT(Users.username, ' ', Users.password, ' ', Users.fullname) LIKE %?1%")
	
	
	public List<User> search(String keyword);  
	public User findByfullname(String fullname); 
	
	
	
	
    
  

}
