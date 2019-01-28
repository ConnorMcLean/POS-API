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

import com.munroeng.SAI.models.MachineOrder_Cutter;
import com.munroeng.SAI.service.MachineOrder_CutterService;


@RestController
public class MachineOrder_CutterController {
	
	@Autowired
	private MachineOrder_CutterService machine_order_cutterService;
	
	//Add a new machine_order_cutter
	@PostMapping("/order/{id}/machine_order/{id}/machine_order_cutter") 
	public ResponseEntity<?> save(@RequestBody MachineOrder_Cutter machine_order_cutter){
		long id = machine_order_cutterService.save(machine_order_cutter);
		return ResponseEntity.ok().body("New machine_order_cutter has been saved with ID" + id );
	}
	
	//Get a machine_order_cutter by id
	@GetMapping("/order/{id}/machine_order/{id}/machine_order_cutter/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		MachineOrder_Cutter machine_order_cutter = machine_order_cutterService.get(id);
		return ResponseEntity.ok().body(machine_order_cutter);
	}
	
	//Update a machine_order_cutter by Id
   @PutMapping("/order/{id}/machine_order/{id}/machine_order_cutter/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody MachineOrder_Cutter machine_order_cutter) {
      machine_order_cutterService.update(id, machine_order_cutter);
      return ResponseEntity.ok().body("machine_order_cutter has been updated successfully.");
   }
	
	//Get all machine_order_cutter
	@GetMapping("/order/{id}/machine_order/{id}/machines")
	   public ResponseEntity<List<MachineOrder_Cutter>> list() {
	      List<MachineOrder_Cutter> machines = machine_order_cutterService.list();
	      return ResponseEntity.ok().body(machines);
	   }
	
	//Delete a machine_order_cutter by id
	@DeleteMapping("/order/{id}/machine_order/{id}/machine_order_cutter/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      machine_order_cutterService.delete(id);
	      return ResponseEntity.ok().body("machine_order_cutter has been deleted successfully.");
	   }
	
	
}
