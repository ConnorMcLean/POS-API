//Implementation of interface for Customer model
//Written by Connor McLean
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

	//Save a customer
	@Transactional
	@Override
	public long save(Customer customer) {
		return customerDAO.save(customer);
	}

	//Get a customer by id
	@Override
	public Customer get(long id) {
		Customer customer = customerDAO.get(id);
		this.InitializeCustomer(customer);
		return customer;
	}

	//get all customers
	@Override
	public List<Customer> list() {
		List<Customer> customers = customerDAO.list();	
		this.InitializeCustomerList(customers);
		return customers;
	}

	@Override
	@Transactional
	public void update(long id, Customer customer) {
		customerDAO.update(id, customer);
	
	}

	//delete customer by id
	@Override
	@Transactional
	public void delete(long id) {
		customerDAO.delete(id);
		
	}
	
	//Helper function to lazy initialize all nested objects in customer list
	public void InitializeCustomerList(List<Customer> customers) {
		int i = 0;
		while(i < customers.size()) {
			this.InitializeCustomer(customers.get(i));
			i++;
		}
	}
	
	//Helper function to lazy initialize all nested objects
	public void InitializeCustomer(Customer customer) {
		Hibernate.initialize(customer.getOrders());
		List<Order> o = customer.getOrders();
		int j = 0, k=0, l=0, m=0;
		while(j < o.size()) {
			Hibernate.initialize(o.get(j).getMachineOrders());
			while(k < o.get(j).getMachineOrders().size()) {
				Hibernate.initialize(o.get(j).getMachineOrders().get(k).getMachine());
				Hibernate.initialize(o.get(j).getMachineOrders().get(k).getAccessories());
				Hibernate.initialize(o.get(j).getMachineOrders().get(k).getCutters());
				while(l < o.get(j).getMachineOrders().get(k).getAccessories().size()) {
					Hibernate.initialize(o.get(j).getMachineOrders().get(k).getAccessories().get(l).getAccessory());
					l++;
				}
				while(m < o.get(j).getMachineOrders().get(k).getCutters().size()) {
					Hibernate.initialize(o.get(j).getMachineOrders().get(k).getCutters().get(m).getCutter());
					m++;
				}
				l=0;
				m=0;
				k++;
			}
			k=0;
			j++;
		}
	}

}
