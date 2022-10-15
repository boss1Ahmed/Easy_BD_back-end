package util;


import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.cfg.annotations.*;


public class HibernateUtil {
    public static final SessionFactory sessionFactory;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal();

    static {
        try {
            // Cr�ation de la SessionFactory � partir de hibernate.cfg.xml
            sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
            
        }
    }

   // public static final ThreadLocal session = new ThreadLocal();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
          session.close();
        }
      }
}