//DAO interface written for cutter model
//written by Connor McLean
package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.Cutter;

public interface CutterDAO {

	public long save(Cutter c);
	
	public Cutter get(long id);
	
	public List<Cutter> list();
	
	void update(long id, Cutter cutter);
	
	void delete(long id);
	
}
