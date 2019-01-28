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

import com.munroeng.SAI.models.User;
import com.munroeng.SAI.models.User;


@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(User u) {
		sessionFactory.getCurrentSession().save(u);
		return u.getUserId();
		
	}

	@Override
	public List<User> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<User> cq = cb.createQuery(User.class);
	      Root<User> root = cq.from(User.class);
	      cq.select(root);
	      Query<User> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public User get(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	
   @Override
   public void update(long id, User user) {
      Session session = sessionFactory.getCurrentSession();
      User user2 = session.byId(User.class).load(id);
      user2.setName(user.getName());
      user2.setPassword(user.getPassword());
      user2.setRole(user.getRole());
      user2.setUsername(user.getUsername());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      User user = session.byId(User.class).load(id);
      session.delete(user);
   }

}

