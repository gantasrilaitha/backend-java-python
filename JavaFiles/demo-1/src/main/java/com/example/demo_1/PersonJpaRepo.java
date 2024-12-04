package com.example.demo_1;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface  PersonJpaRepo extends JpaRepository <Person, Integer>{

	
	
	Optional<Person> findById(int id);

	List<Person> findAll();

	Person save(Person person);

	void deleteById(Integer id);
	
	
}
