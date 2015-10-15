//package com.next.dzejk;
//import java.util.Properties;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//
//public class HibernateUtil {
//
//	private static SessionFactory sessionFactory;
//	/*
//	public static final Properties getHibernateProperties() {
//	    Properties properties = new Properties();
//	    properties.put("hibernate.show_sql", "true");
//	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//	    properties.put("hibernate.connection.datasource", "jdbc:mysql://localhost:3306/books");
//	    return properties;
//	}*/
//
//	public static SessionFactory getSessionFactory() {
//		if (sessionFactory == null) {
//			Configuration configuration = new Configuration();
//			configuration.setProperty("hibernate.show_sql", "true");
//			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//			configuration.setProperty("hibernate.connection.datasource", "java:Next");
//			StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
//			registry.applySettings(configuration.getProperties());
//			ServiceRegistry serviceRegistry = registry.build();
//			
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);			
//		}
//		
//		return sessionFactory;
//	}
//
//}