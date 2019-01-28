//ID embeddable for MachineOrder_accessory class, used to obtain
//and reference ids of various connecting tables in db
//Used in Munro SAI application
//written by Connor McLean

package com.munroeng.SAI.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Embeddable
public class MachineOrder_AccessoryId implements Serializable {

	@Column(name="machine_order_id")
	private long machine_order_id;
	
	@Column(name="accessory_id")
	private long accessory_id;
	
	public MachineOrder_AccessoryId() {}
	
	public MachineOrder_AccessoryId(long machine_order_id, long accessory_id) {
		this.machine_order_id = machine_order_id;
		this.accessory_id = accessory_id;
	}
	
	public void setMachineOrderId(long id) {
		this.machine_order_id = id;
	}
	
	public void setAccessoryId(long id) {
		this.accessory_id = id;
	}
	
	public long getMachineOrderId() {
		return machine_order_id;
	}
	
	public long getAccessoryId() {
		return accessory_id;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        MachineOrder_AccessoryId that = (MachineOrder_AccessoryId) o;
        return Objects.equals(accessory_id, that.accessory_id) &&
               Objects.equals(machine_order_id, that.machine_order_id);
    }
	
}
