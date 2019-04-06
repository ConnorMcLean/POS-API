package com.munroeng.SAI.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity(name="Order")
@Table(name="Orders")
public class Order {

	//DB usage only
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private long order_id;
	
	//Customer Id
	@JoinColumn(name="customer_id", nullable = false)
	private long customer_id;
	
	//Customer order number which came with order
	//eg; LB1156
	@Column(name="order_ref", nullable=false)
	private String order_ref;
	
	//Total order cost
	@Column(name="total_cost")
	@ColumnDefault("0")
	private float total_cost;
	
	//shipping address
	@Column(name="shipping_address")
	private String shipping_address;
	
	//who took the order
	@Column(name="created_by", nullable=false)
	private String created_by;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date created_on;
	
	@OneToMany(
			mappedBy="order_id",
			cascade = CascadeType.ALL,
			orphanRemoval=true)
	private List<MachineOrder> machine_orders = new ArrayList<>();
	
	@Column(name="completed")
	private String completed;

	//empty constructor
	public Order() {}
	
//	public Order(long custId, String orderRef, String Addr, String creator) {
//		this.customer_id = custId;
//		this.order_ref = orderRef;
//		this.shipping_address = Addr;
//		this.created_by = creator;
//	}
	
	public String getCreated() {
		return created_on.toString();
	}
	
	public long getCustId() {
		return customer_id;
	}
	
	public void setCustId(long cust_id) {
		this.customer_id = cust_id;
	}
	
	public long getId() {
		return order_id;
	}
	
	public String getCreator() {
		return created_by;
	}
	
	public void setCreator(String creator) {
		this.created_by = creator;
	}
	
//	TEST PURPOSES
	public void setCreator() {
		this.created_by = "";
	}
	
	public void setCost() {
		this.total_cost = 0;
	}
	
	
//	
	
	public float getCost() {
		return total_cost;
	}
	
	public String getShipAddr() {
		return shipping_address;
	}
	
	public void setShipAddr(String Addr) {
		this.shipping_address = Addr;
	}
	
	public void setCost(float cost) {
		this.total_cost = cost;
	}
	
	public String getOrderRef() {
		return order_ref;
	}
	
	public void setOrderDate(Date date) {
		this.created_on = date;
	}
	
	public Date getOrderDate() {
		return this.created_on;
	}
	
	public void setOrderRef(String CustOrderId) {
		this.order_ref = CustOrderId;
	}
	
	public List<MachineOrder> getMachineOrders(){
		return machine_orders;
	}
	
//	public void addMachine(long machine_id, String serialNo, Machine machine) {
//		MachineOrder MacOrd = new MachineOrder(order_id, machine_id, serialNo);
//		machine_orders.add(MacOrd);
//	}
	
//	public void removeMachine(long machine_id) {
//		for (Iterator<MachineOrder> iterator = machine_orders.iterator();
//		         iterator.hasNext(); ) {
//	        MachineOrder MacOrd = iterator.next();
//	 
//	        if ((MacOrd.getOrderId() == this.order_id) &&
//	        		(MacOrd.getMachineId() == machine_id)) {
//	            iterator.remove();
////	            MacOrd.setMachineId(null);
////	            MacOrd.setOrderId(null);
//	        }
//	    }
//		
//	}
	
	public void setMachineOrders(List<MachineOrder> machine_orders) {
		this.machine_orders = machine_orders;
	}
	
	
	//TEST
	public void CalcTotalCost() {
		this.total_cost = 0;
		int i = 0;
		while(machine_orders.size() < i) {
			this.total_cost += machine_orders.get(i).getMachineOrderCost();
		}
		
	}
	
	public void setCompleted(String gen) {
		this.completed = gen;
	}
	
	public void activateCompleted() {
		this.completed = "True";
	}
	
	public void deactivateCompleted() {
		this.completed = "Fase";
	}
	
	public String getCompleted() {
		return this.completed;
	}
	
}
