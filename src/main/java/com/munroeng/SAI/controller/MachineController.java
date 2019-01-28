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

import com.munroeng.SAI.models.Machine;
import com.munroeng.SAI.service.MachineService;


@RestController
public class MachineController {
	
	@Autowired
	private MachineService machineService;
	
	//Add a new machine
	@PostMapping("/machine") 
	public ResponseEntity<?> save(@RequestBody Machine machine){
		long id = machineService.save(machine);
		return ResponseEntity.ok().body("New machine has been saved with ID" + id );
	}
	
	//Get a machine by id
	@GetMapping("/machine/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		Machine machine = machineService.get(id);
		return ResponseEntity.ok().body(machine);
	}
	
	//Update a machine by Id
   @PutMapping("/machine/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Machine machine) {
      machineService.update(id, machine);
      return ResponseEntity.ok().body("machine has been updated successfully.");
   }
	
	//Get all machine
	@GetMapping("/machines")
	   public ResponseEntity<List<Machine>> list() {
	      List<Machine> machines = machineService.list();
	      return ResponseEntity.ok().body(machines);
	   }
	
	//Delete a machine by id
	@DeleteMapping("/machine/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      machineService.delete(id);
	      return ResponseEntity.ok().body("machine has been deleted successfully.");
	   }
	
	
}
