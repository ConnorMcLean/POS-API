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
import com.munroeng.SAI.service.AccessoryService;

@RestController
public class AccessoryController {
	
	@Autowired
	private AccessoryService accessoryService;
	
	//Add a new accessory
	@PostMapping("/accessory") 
	public ResponseEntity<?> save(@RequestBody Accessory accessory){
		long id = accessoryService.save(accessory);
		return ResponseEntity.ok().body("New accessory has been saved with ID" + id );
	}
	
	//Get a accessory by id
	@GetMapping("/accessory/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		Accessory accessory = accessoryService.get(id);
		return ResponseEntity.ok().body(accessory);
	}
	
	//Update a accessory by Id
   @PutMapping("/accessory/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Accessory accessory) {
      accessoryService.update(id, accessory);
      return ResponseEntity.ok().body("accessory has been updated successfully.");
   }
	
	//Get all accessory
	@GetMapping("/accessories")
	   public ResponseEntity<List<Accessory>> list() {
	      List<Accessory> accessorys = accessoryService.list();
	      return ResponseEntity.ok().body(accessorys);
	   }
	
	//Delete a accessory by id
	@DeleteMapping("/accessory/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      accessoryService.delete(id);
	      return ResponseEntity.ok().body("accessory has been deleted successfully.");
	   }
	
	
}
