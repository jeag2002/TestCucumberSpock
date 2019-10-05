package es.dreams.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<Person, Long>{
	
	 public List<Person> findByFullNameLike(String name);
	 public List<Person> findByDateOfBirthGreaterThan(Date date);
	

}
