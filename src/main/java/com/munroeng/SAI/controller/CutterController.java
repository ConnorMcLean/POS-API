//Controller for cutter interaction in RESTful API service
//Written by Connor McLean
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

import com.munroeng.SAI.models.Cutter;
import com.munroeng.SAI.service.CutterService;

@RestController
public class CutterController {
	
	@Autowired
	private CutterService cutterService;
	
	//Add a new cutter
	@PostMapping("/cutter") 
	public ResponseEntity<?> save(@RequestBody Cutter cutter){
		long id = cutterService.save(cutter);
		return ResponseEntity.ok().body("New cutter has been saved with ID" + id );
	}
	
	//Get a cutter by id
	@GetMapping("/cutter/{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id){
		Cutter cutter = cutterService.get(id);
		return ResponseEntity.ok().body(cutter);
	}
	
	//Update a cutter by Id
   @PutMapping("/cutter/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Cutter cutter) {
      cutterService.update(id, cutter);
      return ResponseEntity.ok().body("cutter has been updated successfully.");
   }
	
	//Get all cutter
	@GetMapping("/cutters")
	   public ResponseEntity<List<Cutter>> list() {
	      List<Cutter> cutters = cutterService.list();
	      return ResponseEntity.ok().body(cutters);
	   }
	
	//Delete a cutter by id
	@DeleteMapping("/cutter/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      cutterService.delete(id);
	      return ResponseEntity.ok().body("cutter has been deleted successfully.");
	   }
	
	
}