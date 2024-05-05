package learncode.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learncode.spring.models.Staffs;

@Repository
public interface StaffRepository extends CrudRepository<Staffs,String>{

}
