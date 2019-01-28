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
	
	@Override
	public long save(Machine m) {
		sessionFactory.getCurrentSession().save(m);
		return m.getId();
		
	}

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

	@Override
	public Machine get(long id) {
		return sessionFactory.getCurrentSession().get(Machine.class, id);
	}
	
	
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

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Machine machine = session.byId(Machine.class).load(id);
      session.delete(machine);
   }

}
