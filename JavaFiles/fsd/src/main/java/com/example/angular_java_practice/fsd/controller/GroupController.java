package com.example.angular_java_practice.fsd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.angular_java_practice.fsd.entity.Group;

import com.example.angular_java_practice.fsd.services.GroupService;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
class GroupController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;

    @GetMapping("/groups")
    public Collection<Group> groups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<?> get_group(@PathVariable Long id) {
        return groupService.getGroupById(id)
                .map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/group")
    public ResponseEntity<Group> create_group( @RequestBody Group group) throws URISyntaxException {
        log.info("Request to create group: {}", group);
        Group result = groupService.createGroup(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }

    @PutMapping("/group/{id}")
    public ResponseEntity<Group> update_group( @RequestBody Group group) {
        log.info("Request to update group: {}", group);
        Group result = groupService.updateGroup(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> delete_group(@PathVariable Long id) {
        Optional<Group> gp = groupService.getGroupById(id);
        if(gp.isPresent()){
            log.info("Request to delete group: {}", id);
            groupService.deleteGroup(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}