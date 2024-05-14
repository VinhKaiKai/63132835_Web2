package learncode.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



import learncode.spring.models.User;

public interface UserRepository extends CrudRepository<User, String>{ // String này là khóa chính dùng dì thì dùng đó

	// chức năng tìm kiếm
	@Query("SELECT Users FROM User Users WHERE CONCAT(Users.username, ' ', Users.password, ' ', Users.fullname) LIKE %?1%")
	public List<User> search(String keyword);
	public User findByfullname(String fullname);

}
