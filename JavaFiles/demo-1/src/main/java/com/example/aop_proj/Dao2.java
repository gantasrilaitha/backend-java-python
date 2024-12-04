package com.example.aop_proj;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class Dao2 {
	public String retrieveSomething() {
		return "dao2";
	}
}
