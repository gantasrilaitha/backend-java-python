package com.example.demo_1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.example.demo_1.entity.Review;
import com.example.demo_1.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
//named queries for jpql
@NamedQueries(value = { 
		@NamedQuery(name = "query_get_all_courses", 
				query = "Select  c  From Course c"),
		@NamedQuery(name = "query_get_100_Step_courses", 
		query = "Select  c  From Course c where name like '%100 Steps'") })

@Cacheable
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted = false")
@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToMany(mappedBy="course")//default is lazy fetch; eager fetch :does complete join of both tables & retrieves data for both tables
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore// to ignore some fields or if they result in cyclic import
	private List<Student> students = new ArrayList<>();
	
	private boolean isDeleted;
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	public void addStudent(Student student) {
		this.students.add(student);
	}
	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}
