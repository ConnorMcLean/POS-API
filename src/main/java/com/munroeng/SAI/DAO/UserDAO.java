package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.User;

public interface UserDAO {

	public long save(User u);
	
	public User get(long id);
	
	public List<User> list();
	
	public void delete(long id); 
	
	public void update(long id, User user);
	
}
