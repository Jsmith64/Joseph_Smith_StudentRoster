package repositories;

import org.springframework.data.repository.CrudRepository;

import models.Person;

public interface PersonRepository extends CrudRepository <Person, Long> {

}
