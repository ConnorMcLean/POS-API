//DAO interface for accessory model
//written by Connor McLean
package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.Accessory;

public interface AccessoryDAO {

		public long save(Accessory a);
		
		public Accessory get(long id);
		
		public List<Accessory> list();
		
		void update(long id, Accessory accessory);
		
		void delete(long id);
}
