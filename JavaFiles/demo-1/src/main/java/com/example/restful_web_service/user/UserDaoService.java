package com.example.restful_web_service.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	@Autowired 
	private UserRepository urr;
	
	private static List<User> usr=new ArrayList<>();
	private static int user_cnt=2;
	
	static{
		usr.add(new User(1,"ab","22"));
		usr.add(new User(2,"bc","21"));
	}
	public List<User> findAll(){
		return usr;
	}
	public User save(User u) {
		if (u.getId()==null) {
			u.setId(++user_cnt);
		}
		usr.add(u);
		return u;
	}
	public Optional<User> findOne(int id) {
		Optional<User> u=urr.findById(id);
//		for(User u:usr) {
//			if (u.getId()==id) {
//				return u;
//			}
//		}
		return u;
	}
	public User deleteById(int id) {
		Iterator<User> it=usr.iterator();
		while(it.hasNext()) {
			User u=it.next();
			if(u.getId()==id) {
				it.remove();
				return u;
			}
		
		}
		return null;
	}
}
