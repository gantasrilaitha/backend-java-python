package com.example.demo_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo_1.entity.Passport;
import com.example.demo_1.entity.Student;
import com.example.demo_1.repository.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Demo1Application.class)
public class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void someTest() {
		repository.someOperationToUnderstandPersistenceContext();
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}",student.getPassport());
	}
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}
	
	
}
