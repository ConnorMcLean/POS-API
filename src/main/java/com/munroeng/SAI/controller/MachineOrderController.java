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

import com.munroeng.SAI.models.Accessory;
import com.munroeng.SAI.models.Machine;
import com.munroeng.SAI.models.MachineOrder;
import com.munroeng.SAI.service.MachineOrderService;


@RestController
public class MachineOrderController {
	
	@Autowired
	private MachineOrderService machine_orderService;
	
	//Add a new machine_order
	@PostMapping("machine_order") 
	public ResponseEntity<?> save(@RequestBody MachineOrder machine_order){
		long id = machine_orderService.save(machine_order);
		return ResponseEntity.ok().body("New machine_order has been saved with ID" + id );
	}
	
	
	//Add new accessory to machine_order
	@PostMapping("/order/{order_id}/machine_order/{machine_id}/accessory")
	public ResponseEntity<?> saveAccessory(@PathVariable("machine_id") long machine_id, @PathVariable("order_id") long order_id,
	@RequestBody Accessory accessory){
		long id = machine_orderService.saveAccessory(machine_id, order_id, accessory);
		return ResponseEntity.ok().body("New accessory has been saved to machine_order with ID : " +  machine_id);
	}
	
	@DeleteMapping("/order/{order_id}/machine_order/{machine_id}/accessory")
	public ResponseEntity<?> DeleteAccessory(@PathVariable("machine_id") long machine_id, @PathVariable("order_id") long order_id,
	@RequestBody Accessory accessory){
		long id = machine_orderService.RemoveAccessory(machine_id, order_id, accessory);
		return ResponseEntity.ok().body("Accessory has been deleted from machine_order with ID : " +  machine_id);
	}
	
	//Get a machine_order by id
	@GetMapping("/order/{order_id}/machine_order/{machine_id}")
	public ResponseEntity<?> get(@PathVariable("machine_id") long machine_id, @PathVariable("order_id") long order_id){
		MachineOrder machine_order = machine_orderService.get(machine_id, order_id);
		return ResponseEntity.ok().body(machine_order);
	}
	
	//Update a machine_order by Id
   @PutMapping("/order/{order_id}/machine_order/{machine_id}")
   public ResponseEntity<?> update(@PathVariable("machine_id") long id, @RequestBody MachineOrder machine_order) {
      machine_orderService.update(id, machine_order);
      return ResponseEntity.ok().body("machine_order has been updated successfully.");
   }
	
	//Get all machine_order for specific order
	@GetMapping("/order/{order_id}/machine_orders")
	   public ResponseEntity<List<MachineOrder>> list(@PathVariable("order_id") long id) {
	      List<MachineOrder> machines = machine_orderService.list(id);
	      return ResponseEntity.ok().body(machines);
	   }
	
	//Get all machine_order
	@GetMapping("/machine_orders")
	   public ResponseEntity<List<MachineOrder>> listAllMachineOrders() {
	      List<MachineOrder> machines = machine_orderService.listAllMachineOrders();
	      return ResponseEntity.ok().body(machines);
	   }
	
	//Delete a machine_order by id
	@DeleteMapping("/order/{order_id}/machine_order/{machine_id}")
	   public ResponseEntity<?> delete(@PathVariable("machine_id") long id) {
	      machine_orderService.delete(id);
	      return ResponseEntity.ok().body("machine_order has been deleted successfully.");
	   }
	
	
}
