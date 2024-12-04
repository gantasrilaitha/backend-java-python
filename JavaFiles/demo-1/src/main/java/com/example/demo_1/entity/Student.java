package com.example.demo_1.entity;


import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;

import com.example.demo_1.Course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", 
	joinColumns = @JoinColumn(name = "STUDENT_ID"), 
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	protected Student() {
	}

	public Student(String name) {
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

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}

	public Passport getPassport() {
		return passport;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
}