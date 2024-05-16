package learncode.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import learncode.spring.models.Courses;


@Repository
public interface CourseRepository extends CrudRepository<Courses , String>{

}
