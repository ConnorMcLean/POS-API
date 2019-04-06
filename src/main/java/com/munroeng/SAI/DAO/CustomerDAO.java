//DAO interface for customer model
//Written Connor McLean
package com.munroeng.SAI.DAO;

import java.util.List;

import com.munroeng.SAI.models.Customer;

public interface CustomerDAO {

	public long save(Customer c);
	
	public Customer get(long id);
	
	public List<Customer> list();
	
	void update(long id, Customer customer);
	
	void delete(long id);

	public List<Customer> getCustByName(String name);
}
