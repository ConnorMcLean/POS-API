package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.*;

public interface OrderDAO {
	
	public long save(Order m);
	
	public Order get(long id);
	
	public List<Order> list();
	
	void update(long id, Order order);
	
	void delete(long id);
}
