//DAO implementation for order model
//Written by Connor McLean
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

import com.munroeng.SAI.models.Order;
import com.munroeng.SAI.models.Order;


@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//Save customer with relevant customer_id
	@Override
	public long save(long cust_id, Order o) {
		o.setCustId(cust_id);
		sessionFactory.getCurrentSession().save(o);
		return o.getId();
		
	}

	//List all orders in system
	@Override
	public List<Order> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Order> cq = cb.createQuery(Order.class);
	      Root<Order> root = cq.from(Order.class);
	      cq.select(root);
	      Query<Order> query = session.createQuery(cq);
	      return query.getResultList();
	}

	//get specific order return null if invalid customer_id
	@Override
	public Order get(long cust_id, long order_id) {
		Order o = sessionFactory.getCurrentSession().get(Order.class, order_id);
		if(o.getCustId() != cust_id) {
			return null;
		}
		return o;
	}
	
	
	//Update specific order, return null if invalid customer_id
   @Override
   public Order update(long cust_id, long order_id, Order order) {
      Session session = sessionFactory.getCurrentSession();
      Order order2 = session.byId(Order.class).load(order_id);
      if(order.getCustId() != cust_id) {
    	  return null;
      }
      
      //TODO: query and update total cost?
      //Lots of overhead :/
//      order2.setCost(order.getCost());
      order2.setCreator(order.getCreator());
      order2.setOrderRef(order.getOrderRef());
      order2.setShipAddr(order.getShipAddr());
      order2.setCustId(order.getCustId());
      session.flush();
      return order2;
   }

   //delete specific order
   @Override
   public void delete(long cust_id, long order_id) {
      Session session = sessionFactory.getCurrentSession();
      Order order = session.byId(Order.class).load(order_id);
      if(order.getCustId() == cust_id) {
    	  session.delete(order);
      }
   }

   //Get all orders for a specific customer
	@Override
	public List<Order> listCustOrders(long cust_id) {
	    Session session = sessionFactory.getCurrentSession();
	    CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Order> cq = cb.createQuery(Order.class);
	    Root<Order> root = cq.from(Order.class);
	    cq.select(root);
	    cq.where(cb.equal(root.get("customer_id"), cust_id));
	    Query<Order> query = session.createQuery(cq);
	    return query.getResultList();
	}

	
	//TEST
	//Calculate and set total order cost
	@Override
	public Order CalcTotalCost(long order_id) {
		Session session = sessionFactory.getCurrentSession();
		Order o = session.get(Order.class, order_id);
		o.CalcTotalCost();
		session.saveOrUpdate(o);
		return o;
	}

}
