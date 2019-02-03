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
			Hibernate.initialize(o.get(i).getMachineOrders());
			while(j < o.get(i).getMachineOrders().size()) {
				Hibernate.initialize(o.get(i).getMachineOrders().get(j).getMachine());
				Hibernate.initialize(o.get(i).getMachineOrders().get(j).getAccessories());
				Hibernate.initialize(o.get(i).getMachineOrders().get(j).getCutters());
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
		int i = 0, j = 0, k = 0, l=0, m=0;
		while(i < customers.size()) {
			Hibernate.initialize(customers.get(i).getOrders());
			List<Order> o = customers.get(i).getOrders();
			while(j < o.size()) {
				Hibernate.initialize(o.get(j).getMachineOrders());
				while(k < o.get(j).getMachineOrders().size()) {
					Hibernate.initialize(o.get(j).getMachineOrders().get(k).getMachine());
//					
//					while(l < o.get(j).getMachineOrders().get(k).getAccessories().size()) {
//						Hibernate.initialize(o.get(j).getMachineOrders().get(k).getAccessories().get(l));
//						l++;
//					}
//					while(m < o.get(j).getMachineOrders().get(k).getCutters().size()) {
//						Hibernate.initialize(o.get(j).getMachineOrders().get(k).getCutters().get(m));
//						m++;
//					}
//					l=0;
//					m=0;
					
					Hibernate.initialize(o.get(j).getMachineOrders().get(k).getAccessories());
					Hibernate.initialize(o.get(j).getMachineOrders().get(k).getCutters());
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
