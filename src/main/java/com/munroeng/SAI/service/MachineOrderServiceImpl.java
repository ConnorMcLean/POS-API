package com.munroeng.SAI.service;

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

	@Transactional
	@Override
	public long save(MachineOrder machine_order) {
		return machine_orderDAO.save(machine_order);
	}

	@Override
	public MachineOrder get(long machine_id, long order_id) {
		MachineOrder mo = machine_orderDAO.get(machine_id, order_id);
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
		return  mo;
	}

	@Override
	public List<MachineOrder> list(long id) {
		List<MachineOrder> mo = machine_orderDAO.list(id);
		int i = 0, j = 0, k=0;
		while(i < mo.size()) {
			MachineOrder mo_i = mo.get(i);
			Hibernate.initialize(mo_i.getMachine());
			while(j < mo_i.getAccessories().size()) {
				Hibernate.initialize(mo_i.getAccessories().get(j));
				Hibernate.initialize(mo_i.getAccessories().get(j).getAccessory());
				j++;
			}
			while(k < mo_i.getCutters().size()) {
				Hibernate.initialize(mo_i.getCutters().get(k));
				Hibernate.initialize(mo_i.getCutters().get(k).getCutter());
				k++;
			}
			j=0;
			k=0;
			i++;
		}
		return mo;
	}

	@Override
	@Transactional
	public void update(long id, MachineOrder machine_order) {
		machine_orderDAO.update(id, machine_order);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		machine_orderDAO.delete(id);
		
	}

}
