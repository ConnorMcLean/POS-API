package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Cutter;

public interface CutterService {

	public long save(Cutter cutter);
	
	public Cutter get(long id);
	
	public List<Cutter> list();
	
	void update(long id, Cutter cutter);
	
	void delete(long id);
}
