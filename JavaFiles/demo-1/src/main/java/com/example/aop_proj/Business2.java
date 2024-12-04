package com.example.aop_proj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
	
	@Autowired
	private Dao2 dao2;
	
	//Business Logic
	public String calSomething() {
		return dao2.retrieveSomething();
	}
}
