package servicesDB;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;


import beans.Annonce;
import beans.Blood_type;
import util.HibernateUtil;

public class AnnonceServices {
	
	public void addAnnonce(Annonce annonce, long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Annonce annonce2 = annonce;
		Blood_type blood_type = new Blood_type();
		blood_type =(Blood_type) session.get(Blood_type.class, id);
		
		Set<Blood_type> blood_types = new HashSet<Blood_type>();
		blood_types.add(blood_type);
		annonce2.setBloods(blood_types);
		session.save(annonce2);
		session.getTransaction().commit();
		//session.close();
	}
	
	public Annonce getAnnonceById(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Annonce annonce = (Annonce) session.get(Annonce.class, id);
		//session.close();
		
		return annonce;
	}

	
	public void deleteAnnonce(Annonce annonce) {
		

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		session.delete(annonce);
		session.getTransaction().commit();
		if(session.isOpen()) {
			session.close();
		}
	}
	
	public List<Annonce> getAllAnnonces(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Annonce> annonces =  session.createQuery("from Annonce").list();
		
		return annonces;
	}

	public void updateAnnonce(Annonce annonce) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(annonce);
		session.getTransaction().commit();
		session.close();
	}

	public Iterator<beans.User> getAllUsers(Long id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Annonce annonce = (Annonce) session.get(Annonce.class, id);

		Iterator<beans.User> iterator = annonce.getUsers().iterator();
		
		return iterator;

	}
	

	public Iterator<Blood_type> getAllBloodtype(Long id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Annonce annonce = (Annonce) session.get(Annonce.class, id);

		Iterator<Blood_type> iterator = annonce.getBloods().iterator();
		
		return iterator;

	}
	
}
