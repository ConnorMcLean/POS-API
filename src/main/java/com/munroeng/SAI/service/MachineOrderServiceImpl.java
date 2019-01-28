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
		Hibernate.initialize(mo.getAccessories());
		Hibernate.initialize(mo.getCutters());
		return  mo;
	}

	@Override
	public List<MachineOrder> list(long id) {
		List<MachineOrder> mo = machine_orderDAO.list(id);
		int i = 0;
		while(i < mo.size()) {
			MachineOrder mo_i = mo.get(i);
			Hibernate.initialize(mo_i.getAccessories());
			Hibernate.initialize(mo_i.getCutters());
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
