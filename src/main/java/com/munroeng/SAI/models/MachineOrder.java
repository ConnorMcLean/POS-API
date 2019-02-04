//MachineOeder class model for db table
//used for single sided many to many relationship between orders and machine reference table
//written by Connor McLean

package com.munroeng.SAI.models;


import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

@Entity(name="MachineOrder")
@Table(name="Machine_Orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MachineOrder {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="machine_order_id")
	private long machine_order_id;

	@Column(name="serial_no")
	private String serialNo;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date created_on;
	
	@ManyToOne(fetch=FetchType.LAZY,
				cascade = CascadeType.ALL)
	@MapsId("machine_id")
//	@JoinColumn(name="machine_id")
	Machine machine;
	
//	@ManyToOne(targetEntity=Order.class)
	@JoinColumn(name="order_id")
	private long order_id;
	
////	@ManyToOne(targetEntity=Machine.class)
//	@JoinColumn(name="machine_id")
//	private long machine_id;

	@JsonManagedReference
	@OneToMany(
			mappedBy="machine_order",
			cascade = CascadeType.ALL,
			orphanRemoval=true)
	List<MachineOrder_Accessory> accessories = new ArrayList<>();
	
	@OneToMany(
			mappedBy="machine_order",
			cascade = CascadeType.ALL,
			orphanRemoval=true)
	List<MachineOrder_Cutter> cutters = new ArrayList<>();
	
	public MachineOrder() {}
	
//	public MachineOrder(long order, long machine_id, String serialNo) {
//		this.order_id = order;
////		this.machine_id = machine_id;
//		this.serialNo = serialNo;
//		this.setMachine(machine);
//	}
	
//	private Machine machine;
	
	public String getCreated() {
		return created_on.toString();
	}
	
//	public long getMachineId() {	
//		return machine_id;
//	}
	
	public long getMachineOrder_id() {
		return machine_order_id;
	}
	
	public void setMachineOrder_id(long id) {
		 this.machine_order_id = id;
	}
	
	public long getOrderId() {
		return order_id;
	}
	
	public String getSerial() {
		return serialNo;
	}
	
	public void setSerial(String Serial) {
		serialNo = Serial;
	}
	
//	public void setMachineId(long id) {
//		this.machine_id = id;
//	}
	
	public void setOrderId(long id) {
		this.order_id = id;
	}

	
	public List<MachineOrder_Accessory> getAccessories(){
		return accessories;
	}
	
	public void setAccessories(List<MachineOrder_Accessory> a){
		this.accessories.addAll(a);
	}
	
	public List<MachineOrder_Cutter> getCutters(){
		return cutters;
	}
	
	public void setCutters(List<MachineOrder_Cutter> c) {
		this.cutters.addAll(c);
	}
	
	
	//CUTTER FUNCTIONS
	
	public void addCutter(Cutter cutter) {
		MachineOrder_Cutter MacOrd_Cut = new MachineOrder_Cutter(this, cutter);
		cutters.add(MacOrd_Cut);
	}
	
	public void removeCutter(Cutter c) {
		for (Iterator<MachineOrder_Cutter> iterator = cutters.iterator();
		         iterator.hasNext(); ) {
	        MachineOrder_Cutter MacOrd_Cut = iterator.next();
	 
	        if (MacOrd_Cut.getMachineOrder().equals(this) &&
	        		MacOrd_Cut.getCutter().equals(c)) {
	            iterator.remove();
	            MacOrd_Cut.setMachineOrder(null);
	            MacOrd_Cut.setCutter(null);
	        }
	    }
	}
	
	//ACCESSORY FUNCTIONS
	
	public void addAccessory(Accessory accessory) {
		MachineOrder_Accessory MacOrd_Acc = new MachineOrder_Accessory(this, accessory);
		accessories.add(MacOrd_Acc);
	}
	
	public void removeAccessory(Accessory a) {
		for (Iterator<MachineOrder_Accessory> iterator = accessories.iterator();
		         iterator.hasNext(); ) {
	        MachineOrder_Accessory MacOrd_Acc = iterator.next();
	 
	        if (MacOrd_Acc.getMachineOrderId() == this.machine_order_id &&
	        		MacOrd_Acc.getAccessory().equals(a)) {
	            iterator.remove();
	            MacOrd_Acc.setMachineOrder(null);
	            MacOrd_Acc.setAccessory(null);
	        }
	    }
	}
	
	//TODO:FIX COST CALCULATION
	
//	//Tally up costs from various tables
	public float getMachineOrderCost() {
		float cost = 0;
		int i = 0, j = 0;
		
//		cost += machine.getCost();
		
		
		while(accessories.size() < i) {
			cost += accessories.get(i).getAccessory().getCost();
		}
		
		while(cutters.size() < j) {
			cost += cutters.get(j).getCutter().getCost();
		}
		
		return cost;
	}
	
	

	public Machine getMachine() {
		return machine;
	}

//	public void setMachineId(long id) {
//		this.machine.setId(id);
//	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
	
		
}
