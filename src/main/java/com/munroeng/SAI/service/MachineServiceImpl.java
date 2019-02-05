//Service Interface implementation for Machine Model
//Written by Connor McLean
package com.munroeng.SAI.service;

import com.munroeng.SAI.models.Machine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.MachineDAO;


@Service
@Transactional(readOnly=true)
public class MachineServiceImpl implements MachineService {
	
	@Autowired
	private MachineDAO machineDAO;

	//Save machine
	@Override
	@Transactional
	public long save(Machine machine) {
		return machineDAO.save(machine);
	}
	
	//get machine by ID
	@Override
	public Machine get(long id) {
		return machineDAO.get(id);
	}

	//get list of all machines
	@Override
	public List<Machine> list() {
		return machineDAO.list();
	}
	
	//Update Machine by ID
	@Override
	@Transactional
	public void update(long id, Machine machine) {
		machineDAO.update(id, machine);
		
	}
	
	//Delete Machine by ID
	@Override
	@Transactional
	public void delete(long id) {
		machineDAO.delete(id);
		
	}

}
