//Controller for order model interaction within RESTful API
//written by Connor McLean
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
	@PostMapping("customer/{customer_id}/order") 
	public ResponseEntity<?> save(@PathVariable("cusotmer_id") long cust_id, @RequestBody Order order){
		long id = orderService.save(cust_id, order);
		return ResponseEntity.ok().body("New order has been saved with ID" + id );
	}
	
	//Get an order by id
	@GetMapping("customer/{customer_id}/order/{order_id}")
	public ResponseEntity<?> get(@PathVariable("customer_id") long cust_id, @PathVariable("order_id") long order_id){
		Order order = orderService.get(cust_id, order_id);
		if(order == null) {
			return ResponseEntity.badRequest().body("Order not found for specified customer");
		}
		return ResponseEntity.ok().body(order);
	}
	
	//Update an order by Id
   @PutMapping("customer/{customer_id}/order/{order_id}")
   public ResponseEntity<?> update(@PathVariable("customer_id") long cust_id, @PathVariable("id") long order_id, @RequestBody Order order) {
      Order o = orderService.update(cust_id, order_id, order);
      if(o == null) {
    	  return ResponseEntity.badRequest().body("Order not found for specified customer");
      }
      return ResponseEntity.ok().body("order has been updated successfully.");
   }
	
	//Get all orders
	@GetMapping("/orders")
	   public ResponseEntity<List<Order>> list() {
	      List<Order> orders = orderService.list();
	      return ResponseEntity.ok().body(orders);
	   }
	
	//Get all orders for a specific customer
	@GetMapping("customer/{customer_id}/orders")
	public ResponseEntity<?> get(@PathVariable("customer_id") long cust_id){
		List<Order> orders = orderService.listCustOrders(cust_id);
		if(orders == null) {
			return ResponseEntity.badRequest().body("Order not found for specified customer");
		}
		return ResponseEntity.ok().body(orders);
	}
	
	//TEST
	//Calculate and set total order cost
	@GetMapping("/order/{order_id}/calc_order_cost")
	public ResponseEntity<?> calcOrderCost(@PathVariable("order_id") long order_id){
		Order o = orderService.CalcOrderCost(order_id);
		if(o == null) {
			return ResponseEntity.badRequest().body("Order not found");
		}
		return ResponseEntity.ok().body(o);
	}
	
	//Delete a order by id
	@DeleteMapping("customer/{customer_id}/order/{order_id}")
	   public ResponseEntity<?> delete(@PathVariable("customer_id") long cust_id, @PathVariable("order_id") long order_id) {
	      orderService.delete(cust_id, order_id);
	      return ResponseEntity.ok().body("order has been deleted successfully.");
	   }
	
	
}
