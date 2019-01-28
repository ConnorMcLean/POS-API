package com.munroeng.SAI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.CutterDAO;
import com.munroeng.SAI.models.Cutter;

@Service
@Transactional(readOnly=true)
public class CutterServiceImpl implements CutterService {
	
	@Autowired
	private CutterDAO cutterDAO;

	@Transactional
	@Override
	public long save(Cutter cutter) {
		return cutterDAO.save(cutter);
	}

	@Override
	public Cutter get(long id) {
		return cutterDAO.get(id);
	}

	@Override
	public List<Cutter> list() {
		return cutterDAO.list();
	}

	@Override
	@Transactional
	public void update(long id, Cutter cutter) {
		cutterDAO.update(id, cutter);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		cutterDAO.delete(id);
		
	}

}
