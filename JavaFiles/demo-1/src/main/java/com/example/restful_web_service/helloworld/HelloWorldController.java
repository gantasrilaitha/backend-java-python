package com.example.restful_web_service.helloworld;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloWorldController {
	
	@GetMapping(value = "/helloworldbean") //returns a bean
    public  HelloWorldBean hwb() {
        return new HelloWorldBean("HelloWorldBean!");
    }
	
	@GetMapping(value = "/helloworld")
    public String helloworld() {
        System.out.println("Helloworld");
        return "HelloWorld!";
    }
	
	@GetMapping(value="/hw{name}")
	 public  HelloWorldBean hwb_path_var(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello! %s",name));
    }
}
