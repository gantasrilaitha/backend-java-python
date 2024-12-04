package com.example.demo_1.entity;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)//default strategy, all inheritance classes are present in 1table ie Employee; disadv: all nullable values in columns
//@DiscriminatorColumn(name="EmployeeType")//name for DTYPE of the concrete classes that inherited from base class
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//table for each concrete classes with common columns; good performance
@Inheritance(strategy=InheritanceType.JOINED)//cretea separate tables for super class & each of the concrete classes & retrieves using joins & no duplication of columns(common fields) among base & child classes; low performance
//@MappedSuperClass//no inheritance,remove @Entity, only concrete class tables created
public abstract class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {
	}

	public Employee(String name) {
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
		return String.format("Employee[%s]", name);
	}
}
