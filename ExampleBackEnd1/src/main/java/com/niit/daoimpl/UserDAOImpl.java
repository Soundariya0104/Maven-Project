package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public List<User> list() {
		String hql="from user";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return ((UserDAO) query).list();
		
	}

	@Transactional
	public User get(String id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Transactional
	public User validate(String id, String password) {
		String hql="from User where id='"+id+"' and password='"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (User)((org.hibernate.Query) query).uniqueResult();
	}
	
	
	
	@Transactional

	public boolean save(User user) {
		try{
		sessionFactory.getCurrentSession().save(user);
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}
