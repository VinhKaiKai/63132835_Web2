package learncode.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import learncode.spring.models.User;

public interface UserRepository extends CrudRepository<User, String>{ // String này là khóa chính dùng dì thì dùng đó

}
