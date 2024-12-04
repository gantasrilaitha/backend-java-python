package com.example.aop_proj;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class Business1 {
	
	@Autowired
	private Dao1 dao1;
	
	//Business Logic
	public String calSomething() {
		return dao1.retrieveSomething();
	}
}
