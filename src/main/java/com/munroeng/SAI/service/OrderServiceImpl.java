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
		Hibernate.initialize(o.getMachines());
		int i = 0;
		while(i < o.getMachines().size()) {
			Hibernate.initialize(o.getMachines().get(i).getAccessories());
			Hibernate.initialize(o.getMachines().get(i).getCutters());
			i++;
		}
		return o;
	}

	@Override
	public List<Order> list() {
		List<Order> o = orderDAO.list();
		int i =0, j=0;
		while(i < o.size()) {
			Hibernate.initialize(o.get(i).getMachines());
			while(i < o.get(i).getMachines().size()) {
				Hibernate.initialize(o.get(i).getMachines().get(j).getAccessories());
				Hibernate.initialize(o.get(i).getMachines().get(j).getCutters());
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
