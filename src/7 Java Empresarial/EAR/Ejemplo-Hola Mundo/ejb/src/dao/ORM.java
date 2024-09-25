package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Singleton para las sesiones del ORM (Hibernate)
 * 
 *
 */
public enum ORM {
	INSTANCE;
	
//	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


	public Session openSession() {
		//return this.sessionFactory.openSession();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory.openSession();
	}
}
