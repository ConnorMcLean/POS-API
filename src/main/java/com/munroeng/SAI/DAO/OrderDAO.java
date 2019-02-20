//DAO interface for order model
//Written by Connor McLean
package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.*;

public interface OrderDAO {
	
	public long save(long cust_id, Order m);
	
	public Order get(long cust_id, long order_id);
	
	public List<Order> list();
	
	public Order update(long cust_id, long order_id, Order order);
	
	void delete(long cust_id, long order_id);

	public List<Order> listCustOrders(long cust_id);
	
	public Order CalcTotalCost(long order_id);
}