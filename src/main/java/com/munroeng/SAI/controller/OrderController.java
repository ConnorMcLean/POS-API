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

import com.munroeng.SAI.models.Order;
import com.munroeng.SAI.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//Add a new order
	@PostMapping("/order") 
	public ResponseEntity<?> save(@RequestBody Order order){
		long id = orderService.save(order);
		return ResponseEntity.ok().body("New order has been saved with ID" + id );
	}
	
	//Get an order by id
	@GetMapping("/order/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		Order order = orderService.get(id);
		return ResponseEntity.ok().body(order);
	}
	
	//Update a order by Id
   @PutMapping("/order/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Order order) {
      orderService.update(id, order);
      return ResponseEntity.ok().body("order has been updated successfully.");
   }
	
	//Get all order
	@GetMapping("/orders")
	   public ResponseEntity<List<Order>> list() {
	      List<Order> orders = orderService.list();
	      return ResponseEntity.ok().body(orders);
	   }
	
	//Delete a order by id
	@DeleteMapping("/order/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      orderService.delete(id);
	      return ResponseEntity.ok().body("order has been deleted successfully.");
	   }
	
	
}
