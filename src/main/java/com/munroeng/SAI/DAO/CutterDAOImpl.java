//DAO interface implementation for cutter model
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

import com.munroeng.SAI.models.Cutter;
import com.munroeng.SAI.models.Cutter;

@Repository
public class CutterDAOImpl implements CutterDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Cutter c) {
		sessionFactory.getCurrentSession().save(c);
		return c.getId();
		
	}

	@Override
	public List<Cutter> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Cutter> cq = cb.createQuery(Cutter.class);
	      Root<Cutter> root = cq.from(Cutter.class);
	      cq.select(root);
	      Query<Cutter> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Cutter get(long id) {
		return sessionFactory.getCurrentSession().get(Cutter.class, id);
	}
	
	
   @Override
   public void update(long id, Cutter cutter) {
      Session session = sessionFactory.getCurrentSession();
      Cutter cutter2 = session.byId(Cutter.class).load(id);
      cutter2.setDesc(cutter.getDesc());
      cutter2.setSizeImp(cutter.getSizeImp());
      cutter2.setSizeMet(cutter.getSizeMet());
      cutter2.setType(cutter.getType());
      cutter2.setCost(cutter.getCost());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Cutter cutter = session.byId(Cutter.class).load(id);
      session.delete(cutter);
   }

}
