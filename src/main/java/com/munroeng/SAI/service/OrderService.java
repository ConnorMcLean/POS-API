//Service interface for Order model
//Written by Connor McLean
package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Order;

public interface OrderService {

	public long save(long cust_id, Order order);
	
	public Order get(long cust_id, long order_id);
	
	public List<Order> list();
	
	public Order update(long cust_id, long order_id, Order order);
	
	void delete(long cust_id, long order_id);

	public List<Order> listCustOrders(long cust_id);
	
	public Order CalcOrderCost(long order_id);
	
}
