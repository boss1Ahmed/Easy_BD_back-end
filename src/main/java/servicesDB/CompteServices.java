package servicesDB;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import beans.Centre;
import beans.Compte;
import beans.Role;
import beans.User;
import util.HibernateUtil;

public class CompteServices {

	
	public void addCompte(Compte compte) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(compte);
		session.getTransaction().commit();
		//session.close();
	}
	
	public Compte getComptebyId(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Compte compte = (Compte) session.get(Compte.class, id);
		
		session.close();
		return compte;
	}
	
	public void deleteCompte(Compte compte) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(compte);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateCompte(Compte compte) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(compte);
		session.getTransaction().commit();
		//session.close();
	}
	
	public Role getRoleofAccount(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Compte compte = (Compte) session.get(Compte.class, id);
		Role role=compte.getRole();
		session.close();
		return role;
	}
	
	
	public User getUserofCompte(Long id) {
		User user = new User();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//session.beginTransaction();
		session.getTransaction().begin();
		Compte compte = (Compte) session.get(Compte.class, id);
		user = compte.getUser();
		
		//session.close();
		return user;
		
	}
	
	public Centre getCentreofCompte(Long id) {
		Centre centre = new Centre();
		Session session = HibernateUtil.getSessionFactory().openSession();
		//session.beginTransaction();
		session.getTransaction().begin();
		Compte compte = (Compte) session.get(Compte.class, id);
		centre = compte.getCentre();
		
		//session.close();
		return centre;
		
	}
	
	public List<Compte> getAllCompte(){
		List<Compte> comptes = new ArrayList<Compte>();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		comptes = (List<Compte>) session.createQuery("from Centre");
		return comptes;
	}
	
	
	
	
}