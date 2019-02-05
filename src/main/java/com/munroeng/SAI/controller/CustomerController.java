//Controller for customer model for RESTful API
//written by Connor McLean

package com.munroeng.SAI.controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.munroeng.SAI.models.Customer;
import com.munroeng.SAI.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//Add a new customer
	@PostMapping("/customer") 
	public ResponseEntity<?> save(@RequestBody Customer customer){
		long id = customerService.save(customer);
		return ResponseEntity.ok().body("New customer has been saved with ID" + id );
	}
	
	//Get a customer by id
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		Customer customer = customerService.get(id);
		return ResponseEntity.ok().body(customer);
	}
	
	//Update a customer by Id
   @PutMapping("/customer/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Customer customer) {
      customerService.update(id, customer);
      return ResponseEntity.ok().body("customer has been updated successfully.");
   }
	
	//Get all customer
	@GetMapping("/customers")
	   public ResponseEntity<List<Customer>> list() {
	      List<Customer> customers = customerService.list();
	      return ResponseEntity.ok().body(customers);
	   }
	
	//Delete a customer by id
	@DeleteMapping("/customer/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      customerService.delete(id);
	      return ResponseEntity.ok().body("customer has been deleted successfully.");
	   }
	
	
}
