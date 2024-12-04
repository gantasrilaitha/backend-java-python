package com.example.demo_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo_1.entity.Review;
import com.example.demo_1.repository.CourseSpringDataRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Demo1Application.class)
public class CourseRepositoryTest {
	/*
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CourseSpringDataRepository csr;

	@Test
	@Transactional
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Test
	@DirtiesContext
	@Transactional
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	
	@Test
	@DirtiesContext
	@Transactional
	public void save_basic() {

		// get a course
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}
	
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}",course.getReviews());
	}
	
	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("{}",review.getCourse());
	}

	
	//using jpa_repo
	@Test
	public void sort() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		logger.info("Sorted Courses -> {} ", csr.findAll(sort));
		//Courses -> [Course[JPA in 50 Steps], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]] 
	}

//	@Test
//	public void pagination() {
//		PageRequest pageRequest = PageRequest.of(0, 3);
//		
//		Page<Course> firstPage = csr.findAll(pageRequest);
//		logger.info("First Page -> {} ", firstPage.getContent());
//		Pageable secondPageable = firstPage.nextPageable();
//		Page<Course> secondPage = csr.findAll(secondPageable);
//		logger.info("Second Page -> {} ", secondPage.getContent());)
//	}
	
	
	@Test
	//@Transactional
	public void findById_firstLevelCacheDemo() {
		
		Course course = repository.findById(10001L);
		logger.info("First Course Retrieved {}", course);
		//if @Transactional is mentioned: doesnt fire the query again as it retrieves from transaction boundaries of this function(1st level cache)
		//if @Transactional is not mentioned: 2 different transactions within same function
		Course course1 = repository.findById(10001L);
		logger.info("First Course Retrieved again {}", course1);

		assertEquals("JPA in 50 Steps", course.getName());
		
		assertEquals("JPA in 50 Steps", course1.getName());
	}
	*/
}