//Service implementation for MachineOrder model
//written by Connor McLean
package com.munroeng.SAI.service;

import com.munroeng.SAI.models.Accessory;
import com.munroeng.SAI.models.Cutter;
import com.munroeng.SAI.models.Machine;
import com.munroeng.SAI.models.MachineOrder;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.MachineOrderDAO;


@Service
@Transactional(readOnly=true)
public class MachineOrderServiceImpl implements MachineOrderService {
	
	@Autowired
	private MachineOrderDAO machine_orderDAO;

	//save MachineOrder
	@Transactional
	@Override
	public long save(MachineOrder machine_order) {
		return machine_orderDAO.save(machine_order);
	}

	//get MachineOrder by ID
	@Override
	public MachineOrder get(long machine_id, long order_id) {
		MachineOrder mo = machine_orderDAO.get(machine_id, order_id);
		this.InitializeMachineOrder(mo);
		return  mo;
	}
	
	//Get list of all MachineOrders for specific order
	@Override
	public List<MachineOrder> list(long id) {
		List<MachineOrder> mo = machine_orderDAO.list(id);
		this.InitialiseMachineOrderList(mo);
		return mo;
	}

	//Update MachienOrder by ID
	@Override
	@Transactional
	public void update(long id, MachineOrder machine_order) {
		machine_orderDAO.update(id, machine_order);
		
	}
	
	//Get all machineOrders in system
	public List<MachineOrder> listAllMachineOrders(){
		List<MachineOrder> mo = machine_orderDAO.listAllMachineOrders();
		this.InitialiseMachineOrderList(mo);
		return mo;
	}

	//Delete MachineOrder by ID
	@Override
	@Transactional
	public void delete(long id) {
		machine_orderDAO.delete(id);
		
	}

	//Save accessory to machineOrder
	@Override
	@Transactional
	public long saveAccessory(long machine_id, long order_id, Accessory accessory) {
		return machine_orderDAO.saveAccessory(machine_id, order_id, accessory);
	}

	//Remove accessory from machineOrder
	@Override
	@Transactional
	public long RemoveAccessory(long machine_id, long order_id, Accessory accessory) {
		return machine_orderDAO.RemoveAccessory(machine_id, order_id, accessory);
	}
	
	//Save cutter to machineOrder
	@Override
	@Transactional
	public long saveCutter(long machine_id, long order_id, Cutter cutter) {
		return machine_orderDAO.saveCutter(machine_id, order_id, cutter);
	}

	//Remove cutter from MachineOrder
	@Override
	@Transactional
	public long RemoveCutter(long machine_id, long order_id, Cutter cutter) {
		return machine_orderDAO.RemoveCutter(machine_id, order_id, cutter);
	}
	
	//Helper function to lazy initialize all nested objects 
	public void InitialiseMachineOrderList(List<MachineOrder> mo) {
		//Initialize all machine orders
		int i=0;
		while(i < mo.size()) {
			this.InitializeMachineOrder(mo.get(i));
			i++;
		}
	}
	
	//Helper function to lazy initialize all nested objects
	public void InitializeMachineOrder(MachineOrder mo) {
		int i = 0, k = 0;
		Hibernate.initialize(mo.getMachine());
		while(i < mo.getAccessories().size()) {
			Hibernate.initialize(mo.getAccessories().get(i));
			Hibernate.initialize(mo.getAccessories().get(i).getAccessory());
			i++;
		}
		while(k < mo.getCutters().size()) {
			Hibernate.initialize(mo.getCutters().get(k));
			Hibernate.initialize(mo.getCutters().get(k).getCutter());
			k++;
		}
	}



}
