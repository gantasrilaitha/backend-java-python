package com.example.demo_1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.example.demo_1.entity.FullTimeEmployee;
import com.example.demo_1.entity.PartTimeEmployee;
import com.example.demo_1.entity.Review;
import com.example.demo_1.entity.Student;
import com.example.demo_1.repository.EmployeeRepository;
import com.example.demo_1.repository.StudentRepository;


@SpringBootApplication
public class Demo1Application implements  CommandLineRunner{
	private Logger logger=LoggerFactory.getLogger(this.getClass())	;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	

//	@Autowired
//	private CourseRepository repository;
	@Autowired
	private StudentRepository studentRepository;
//	@Autowired
//	private CourseRepository courseRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run (String... args) throws Exception{
		//studentRepository.saveStudentWithPassport();
		
		//logger.info("User with id ->{}",repository.findById(10001L));
		
		//List<Review> reviews = new ArrayList<>();
		
		//reviews.add(new Review("5", "ggg"));	
		//reviews.add(new Review("5", "hhh"));

		//courseRepository.addHardcodedReviewsForCourse();
		//courseRepository.addReviewsForCourse(10003L, reviews );
		
		//studentRepository.insertStudentAndCourse(new Student("Jack"), 
		//		new Course("Microservices in 100 Steps"));
		
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All Employees -> {}", employeeRepository.retrieveAllEmployees());
		
	}

}
