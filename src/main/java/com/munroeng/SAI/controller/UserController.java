package com.munroeng.SAI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.munroeng.SAI.models.User;
import com.munroeng.SAI.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Add a new user
	@PostMapping("/user") 
	public ResponseEntity<?> save(@RequestBody User user){
		long id = userService.save(user);
		return ResponseEntity.ok().body("New user has been saved with ID" + id );
	}
	
	//Get a user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		User user = userService.get(id);
		return ResponseEntity.ok().body(user);
	}
	
	//Update a user by Id
   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
      userService.update(id, user);
      return ResponseEntity.ok().body("user has been updated successfully.");
   }
	
	//Get all user
	@GetMapping("/users")
	   public ResponseEntity<List<User>> list() {
	      List<User> users = userService.list();
	      return ResponseEntity.ok().body(users);
	   }
	
	//Delete a user by id
	@DeleteMapping("/user/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      userService.delete(id);
	      return ResponseEntity.ok().body("user has been deleted successfully.");
	   }
	
	
}