//Implementation of DAO Interface for customer DAO
//Written Connor McLean
package com.munroeng.SAI.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.munroeng.SAI.models.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Customer c) {
		sessionFactory.getCurrentSession().save(c);
		return c.getId();
		
	}

	@Override
	public List<Customer> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
	      Root<Customer> root = cq.from(Customer.class);
	      cq.select(root);
	      Query<Customer> query = session.createQuery(cq);
	      cq.orderBy(cb.desc(root.get("name")));
	      return query.getResultList();
	}

	@Override
	public Customer get(long id) {
		
		
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}
	
	
   @Override
   public void update(long id, Customer customer) {
      Session session = sessionFactory.getCurrentSession();
      Customer customer2 = session.byId(Customer.class).load(id);
      customer2.setBusiness(customer.getBusiness());
      customer2.setContactNo_1(customer.getContactNo_1());
      customer2.setContactNo_2(customer.getContactNo_2());
      customer2.setCreator(customer.getCreator());
      customer2.setEmail(customer.getEmail());
      customer2.setName(customer.getName());
      customer2.setOrders(customer.getOrders());
      customer2.setCreatedDate(customer.getCreatedDate());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Customer customer = session.byId(Customer.class).load(id);
      session.delete(customer);
   }
   

   //TODO: VERIFY SEARCH
   
	@Override
	public List<Customer> getCustByName(String name) {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
	      Root<Customer> root = cq.from(Customer.class);
	      cq.select(root);
	      cq.where(cb.like(root.get("name"), name));
//	      cq.where(cb.equal(root.get("name"), name));
//	      cq.orderBy(cb.desc(root.get("name")));
	      Query<Customer> query = session.createQuery(cq);
	      return query.getResultList();
	}

}
