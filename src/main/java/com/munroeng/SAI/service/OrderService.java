package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Order;

public interface OrderService {

	public long save(Order order);
	
	public Order get(long id);
	
	public List<Order> list();
	
	void update(long id, Order order);
	
	void delete(long id);
	
}
