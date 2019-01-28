package com.munroeng.SAI.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Embeddable
public class MachineOrder_CutterId implements Serializable {

	@Column(name="machine_order_id")
	private long machine_order_id;
	
	@Column(name="cutter_id")
	private long cutter_id;
	
	public MachineOrder_CutterId() {}
	
	public MachineOrder_CutterId(long machine_order_id, long cutter_id) {
		this.machine_order_id = machine_order_id;
		this.cutter_id = cutter_id;
	}
	
	public long getMachineOrderId() {
		return machine_order_id;
	}
	
	public long getCutterId() {
		return cutter_id;
	}
	
	public void setSerial(long machine_order_id) {
		this.machine_order_id = machine_order_id;
	}
	
	public void setCutterId(long id) {
		this.cutter_id = id;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        MachineOrder_CutterId that = (MachineOrder_CutterId) o;
        return Objects.equals(cutter_id, that.cutter_id) &&
               Objects.equals(machine_order_id, that.machine_order_id);
    }

	
}
