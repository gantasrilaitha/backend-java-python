package com.example.angular_java_practice.fsd.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular_java_practice.fsd.entity.Group;
import com.example.angular_java_practice.fsd.repository.GroupRepository;

@Service
public class GroupService{

    @Autowired
    GroupRepository groupRepository;
    public Collection<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    
    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

   
    public Group updateGroup(Group group) {
        // Fetch the existing Group instance
        Optional<Group> existingGroupOptional = groupRepository.findById(group.getId());
        if (existingGroupOptional.isPresent()) {
            Group existingGroup = existingGroupOptional.get();
    
            // Update only the provided fields
            if (group.getName() != null) {
                existingGroup.setName(group.getName());
            }
            if (group.getAddress() != null) {
                existingGroup.setAddress(group.getAddress());
            }
            if (group.getCity() != null) {
                existingGroup.setCity(group.getCity());
            }
            if (group.getState_Or_Province() != null) {
                existingGroup.setState_Or_Province(group.getState_Or_Province());
            }
            if (group.getCountry() != null) {
                existingGroup.setCountry(group.getCountry());
            }
            if (group.getPostal_Code() != null) {
                existingGroup.setPostal_Code(group.getPostal_Code());
            }
            
    
            // Save the updated Group instance
            return groupRepository.save(existingGroup);
        } else {
            throw new RuntimeException("Group with ID " + group.getId() + " not found.");
        }
    }
    

    
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }

}