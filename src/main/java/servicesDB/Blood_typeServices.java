package servicesDB;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import beans.Annonce;
import beans.Blood_type;
import beans.User;
import util.HibernateUtil;

public class Blood_typeServices {

		public void addBlood_type(Blood_type bloodtype) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(bloodtype);
			session.getTransaction().commit();
			session.close();
		}
		
		public Blood_type getBlood_typebyId(Long id) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Blood_type type = (Blood_type) session.get(Blood_type.class, id);
			
			//session.close();
			return type;
		}
		public void deleteBlood_type(Blood_type type) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.delete(type);
			
			session.close();
			
		}
		
		public void updateBlood_type(Blood_type type) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(type);
			session.getTransaction().commit();
			//session.close();
		}
		
		
		 public List <Blood_type>  getAllBlood_type() {
			 Session session=HibernateUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
			 
			List <Blood_type> types =session.createQuery("from Blood_type").list();
			 
			//session.close();
			 
			return types; 
		 }
		
		public Iterator<User> getAllUserofBlood_type(Long id){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Blood_type type=(Blood_type) session.get(Blood_type.class, id);
			Iterator<User> users = null ;
			if(type != null) {
				 users = type.getUsers().iterator();
			}
			return users ;
		}
		
		public Iterator<Annonce> getAllAnnoceofBlood_type(Long id){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Blood_type type=(Blood_type) session.get(Blood_type.class, id);
			Iterator<Annonce> annonces = null;
			if(type!= null) {
				annonces=type.getAnnonces().iterator();
			}
			return annonces ;
		}
}
