//package com.munroeng.SAI.DAO;
//
//import java.util.List;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.munroeng.SAI.models.MachineOrder_Accessory;
//
//@Repository
//public class MachineOrder_AccessoryDAOImpl implements MachineOrder_AccessoryDAO {
//
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	public long save(MachineOrder_Accessory m) {
//		sessionFactory.getCurrentSession().save(m);
//		return m.getMachineOrderId();
//		
//	}
//
//	@Override
//	public List<MachineOrder_Accessory> list() {
//	      Session session = sessionFactory.getCurrentSession();
//	      CriteriaBuilder cb = session.getCriteriaBuilder();
//	      CriteriaQuery<MachineOrder_Accessory> cq = cb.createQuery(MachineOrder_Accessory.class);
//	      Root<MachineOrder_Accessory> root = cq.from(MachineOrder_Accessory.class);
//	      cq.select(root);
//	      Query<MachineOrder_Accessory> query = session.createQuery(cq);
//	      return query.getResultList();
//	}
//
//	@Override
//	public MachineOrder_Accessory get(long id) {
//		return sessionFactory.getCurrentSession().get(MachineOrder_Accessory.class, id);
//	}
//	
//	
//   @Override
//   public void update(long id, MachineOrder_Accessory machine_order_accessory) {
//      Session session = sessionFactory.getCurrentSession();
//      MachineOrder_Accessory machine_order_accessory2 = session.byId(MachineOrder_Accessory.class).load(id);
//      machine_order_accessory2.setAccessory(machine_order_accessory.getAccessory());
//      machine_order_accessory2.setMachineOrderId(machine_order_accessory.getMachineOrderId());
//      session.flush();
//   }
//
//   @Override
//   public void delete(long id) {
//      Session session = sessionFactory.getCurrentSession();
//      MachineOrder_Accessory machine_order_accessory = session.byId(MachineOrder_Accessory.class).load(id);
//      session.delete(machine_order_accessory);
//   }
//
//}
