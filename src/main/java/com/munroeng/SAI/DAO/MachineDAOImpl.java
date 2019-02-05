//DAO interface Implementation for Machine model
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

import com.munroeng.SAI.models.Machine;

@Repository
public class MachineDAOImpl implements MachineDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//Save machine
	@Override
	public long save(Machine m) {
		sessionFactory.getCurrentSession().save(m);
		return m.getId();
		
	}
	
	//List all machines
	@Override
	public List<Machine> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Machine> cq = cb.createQuery(Machine.class);
	      Root<Machine> root = cq.from(Machine.class);
	      cq.select(root);
	      Query<Machine> query = session.createQuery(cq);
	      return query.getResultList();
	}

	//Get machine by ID
	@Override
	public Machine get(long id) {
		return sessionFactory.getCurrentSession().get(Machine.class, id);
	}
	
	//update machine by ID
   @Override
   public void update(long id, Machine machine) {
      Session session = sessionFactory.getCurrentSession();
      Machine machine2 = session.byId(Machine.class).load(id);
      machine2.setBuild(machine.getBuild());
      machine2.setType(machine.getType());
      machine2.setHammer(machine.getHammer());
      machine2.setCost(machine.getCost());
      session.flush();
   }

   //Delete machine by ID
   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Machine machine = session.byId(Machine.class).load(id);
      session.delete(machine);
   }

}
