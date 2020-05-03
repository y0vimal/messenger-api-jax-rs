package org.vimal.development.messenger_rest_api.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vimal.development.messenger_rest_api.model.Message;

public class DatabaseService {
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
