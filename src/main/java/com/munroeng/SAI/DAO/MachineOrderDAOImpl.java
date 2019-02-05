//DAO interface implementation for MachineOrder model
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
import com.munroeng.SAI.models.Cutter;
import com.munroeng.SAI.models.Machine;
import com.munroeng.SAI.models.MachineOrder;
import com.munroeng.SAI.models.MachineOrder_Accessory;

@Repository
public class MachineOrderDAOImpl implements MachineOrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//save machien_order
	@Override
	public long save(MachineOrder m) {
		
		//Find existing machine entity to bind for relation
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Machine> cq = cb.createQuery(Machine.class);
	    Root<Machine> root = cq.from(Machine.class);
	    cq.select(root);
	    cq.where(
	    		cb.equal(
	    				root.get("id"), m.getMachine().getId())
	    		);
	    Query<Machine> query = session.createQuery(cq);
	    Machine Mo = query.getSingleResult();
	    m.setMachine(Mo);
	    
		session.save(m);
		return m.getMachineOrder_id();
	}
	
	//List all MachineOrders for a specific order
	@Override
	public List<MachineOrder> listAllMachineOrders() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<MachineOrder> cq = cb.createQuery(MachineOrder.class);
	      Root<MachineOrder> root = cq.from(MachineOrder.class);
	      cq.select(root);
	      Query<MachineOrder> query = session.createQuery(cq);
	      return query.getResultList();
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
	}
	
	//Update machine order by ID
   @Override
   public void update(long id, MachineOrder machine_order) {
      Session session = sessionFactory.getCurrentSession();
      MachineOrder machine_order2 = session.byId(MachineOrder.class).load(id);
      machine_order2.setSerial(machine_order.getSerial());
      machine_order2.setAccessories(machine_order.getAccessories());
      machine_order2.setCutters(machine_order.getCutters());
      machine_order2.setOrderId(machine_order.getOrderId());
      machine_order2.setMachineOrder_id(machine_order.getMachineOrder_id());
      machine_order2.setMachine(machine_order.getMachine());
      session.flush();
   }

   //Delete MachineOrder by ID
   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      MachineOrder machine_order = session.byId(MachineOrder.class).load(id);
      session.delete(machine_order);
   }

   //Add accessory to existing machine_order
   
	@Override
	public long saveAccessory(long machine_id, long order_id, Accessory accessory) {
		
//		//Find current Machine Order
		MachineOrder Mo = this.get(machine_id, order_id);
	    
	    //Find referenced accessory
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Accessory> acc = cb.createQuery(Accessory.class);
	    Root<Accessory> accRoot = acc.from(Accessory.class);
	    acc.select(accRoot);
	    acc.where(
	    		cb.and(cb.equal(accRoot.get("id"), accessory.getId())));
	    Query<Accessory> AccQ = session.createQuery(acc);
	    Accessory a = AccQ.getSingleResult();
	    
	    //Add to object
	    Mo.addAccessory(a);
	    session.saveOrUpdate(Mo);
		return Mo.getMachineOrder_id();
	}

	
	//Remove accessory from machine_order

	@Override
	public long RemoveAccessory(long machine_id, long order_id, Accessory accessory) {
		
//		//Find current Machine Order		
		MachineOrder Mo = this.get(machine_id, order_id);
	    
	    //Find referenced accessory
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Accessory> acc = cb.createQuery(Accessory.class);
	    Root<Accessory> accRoot = acc.from(Accessory.class);
	    acc.select(accRoot);
	    acc.where(
	    		cb.and(cb.equal(accRoot.get("id"), accessory.getId())));
	    Query<Accessory> AccQ = session.createQuery(acc);
	    Accessory a = AccQ.getSingleResult();
   
	    //Add to object
	    Mo.removeAccessory(a);
	    session.update(Mo);
		return Mo.getMachineOrder_id();
	}

	//Add cutter to machine_order
	@Override
	public long saveCutter(long machine_id, long order_id, Cutter cutter) {
		
//		//Find current Machine Order
		MachineOrder Mo = this.get(machine_id, order_id);
	    
	    //Find referenced cutter
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Cutter> cut = cb.createQuery(Cutter.class);
	    Root<Cutter> cutRoot = cut.from(Cutter.class);
	    cut.select(cutRoot);
	    cut.where(
	    		cb.and(cb.equal(cutRoot.get("cutter_id"), cutter.getId())));
	    Query<Cutter> CutQ = session.createQuery(cut);
	    Cutter c = CutQ.getSingleResult();
	    
	    //Add to object
	    Mo.addCutter(c);
	    session.saveOrUpdate(Mo);
		return Mo.getMachineOrder_id();
	}

	//remove cutter from machine_order
	@Override
	public long RemoveCutter(long machine_id, long order_id, Cutter cutter) {
		
		//Find current Machine Order
		MachineOrder Mo = this.get(machine_id, order_id);
	    
	    //Find referenced cutter
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
	    CriteriaQuery<Cutter> cut = cb.createQuery(Cutter.class);
	    Root<Cutter> cutRoot = cut.from(Cutter.class);
	    cut.select(cutRoot);
	    cut.where(
	    		cb.and(cb.equal(cutRoot.get("cutter_id"), cutter.getId())));
	    Query<Cutter> CutQ = session.createQuery(cut);
	    Cutter c = CutQ.getSingleResult();
   
	    //Add to object
	    Mo.removeCutter(c);
	    session.update(Mo);
		return Mo.getMachineOrder_id();
	}
	

}
