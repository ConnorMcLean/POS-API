package com.munroeng.SAI.models;

import javax.persistence.*;

@Entity(name="Cutter")
@Table(name="Cutters")
public class Cutter {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cutter_id;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable=true)
	private double size_imp;
	
	@Column(nullable=true)
	private double size_met;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=false)
	private float cost;
	
	public Cutter() {
		
	}
	
//	public Cutter(String type, double size_imp, double size_met, float cost, String desc) {
//		this.type = type;
//		this.size_imp = size_imp;
//		this.size_met = size_met;
//		this.cost = cost;
//		this.description = desc;
//	}
	
	public long getId() {
		return cutter_id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getSizeImp() {
		return size_imp;
	}
	
	public void setSizeImp(double size_imp) {
		this.size_imp = size_imp;
	}
	
	public double getSizeMet() {
		return size_met;
	}
	
	public void setSizeMet(double size_met) {
		this.size_met = size_met;
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
}
