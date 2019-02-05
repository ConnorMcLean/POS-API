//Service interface for Accessory model
//written by Connor McLean
package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Accessory;

public interface AccessoryService {

	public long save(Accessory accessory);
	
	public Accessory get(long id);
	
	public List<Accessory> list();
	
	void update(long id, Accessory accessory);
	
	void delete(long id);
}
