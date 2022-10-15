package servicesDB;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class BeansService {

	public List<Object> getObjectByfield(String object,String field,String name, String field2  , String value ) {
		
		if(field2== null) {
			field2= field ;
			value = name;
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from " + object + "  WHERE "+ field + " = '" + name +"'" + " and " + field2 + " =  '" + value + "'" ; 
		List<Object> objects =   session.createQuery(hql).list();
		session.close();
		return objects;
	}
	
	
	public List<Object> getObject(String object,Object...objects){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from " + object +" where ";
		String field1 = objects[0].toString();
		String value1 = objects[1].toString();
		int n = 0;
		String and = " and ";
		while (n<objects.length) {
			if (n == objects.length - 2) {
				and = "";
			}
			hql = hql + objects[n] +  " = '" +objects[n+1] + "'" + and ; 
			//and = " and ";
			n=n+2;
		}
		
		//String hql = "from " + object +" where " +  field1 + " = '" +value1+"'";
		List<Object> objects2 = session.createQuery(hql).list();
		System.out.println(objects[0].toString());
		//session.close();
		return objects2;
		
		
	}
}
