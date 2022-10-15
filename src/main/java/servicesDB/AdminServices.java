package servicesDB;

import org.hibernate.Session;

import beans.Admin;
import util.HibernateUtil;

public class AdminServices {

	public void addAdmin(Admin admin) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(admin);
		
		session.close();
	}
	
	public Admin getAdminById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Admin admin = (Admin) session.get(Admin.class, id);
		
		session.close();
		return admin;
	}
	
	public void deleteAdmin(Admin admin) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(admin);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void updateAdmin(Admin admin) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(admin);
		session.getTransaction().commit();
		session.close();
		
	}

}


