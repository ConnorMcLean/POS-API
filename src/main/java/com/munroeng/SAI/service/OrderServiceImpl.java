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

	@Transactional
	@Override
	public long save(Order order) {
		return orderDAO.save(order);
	}

	@Override
	public Order get(long id) {
		Order o = orderDAO.get(id);
		Hibernate.initialize(o.getMachineOrders());
		//Iterate through objects lazily initializing
		
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
		return o;
	}


	@Override
	public List<Order> list() {
		List<Order> o = orderDAO.list();
		int i =0, j=0, k =0, l=0;
		while(i < o.size()) {
			while(j < o.get(i).getMachineOrders().size()) {
				Hibernate.initialize(o.get(i).getMachineOrders().get(j).getMachine());
				while(l < o.get(i).getMachineOrders().get(j).getAccessories().size()) {
					Hibernate.initialize(o.get(i).getMachineOrders().get(j).getAccessories().get(l));
					Hibernate.initialize(o.get(i).getMachineOrders().get(j).getAccessories().get(l).getAccessory());
					l++;
				}
				while(k < o.get(i).getMachineOrders().get(j).getCutters().size()) {
					Hibernate.initialize(o.get(i).getMachineOrders().get(j).getCutters().get(k));
					Hibernate.initialize(o.get(i).getMachineOrders().get(j).getCutters().get(k).getCutter());
					k++;
				}
				l=0;
				k=0;
				j++;
			}
			j=0;
			i++;
		}
		return o;
	}

	@Override
	@Transactional
	public void update(long id, Order order) {
		orderDAO.update(id, order);
		
	}

	@Override
	@Transactional
	public void delete(long id) {
		orderDAO.delete(id);
		
	}

}
