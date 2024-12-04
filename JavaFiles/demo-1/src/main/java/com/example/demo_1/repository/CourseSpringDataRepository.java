package com.example.demo_1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo_1.Course;

@RepositoryRestResource(path="courses")//this is a rest repository service now,available at localhost:<port>/courses
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(String name);

	List<Course> findByNameOrderByIdDesc(String name);

	List<Course> deleteByName(String name);

	@Query("Select  c  From Course c where name like '%100 Steps'")//use jpql
	List<Course> courseWith100StepsInName();

	@Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)//use native query
	List<Course> courseWith100StepsInNameUsingNativeQuery();

	@Query(name = "query_get_100_Step_courses")//use named query
	List<Course> courseWith100StepsInNameUsingNamedQuery();
}