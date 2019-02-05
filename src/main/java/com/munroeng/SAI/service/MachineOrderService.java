package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Accessory;
import com.munroeng.SAI.models.Machine;
import com.munroeng.SAI.models.MachineOrder;

public interface MachineOrderService {

	public long save(MachineOrder machine_order);
	
	public MachineOrder get(long machine_id, long order_id);
	
	public List<MachineOrder> list(long id);
	
	public List<MachineOrder> listAllMachineOrders();
	
	public void update(long id, MachineOrder machine_order);
	
	public void delete(long id);

	public long saveAccessory(long machine_id, long order_id, Accessory accessory);

	public long RemoveAccessory(long machine_id, long order_id, Accessory accessory);
	
}
