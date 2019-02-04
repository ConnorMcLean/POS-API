package com.munroeng.SAI.models;

import javax.persistence.*;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Machine")
@Table(name="Machines")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Machine {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="machine_id")
	private long id;
	
	private String type;
	
	private String build;
	
	private long hammer;
	
	private float cost;
	
	public Machine() {
		
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getBuild() {
		return build;
	}
	
	public void setBuild(String build) {
		this.build = build;
	}
//	
	public String getType() {
		return type;
	}
//	
	public void setType(String type) {
		this.type = type;
	}
//	
	public long getHammer() {
		return hammer;
	}
	
	public void setHammer(long hammer) {
		this.hammer = hammer;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
//	public String getMachine() {
//		return type + " " + build + " " + hammer;
//	}
//	
	
}
