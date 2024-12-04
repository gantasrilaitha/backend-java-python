package com.example.aop_proj;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class Dao1 {
	public String retrieveSomething() {
		return "dao1";
	}
}
