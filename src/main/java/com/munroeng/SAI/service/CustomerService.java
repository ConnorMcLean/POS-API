//Service interface for Customer model
//Written by Connor McLean
package com.munroeng.SAI.service;

import java.util.List;

import com.munroeng.SAI.models.Customer;

public interface CustomerService {

	public long save(Customer customer);
	
	public Customer get(long id);
	
	public List<Customer> list();
	
	void update(long id, Customer customer);
	
	void delete(long id);

	public List<Customer> getCustByName(String name);
	
}
