package com.munroeng.SAI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.AccessoryDAO;
import com.munroeng.SAI.models.Accessory;

@Service
@Transactional(readOnly=true)
public class AccessoryServiceImpl implements AccessoryService {
	
	@Autowired
	private AccessoryDAO accessoryDAO;

	@Transactional
	@Override
	public long save(Accessory accessory) {
		return accessoryDAO.save(accessory);
	}

	@Override
	public Accessory get(long id) {
		return accessoryDAO.get(id);
	}

	@Override
	public List<Accessory> list() {
		return accessoryDAO.list();
	}

	@Override
	@Transactional
	public void update(long id, Accessory accessory) {
		accessoryDAO.update(id, accessory);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		accessoryDAO.delete(id);
		
	}

}
