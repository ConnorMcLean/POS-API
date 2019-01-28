package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.Machine;

public interface MachineDAO {
	
	public long save(Machine m);
	
	public Machine get(long id);
	
	public List<Machine> list();
	
	void delete(long id);

	void update(long id, Machine machine);
}
