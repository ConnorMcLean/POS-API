//MachineOrder_Cutterccessory class model for db table
//used for single sided many to many relationship between orders and machine reference table
//written by Connor McLean

package com.munroeng.SAI.models;

import javax.persistence.*;

@Entity(name="MachineOrder_Cutter")
@Table(name="Machine_Order_Cutters")
public class MachineOrder_Cutter {

	@EmbeddedId
	private MachineOrder_CutterId id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("machine_order_id")
	private MachineOrder machine_order;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("cutter_id")
	private Cutter cutter;
	
	public MachineOrder_Cutter() {}
	
	public MachineOrder_Cutter(MachineOrder machine_order, Cutter cutter) {
		this.machine_order = machine_order;
		this.cutter = cutter;
		this.id = new MachineOrder_CutterId(machine_order.getMachineOrder_id(), cutter.getId());
	}
	
	public long getMachineOrderId() {
		return id.getMachineOrderId();
	}
	
	
	
	public long getCutterId() {
		return id.getCutterId();
	}
	
	public MachineOrder getMachineOrder() {
		return machine_order;
	}
	
	public Cutter getCutter() {
		return cutter;
	}
	
	public void setMachineOrderId(long machine_order_id){
		this.id.setSerial(machine_order_id);
	}
	
	public void setMachineOrder(MachineOrder machine_order) {
		this.machine_order = machine_order;
	}
	public void setCutterId(long cutter_id) {
		this.id.setCutterId(cutter_id);
	}
	
	
	public void setCutter(Cutter cutter) {
		this.cutter = cutter;
	}
	
	
	
}
