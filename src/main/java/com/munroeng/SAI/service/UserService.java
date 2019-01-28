package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.User;

public interface UserService {

	public long save(User user);
	
	public User get(long id);
	
	public List<User> list();
	
	void update(long id, User user);
	
	void delete(long id);
	
}
