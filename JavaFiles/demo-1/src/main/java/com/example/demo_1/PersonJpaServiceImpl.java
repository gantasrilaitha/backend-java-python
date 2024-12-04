package com.example.demo_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class PersonJpaServiceImpl {
	
	@Autowired
    private PersonJpaRepo personJpaRepository;
	
    // Create or Update Person
    public Person savePerson(Person person) {
        return personJpaRepository.save(person);
    }

    // Find all Persons
    public List<Person> findAllPersons() {
        return personJpaRepository.findAll();
    }

    // Find Person by ID
    public Optional<Person> findPersonGivenId(Integer id) {
        return personJpaRepository.findById(id);
    }

    // Delete Person by ID
    public void deletePersonById(Integer id) {
        personJpaRepository.deleteById(id);
    }
    
}

/*
@Service
public class PersonJpaServiceImpl {

    @PersistenceContext
    private EntityManager entityManager;

    // Use EntityManager to save a person
    @Transactional
    public Person savePerson(Person person) {
        entityManager.persist(person); // Persist a new entity
        return person;
    }

    // Use EntityManager to retrieve a person by ID
    public Person findPersonById(Integer id) {
        return entityManager.find(Person.class, id); // Find an entity
    }
 // Use EntityManager to retrieve a person by name
    public Person findPersonByName(String name) {
        return entityManager.find(Person.class, name); // Find an entity
    }
    // Use JPQL to retrieve all persons
    public List<Person> findAllPersons() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    // Use EntityManager to remove a person
    @Transactional
    public void deletePersonById(Integer id) {
        Person person = entityManager.find(Person.class, id);//find using primary key
        if (person != null) {
            entityManager.remove(person); // Remove the entity
        }
    }

    @Transactional
    public boolean updateLocationByName(String name, String location) {
    	Person person = entityManager
    	        .createQuery("SELECT p FROM Person p WHERE p.name = :name", Person.class)
    	        .setParameter("name", name)
    	        .getResultStream()
    	        .findFirst()
    	        .orElse(null);

    	    if (person == null) {
    	        return false; // Person not found
    	    }

    	    person.setLocation(location); // Update the location
    	    entityManager.flush(); // Save the updated person
    	    return true;

    }

}
*/