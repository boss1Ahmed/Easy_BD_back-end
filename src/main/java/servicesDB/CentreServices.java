package servicesDB;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import beans.Centre;
import beans.User;
import util.HibernateUtil;

public class CentreServices {
	

	public void addCentre(Centre centre) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(centre);
		session.getTransaction().commit();
		session.close();
	}
	
	public Centre getCentrebyId(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Centre centre = (Centre) session.get(Centre.class, id);
		
		session.close();
		return centre;
	}
	
	public void deleteCentre(Centre centre) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(centre);
		session.getTransaction().commit();
		//session.close();
	}
	
	public void updateCentre(Centre centre) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(centre);
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	public Iterator<Centre> getAllCentres(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Iterator<Centre> centres = session.createQuery("from Centre").iterate();
		//session.close();
		
		return centres;
	}
	
	public Iterator<User> getAllUsers(Long id){
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Centre centre = (Centre) session.get(Centre.class, id);
		
		
		Iterator<User> iterator = centre.getUsers().iterator();
		//session.close();
		return  iterator; 
		
	}
	
	
	

}
