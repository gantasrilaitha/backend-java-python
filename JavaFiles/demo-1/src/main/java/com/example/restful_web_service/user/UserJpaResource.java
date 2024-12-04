package com.example.restful_web_service.user;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.context.MessageSource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {
	
	@Autowired
	@Qualifier("bms")
	private MessageSource ms;
	
	@Autowired
	private UserDaoService uds;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private PostRepository pr;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUser(){
		return ur.findAll();
	}
	
	@GetMapping("/jpa/users/{id}" )
	public Optional<User> find_user(@PathVariable int id) {
		Optional<User> u= uds.findOne(id);
		if (u==null) {
			throw new UserNotFoundException("id -"+id);
		}
		return u;
		//hateoas
		//ControllerLinkBuilder.linkTo=linkTo(methodOn(this.getClass()).retrieveAllUser());
		//res.add(linkTo.withRel("all-users"));
		//return res;
	}
	
	@PostMapping("/jpa/user")
	public ResponseEntity<Object> create_user (@Valid @RequestBody User new_user) {
		 User saved_user=ur.save(new_user);
		 //path("/{id}") : creates /user/id-->uri of new resource added
		 URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
		 buildAndExpand(saved_user.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
		 	
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void del_user(@PathVariable int id) {
		User u= uds.deleteById(id);
		if (u==null) {
			throw new UserNotFoundException("id -"+id);
		}
		
	}
	 @PutMapping("jpa/user/{id}/{age}")
	    public ResponseEntity<String> updateAge(@PathVariable int id, @PathVariable int age) {
	        Optional<User> userOptional = ur.findById(id);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            user.setAge(String.valueOf(age)); // Assuming `age` is stored as a string
	            ur.save(user);
	            return ResponseEntity.ok("User age updated successfully.");
	        } else {
	            return ResponseEntity.status(404).body("User not found.");
	        }
	    }
	 
	 @GetMapping("/jpa/users/{id}/posts")  
	 public List<Posts> retrieveAllUsers(@PathVariable int id)
	 { Optional<User> userOptional = ur.findById(id); 
		 if(!userOptional.isPresent()) { throw new UserNotFoundException("id-" + id); 
		 }
		 return userOptional.get().getPost(); 
	 }
	 
	 @PostMapping("/jpa/users/{id}/posts")
		public ResponseEntity<Object> create_user (@PathVariable int id, @RequestBody Posts p) {
		 	Optional<User> userOptional = ur.findById(id); 
		 	 if(!userOptional.isPresent()) { throw new UserNotFoundException("id-" + id); 
			 }
		 	User usr=userOptional.get();
		 	p.setUser(usr);
		 	pr.save(p);
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
			 buildAndExpand(p.getId()).toUri();
			 
			 return ResponseEntity.created(location).build();
			 	
		}
	@GetMapping("/jpa/internationalisation")
	public String gm(@RequestHeader(name="Accept-Language",required=false) Locale loc) {
		return ms.getMessage("good.morning.message",null,loc);
	}
}
