//package com.munroeng.SAI.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.munroeng.SAI.models.MachineOrder_Accessory;
//import com.munroeng.SAI.service.MachineOrder_AccessoryService;
//
//
//@RestController
//public class MachineOrder_AccessoryController {
//	
//	@Autowired
//	private MachineOrder_AccessoryService machine_order_accessoryService;
//	
//	//Add a new machine_order_accessory
//	@PostMapping("/order/{order_id}/machine_order/{machine_id}/machine_order_accessory") 
//	public ResponseEntity<?> save(@RequestBody MachineOrder_Accessory machine_order_accessory){
//		long id = machine_order_accessoryService.save(machine_order_accessory);
//		return ResponseEntity.ok().body("New machine_order_accessory has been saved with ID" + id );
//	}
//	
//	//Get a machine_order_accessory by id
//	@GetMapping("/order/{order_id}/machine_order/{machine_id}/machine_order_accessory/{id}")
//	public ResponseEntity<?> get(@PathVariable("id") long id){
//		MachineOrder_Accessory machine_order_accessory = machine_order_accessoryService.get(id);
//		return ResponseEntity.ok().body(machine_order_accessory);
//	}
//	
//	//Update a machine_order_accessory by Id
//   @PutMapping("/order/{id}/machine_order/{id}/machine_order_accessory/{id}")
//   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody MachineOrder_Accessory machine_order_accessory) {
//      machine_order_accessoryService.update(id, machine_order_accessory);
//      return ResponseEntity.ok().body("machine_order_accessory has been updated successfully.");
//   }
//	
//	//Get all machine_order_accessory
//	@GetMapping("/order/{order_id}/machine_order/{machine_order_id}/machine_order_accessories")
//	   public ResponseEntity<List<MachineOrder_Accessory>> list() {
//	      List<MachineOrder_Accessory> machine_order_accessorys = machine_order_accessoryService.list();
//	      return ResponseEntity.ok().body(machine_order_accessorys);
//	   }
//	
//	//Delete a machine_order_accessory by id
//	@DeleteMapping("/order/{id}/machine_order/{id}/machine_order_accessory/{id}")
//	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
//	      machine_order_accessoryService.delete(id);
//	      return ResponseEntity.ok().body("machine_order_accessory has been deleted successfully.");
//	   }
//	
//	
//}
