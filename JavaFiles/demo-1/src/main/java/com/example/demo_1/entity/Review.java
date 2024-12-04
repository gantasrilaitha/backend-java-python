package com.example.demo_1.entity;


import com.example.demo_1.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String rating;

	private String description;
	
	@ManyToOne//default is lazy fetch
	private Course course;
	
	protected Review() {
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description);
	}

}