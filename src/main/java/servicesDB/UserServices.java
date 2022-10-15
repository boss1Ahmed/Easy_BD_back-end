package servicesDB;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import beans.User;
import util.HibernateUtil;

public class UserServices {
	
	public void addUser (User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		//session.close();
	}

	public User getUserById(Long id) {
		//Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();
		
		User user = (User) session.get(User.class, id);
		//session.close();
		return user;
	}
	
	public List<User> getAllUsers(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
			
		List<User> users = session.createQuery("from User").list();
		
		//session.close();
		return users ;
	}
	
	public void updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//User user1 = (User) session.get(User.class, user.getCIN());
		session.saveOrUpdate(user);
		//Ssession.update(user);
		session.getTransaction().commit();
		//session.close();
		
	}
	
	public void deleteUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		//session.getTransaction().begin();
		if(session.isOpen()) {
			session.close();
		}
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(user);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
		
		
	}
}
