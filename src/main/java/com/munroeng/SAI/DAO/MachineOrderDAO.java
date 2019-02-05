//DAO interface for MachineOrder model
//written by Connor McLean
package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.Accessory;
import com.munroeng.SAI.models.Cutter;
import com.munroeng.SAI.models.Machine;
import com.munroeng.SAI.models.MachineOrder;

public interface MachineOrderDAO {
	
	public long save(MachineOrder m);
	
	public MachineOrder get(long machine_id, long order_id);
	
	public List<MachineOrder> list(long id);
	
	void update(long id, MachineOrder machine_order);
	
	void delete(long id);

	public long saveAccessory(long machine_id, long order_id, Accessory accessory);

	public long RemoveAccessory(long machine_id, long order_id, Accessory accessory);
	
	public long saveCutter(long machine_id, long order_id, Cutter cutter);
	
	public long RemoveCutter(long machine_id, long order_id, Cutter cutter);
	
	List<MachineOrder> listAllMachineOrders();
}
