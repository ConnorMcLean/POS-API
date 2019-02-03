package com.munroeng.SAI.service;

import com.munroeng.SAI.models.MachineOrder_Accessory;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.MachineOrder_AccessoryDAO;


@Service
@Transactional(readOnly=true)
public class MachineOrder_AccessoryServiceImpl implements MachineOrder_AccessoryService {
	
	@Autowired
	private MachineOrder_AccessoryDAO machineDAO;

	
	@Override
	@Transactional
	public long save(MachineOrder_Accessory machine) {
		return machineDAO.save(machine);
	}

	@Override
	public MachineOrder_Accessory get(long id) {
		return machineDAO.get(id);
	}

	@Override
	@Transactional
	public List<MachineOrder_Accessory> list() {
		List<MachineOrder_Accessory> machine_accessory_list = machineDAO.list();
		int i = 0, j = 0;
		while(i < machine_accessory_list.size()){
			Hibernate.initialize(machine_accessory_list.get(i).getAccessory());
//			Hibernate.initialize(machine_accessory_list.get(i).getMO());
//			
//			while(j < machine_accessory_list.get(i).getMO().getAccessories().size()) {
//				Hibernate.initialize(machine_accessory_list.get(i).getMO().getAccessories().get(j));
//				j++;
//			}
//			j=0;
			
			Hibernate.initialize(machine_accessory_list.get(i).getId());
			Hibernate.initialize(machine_accessory_list.get(i).getAccessoryId());
			Hibernate.initialize(machine_accessory_list.get(i).getMachineOrderId());

			i++;
			}
		return machine_accessory_list;
	}

	@Override
	public void update(long id, MachineOrder_Accessory machine) {
		machineDAO.update(id, machine);
		
	}

	@Override
	public void delete(long id) {
		machineDAO.delete(id);
		
	}

}
