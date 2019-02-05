//DAO interface implementation for accessory model
//written by Connor McLean
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

import com.munroeng.SAI.models.Accessory;

@Repository
public class AccessoryDAOImpl implements AccessoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//save accessory
	@Override
	public long save(Accessory a) { 
		sessionFactory.getCurrentSession().save(a);
		return a.getId();
		
	}
	
	//get a list of all accessories
	@Override
	public List<Accessory> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Accessory> cq = cb.createQuery(Accessory.class);
	      Root<Accessory> root = cq.from(Accessory.class);
	      cq.select(root);
	      Query<Accessory> query = session.createQuery(cq);
	      return query.getResultList();
	}

	//get accessory by id
	@Override
	public Accessory get(long id) {
		return sessionFactory.getCurrentSession().get(Accessory.class, id);
	}
	
	//Update accessory by ID
   @Override
   public void update(long id, Accessory accessory) {
      Session session = sessionFactory.getCurrentSession();
      Accessory accessory2 = session.byId(Accessory.class).load(id);
      accessory2.setAccessory(accessory.getAccessory());
      accessory2.setDesc(accessory.getDesc());
      accessory2.setMachineType(accessory.getMachineType());   
      accessory2.setCost(accessory.getCost());
      session.flush();
   }

   //delete accessory by id
   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Accessory accessory = session.byId(Accessory.class).load(id);
      session.delete(accessory);
   }

}
