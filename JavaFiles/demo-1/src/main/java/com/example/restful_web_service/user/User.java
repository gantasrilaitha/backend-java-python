package com.example.restful_web_service.user;
import jakarta.validation.constraints.Size;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@ApiModel("description about user")
@Table(name="allusers")

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2,message = "name must be atleast 2characters")//only 2 min characters required for validating name
	@ApiModelProperty(notes="validation added for name")
	private String name;
	
	private String age;
	
	@OneToMany(mappedBy="user")
	private List<Posts> post;
	
	public List<Posts> getPost() {
		return post;
	}
	public void setPost(List<Posts> post) {
		this.post = post;
	}
	protected User() {
			
	}
	public User(Integer id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
