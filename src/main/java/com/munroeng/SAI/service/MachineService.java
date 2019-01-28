package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Machine;

public interface MachineService {

	public long save(Machine machine);
	
	public Machine get(long id);
	
	public List<Machine> list();
	
	void update(long id, Machine machine);
	
	void delete(long id);
	
}
