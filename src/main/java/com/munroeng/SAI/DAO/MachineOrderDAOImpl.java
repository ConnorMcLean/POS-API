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

import com.munroeng.SAI.models.MachineOrder;

@Repository
public class MachineOrderDAOImpl implements MachineOrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(MachineOrder m) {
		
		sessionFactory.getCurrentSession().save(m);
		return m.getMachineOrder_id();
		
	}

	//List all MachineOrders for a specific order
	@Override
	public List<MachineOrder> list(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<MachineOrder> cq = cb.createQuery(MachineOrder.class);
	      Root<MachineOrder> root = cq.from(MachineOrder.class);
	      cq.select(root);
	      cq.where(
	    		  cb.equal(root.get("order_id"), id)
	    		  );
	      Query<MachineOrder> query = session.createQuery(cq);
	      return query.getResultList();
	}
	
	
	//Get machine order by id, after verifying that it matches the correct order
	@Override
	public MachineOrder get(long machine_id, long order_id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<MachineOrder> cq = cb.createQuery(MachineOrder.class);
	    Root<MachineOrder> root = cq.from(MachineOrder.class);
	    cq.select(root);
	    cq.where(
	    		cb.and(cb.equal(root.get("order_id"), order_id),
	    				cb.equal(root.get("machine_order_id"), machine_id))
	    		);
	    Query<MachineOrder> query = session.createQuery(cq);
	    return query.getSingleResult();
		
//		return sessionFactory.getCurrentSession().get(MachineOrder.class, machine_id);
	}
	
	
   @Override
   public void update(long id, MachineOrder machine_order) {
      Session session = sessionFactory.getCurrentSession();
      MachineOrder machine_order2 = session.byId(MachineOrder.class).load(id);
      machine_order2.setSerial(machine_order.getSerial());
      machine_order2.setAccessories(machine_order.getAccessories());
      machine_order2.setCutters(machine_order.getCutters());
      machine_order2.setOrderId(machine_order.getOrderId());
      machine_order2.setMachineOrder_id(machine_order.getMachineOrder_id());
//      machine_order2.setMachineId(machine_order2.getMachineId());
      machine_order2.setMachine(machine_order.getMachine());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      MachineOrder machine_order = session.byId(MachineOrder.class).load(id);
      session.delete(machine_order);
   }

}
