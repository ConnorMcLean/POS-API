package com.munroeng.SAI.service;


import com.munroeng.SAI.models.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.UserDAO;


@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Transactional
	@Override
	public long save(User user) {
		return userDAO.save(user);
	}

	@Override
	public User get(long id) {
		return userDAO.get(id);
	}

	@Override
	public List<User> list() {
		return userDAO.list();
	}

	@Override
	public void update(long id, User user) {
		userDAO.update(id, user);
		
	}

	@Override
	public void delete(long id) {
		userDAO.delete(id);
		
	}

}
