package com.example.demo_1;
import org.springframework.stereotype.Controller;
import java.util.*;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DemoController {
	@Autowired
    private PersonJpaServiceImpl personJpaService;
	
	@RequestMapping(value = "/homepg", method = RequestMethod.GET)
    public String home(Model model) {
		model.addAttribute("msg","hi");
        System.out.println("Homepg");
        return "home_view";
    }
	
	public static List<List<String>> students = Arrays.asList(
            Arrays.asList("Bill", "Bob", "Matt", "John", "Mark", "Jack"),
            Arrays.asList("Jessie", "Yvette", "Calvin", "Soila"),
            Arrays.asList("Marianela", "Zenobia", "Miki", "Gilbert")
    );

    @RequestMapping(value = "/getStudents/{classID}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@PathVariable Integer classID) {
        if (classID < 1 || classID > students.size()) {
            return "Invalid classID: " + classID + ". Please provide a valid classID between 1 and " + students.size() + ".";
        }
        return students.get(classID - 1).toString();
    }
    
    

    // Create or Update Person
    @PostMapping
    public ResponseEntity<Person> createOrUpdatePerson(@RequestBody Person person) {
        Person savedPerson = personJpaService.savePerson(person);
        return ResponseEntity.ok(savedPerson);
    }
    /*
    @PutMapping("/update-location/{name}")
    public ResponseEntity<String> updateLocationByName(@PathVariable String name, @RequestBody String location) {
        boolean isUpdated = personJpaService.updateLocationByName(name, location);
        if (isUpdated) {
            return ResponseEntity.ok("Location successfully updated for name: " + name);
        } else {
            return ResponseEntity.status(404).body("Person with name: " + name + " not found");
        }
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
    	Logger logger = LoggerFactory.getLogger(getClass());

        // Fetch the person based on the id
        Person person = personJpaService.findPersonById(id);
        
        if (Optional.of(person).isPresent()) {
            // Log the ID and name to the console
            logger.info("Person found: ID = {}, Name = {}", person.getId(), person.getName());
            
            // Return the person details as a response
            return ResponseEntity.ok(Optional.of(person).get());
        } else {
            // If not found, log a message indicating that no person was found with that ID
            logger.warn("Person with ID = {} not found", id);
            
            // Return a 404 Not Found response
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/allpersons")
    public List<Person> getAllPersons() {
        return personJpaService.findAllPersons();
    }

    // Delete Person by ID
    @DeleteMapping("/deleteid/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer id) {
        personJpaService.deletePersonById(id);
        return ResponseEntity.ok("Successfully deleted");
    }
    */
}
