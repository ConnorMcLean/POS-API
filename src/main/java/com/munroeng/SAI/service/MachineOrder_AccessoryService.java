package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.MachineOrder_Accessory;

public interface MachineOrder_AccessoryService {

	public long save(MachineOrder_Accessory machine_order_accessory);
	
	public MachineOrder_Accessory get(long id);
	
	public List<MachineOrder_Accessory> list();
	
	void update(long id, MachineOrder_Accessory machine_order_accessory);
	
	void delete(long id);
	
}
