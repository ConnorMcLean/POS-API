package com.munroeng.SAI.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.DAO.CustomerDAO;
import com.munroeng.SAI.models.Customer;
import com.munroeng.SAI.models.Order;

@Service
@Transactional(readOnly=true)
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	@Override
	public long save(Customer customer) {
		return customerDAO.save(customer);
	}

	
	@Override
//	@Transactional(readON)
	public Customer get(long id) {
		Customer customer = customerDAO.get(id);
		Hibernate.initialize(customer.getOrders());
		List<Order> o = customer.getOrders();
		int i = 0, j=0;
		while(i < o.size()) {
			Hibernate.initialize(o.get(i).getMachines());
			while(j < o.get(i).getMachines().size()) {
				Hibernate.initialize(o.get(i).getMachines().get(j).getAccessories());
				Hibernate.initialize(o.get(i).getMachines().get(j).getCutters());
				j++;
			}
			j=0;
			i++;
		}
		return customer;
	}

	@Override
//	@Transactional
	public List<Customer> list() {
		List<Customer> customers = customerDAO.list();	
		int i = 0, j = 0, k = 0;
		while(i < customers.size()) {
			Hibernate.initialize(customers.get(i).getOrders());
			List<Order> o = customers.get(i).getOrders();
			while(j < o.size()) {
				Hibernate.initialize(o.get(j).getMachines());
				while(k < o.get(j).getMachines().size()) {
					Hibernate.initialize(o.get(j).getMachines().get(k).getAccessories());
					Hibernate.initialize(o.get(j).getMachines().get(k).getCutters());
					k++;
				}
				k=0;
				j++;
			}
			j=0;
			i++;
		}
		return customers;
	}

	@Override
	@Transactional
	public void update(long id, Customer customer) {
		customerDAO.update(id, customer);
	
	}

	@Override
	@Transactional
	public void delete(long id) {
		customerDAO.delete(id);
		
	}

}
