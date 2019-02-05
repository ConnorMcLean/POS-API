//Implementation of Service interface for order model
//Written by Connor McLean
package com.munroeng.SAI.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.OrderDAO;
import com.munroeng.SAI.models.Order;

@Service
@Transactional(readOnly=true)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDAO;

	//Save a new order
	@Transactional
	@Override
	public long save(long cust_id, Order order) {
		return orderDAO.save(cust_id, order);
	}

	//Get order based on order and customer id
	@Override
	public Order get(long cust_id, long order_id) {
		Order o = orderDAO.get(cust_id, order_id);
		this.InitializeOrder(o);
		return o;
	}

	//List all orders in system
	@Override
	public List<Order> list() {
		List<Order> o = orderDAO.list();
		this.InitializeOrderList(o);
		return o;
	}

	//Update order object
	@Override
	@Transactional
	public Order update(long cust_id, long order_id, Order order) {
		return orderDAO.update(cust_id, order_id, order);
		
	}
	//Delete order object
	@Override
	@Transactional
	public void delete(long cust_id, long order_id) {
		orderDAO.delete(cust_id, order_id);
		
	}

	//List all orders for a specific customer
	@Override
	public List<Order> listCustOrders(long cust_id) {
		List<Order> o = orderDAO.listCustOrders(cust_id);
		this.InitializeOrderList(o);
		return o;
	}
	
	//Helper function to initialize all orders in a list
	public void InitializeOrderList(List<Order> o) {
		int i = 0;
		while(i < o.size()) {
			this.InitializeOrder(o.get(i));
			i++;
		}
	}
	
	//Helper function to initialize all nested objects in an order
	public void InitializeOrder(Order o) {
		Hibernate.initialize(o.getMachineOrders());
		int i = 0, j=0, k=0;
		while(i < o.getMachineOrders().size()) {
			Hibernate.initialize(o.getMachineOrders().get(i).getMachine());
			while(j < o.getMachineOrders().get(i).getAccessories().size()) {
				Hibernate.initialize(o.getMachineOrders().get(i).getAccessories().get(j));
				Hibernate.initialize(o.getMachineOrders().get(i).getAccessories().get(j).getAccessory());
				j++;
			}
			while(k < o.getMachineOrders().get(i).getCutters().size()) {
				Hibernate.initialize(o.getMachineOrders().get(i).getCutters().get(k));
				Hibernate.initialize(o.getMachineOrders().get(i).getCutters().get(k).getCutter());
				k++;
			}
			j = 0;
			k = 0;
			i++;
		}
	}

}
