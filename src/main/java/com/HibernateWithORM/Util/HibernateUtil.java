package com.HibernateWithORM.Util;

import java.lang.module.Configuration;

import org.hibernate.SessionFactory;



public class HibernateUtil {
	
	private static final SessionFactory sessionFactory=buildSessionFacotiry();

	private static SessionFactory buildSessionFacotiry() {
		// TODO Auto-generated method stub
		try {
			return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
		}
		catch(Throwable ex) {
			System.out.println("initail sessionfactory creation faild."+ex);
		throw new ExceptionInInitializerError(ex);
		}
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void shotdown() {
		getSessionFactory().close();
	}

}
