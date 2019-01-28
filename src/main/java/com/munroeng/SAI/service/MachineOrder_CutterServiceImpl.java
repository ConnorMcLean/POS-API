package com.munroeng.SAI.service;

import com.munroeng.SAI.models.MachineOrder_Cutter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.MachineOrder_CutterDAO;


@Service
@Transactional(readOnly=true)
public class MachineOrder_CutterServiceImpl implements MachineOrder_CutterService {
	
	@Autowired
	private MachineOrder_CutterDAO machine_order_cutterDAO;

	@Transactional
	@Override
	public long save(MachineOrder_Cutter machine_order_cutter) {
		return machine_order_cutterDAO.save(machine_order_cutter);
	}

	@Override
	public MachineOrder_Cutter get(long id) {
		return machine_order_cutterDAO.get(id);
	}

	@Override
	public List<MachineOrder_Cutter> list() {
		return machine_order_cutterDAO.list();
	}

	@Override
	public void update(long id, MachineOrder_Cutter machine_order_cutter) {
		machine_order_cutterDAO.update(id, machine_order_cutter);
		
	}

	@Override
	public void delete(long id) {
		machine_order_cutterDAO.delete(id);
		
	}

}
