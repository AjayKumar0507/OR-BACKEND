package com.infosys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.entities.User;
import com.infosys.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
    	return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/getUserByRoleId/{id}")
    public User getUserInfoByRoleId(@PathVariable String id) {
    	return userService.getUserInfoByRoleId(id);
    }
    
    
    @GetMapping("/getUserByEmail/{id}")
    public User getUserByUserEmail(@PathVariable String id) {
    	/*
    	User user = userService.getUserInfoById(id);
    	System.out.println(user.toString()+user.getRole().getRoleId());
    	*/
    	return userService.getUserInfoByUserEmail(id);
    	
    }
}
