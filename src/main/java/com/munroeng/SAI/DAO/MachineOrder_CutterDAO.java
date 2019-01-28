package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.MachineOrder_Cutter;
import com.munroeng.SAI.models.MachineOrder_Cutter;

public interface MachineOrder_CutterDAO {
	
	public long save(MachineOrder_Cutter m);
	
	public MachineOrder_Cutter get(long id);
	
	public List<MachineOrder_Cutter> list();
	
	void delete(long id);

	void update(long id, MachineOrder_Cutter machine_order_cutter);
}
