package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.MachineOrder;

public interface MachineOrderDAO {
	
	public long save(MachineOrder m);
	
	public MachineOrder get(long machine_id, long order_id);
	
	public List<MachineOrder> list(long id);
	
	void update(long id, MachineOrder machine_order);
	
	void delete(long id);
}
