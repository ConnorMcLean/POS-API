//MachineOrder_Accessory class model for db table
//used for single sided many to many relationship between orders and machine reference table
//written by Connor McLean

package com.munroeng.SAI.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="MachineOrder_Accessory")
@Table(name="Machine_Order_Accessories")
public class MachineOrder_Accessory {

	@EmbeddedId
	private MachineOrder_AccessoryId id;
	
	@JsonBackReference
	@ManyToOne
	@MapsId("machine_order_id")
	private MachineOrder machine_order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("accessory_id")
	private Accessory accessory;
	
	public MachineOrder_Accessory() {}
	
	public MachineOrder_Accessory(MachineOrder M, Accessory A) {
		this.machine_order = M;
		this.accessory = A;
		this.id = new MachineOrder_AccessoryId(M.getMachineOrder_id(), A.getId());
	}
	
	public void setMachineOrderId(long id) {
		this.id.setMachineOrderId(id);
	}
	
	public void setAccessoryId(long id) {
		this.id.setAccessoryId(id);
	}
	
//	@JsonIgnore
	public long getMachineOrderId() {
		return id.getMachineOrderId();
	}
	
//	@JsonIgnore
	public long getAccessoryId() {
		return id.getAccessoryId();
	}
	
	
//	public MachineOrder getMO() {
//		return machine_order;
//	}
	
	public Accessory getAccessory() {
		return accessory;
	}
	
	public void setMachineOrder(MachineOrder M) {
		this.machine_order = M;
	}
	
	public void setAccessory(Accessory a) {
		this.accessory = a;
	}
	
	@JsonIgnore
	public MachineOrder_AccessoryId getId() {
		return id;
	}
	
	
}
