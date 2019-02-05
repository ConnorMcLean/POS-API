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

import com.munroeng.SAI.models.MachineOrder_Cutter;
//import com.munroeng.SAI.DAO.MachineOrder_CutterDAO;

@Repository
public class MachineOrder_CutterDAOImpl implements MachineOrder_CutterDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(MachineOrder_Cutter m) {
		sessionFactory.getCurrentSession().save(m);
		return m.getMachineOrderId();
		
	}

	@Override
	public List<MachineOrder_Cutter> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<MachineOrder_Cutter> cq = cb.createQuery(MachineOrder_Cutter.class);
	      Root<MachineOrder_Cutter> root = cq.from(MachineOrder_Cutter.class);
	      cq.select(root);
	      Query<MachineOrder_Cutter> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public MachineOrder_Cutter get(long id) {
		return sessionFactory.getCurrentSession().get(MachineOrder_Cutter.class, id);
	}
	
	
   @Override
   public void update(long id, MachineOrder_Cutter machine_order_cutter) {
      Session session = sessionFactory.getCurrentSession();
      MachineOrder_Cutter machine_order_cutter2 = session.byId(MachineOrder_Cutter.class).load(id);
      machine_order_cutter2.setCutter(machine_order_cutter.getCutter());
//      machine_order_cutter2.setMachineOrder(machine_order_cutter.getMachineOrder());
      machine_order_cutter2.setCutterId(machine_order_cutter.getCutterId());
      machine_order_cutter2.setMachineOrderId(machine_order_cutter.getMachineOrderId());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      MachineOrder_Cutter machine_order_cutter = session.byId(MachineOrder_Cutter.class).load(id);
      session.delete(machine_order_cutter);
   }

}
