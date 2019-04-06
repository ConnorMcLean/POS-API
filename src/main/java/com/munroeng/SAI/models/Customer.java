package com.munroeng.SAI.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name="Customer")
@Table(name="Customers")
public class Customer {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(name="business_name")
	private String business;
	
	@Column(nullable=false)
	private String email;
	
	@Column(name="contact_no_1")
	private String contactNo_1;
	
	@Column(name="contact_no_2")
	private String contactNo_2;
	
//	@Column(nullable=false)
	private String created_by;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date created_on;
	
	@OneToMany(mappedBy = "customer_id", fetch=FetchType.LAZY)
	private List<Order> orders = new ArrayList<Order>();
	
	public Customer() {
		
	}
	
	public Customer(String name, String business, String email, String contactNo_1, String contactNo_2, String createdBy) {
		
		this.name = name;
		this.business = business;
		this.email = email;
		this.contactNo_1 = contactNo_1;
		this.contactNo_2 = contactNo_2;
		this.created_by = createdBy;
		
	}
	
	public void setOrders(List<Order> orders) {
		this.orders.addAll(orders);
	}
	
	public long getId() {
		return id;
	}
	
	public List<Order> getOrders(){
		return orders;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBusiness() {
		return business;
	}
	
	public void setBusiness(String business) {
		this.business = business;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContactNo_1() {
		return contactNo_1;
	}
	
	public void setContactNo_1(String contactNo_1) {
		this.contactNo_1 = contactNo_1;
	}
	
	public String getContactNo_2() {
		return contactNo_2;
	}
	
	public void setContactNo_2(String contactNo_2) {
		this.contactNo_2 = contactNo_2;
	}
	
	public String getCreator() {
		return created_by;
	}
	
	public void setCreator(String created_by) {
		this.created_by = created_by;
	}
	
	public Date getCreatedDate() {
		return this.created_on;
	}
	
	public void setCreatedDate(Date date) {
		this.created_on = date;
	}
	
	
}
