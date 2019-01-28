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
	
	@Override
	public long save(Order o) {
		sessionFactory.getCurrentSession().save(o);
		return o.getId();
		
	}

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

	@Override
	public Order get(long id) {
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}
	
	
   @Override
   public void update(long id, Order order) {
      Session session = sessionFactory.getCurrentSession();
      Order order2 = session.byId(Order.class).load(id);
      
      //TODO: query and update total cost?
      //Lots of overhead :/
//      order2.setCost(order.getCost());
      order2.setCreator(order.getCreator());
      order2.setOrderRef(order.getOrderRef());
      order2.setShipAddr(order.getShipAddr());
      order2.setCustId(order.getCustId());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Order order = session.byId(Order.class).load(id);
      session.delete(order);
   }

}
