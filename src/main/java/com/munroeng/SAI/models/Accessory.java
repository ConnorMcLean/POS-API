//Accessory model used in Hibernate ORM for RESTful API service
//written by Connor McLean
package com.munroeng.SAI.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="Accessory")
@Table(name="Accessories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Accessory {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="accessory_id")
	private long id;

	private String name;
	
	private String description;

	private float cost;
	
	private String machine_type;
	
	public Accessory() {
		
	}
		
	public Accessory(String name, float cost, String descript, String machine) {
		this.name = name;
		this.cost = cost;
		this.description = descript;
		this.machine_type = machine;
	}
	
	public long getId() {
		return id;
	}
	
	public String getAccessory() {
		return name;
	}
	
	public void setAccessory(String name) {
		this.name = name;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public String getDesc() {
		return description;
	}
	
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public String getMachineType() {
		return machine_type;
	}
	
	public void setMachineType(String machine) {
		this.machine_type = machine;
	}
	
	
}
