package learncode.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learncode.spring.models.Departs;

@Repository
public interface DepartRepository extends CrudRepository<Departs , String>{

}
