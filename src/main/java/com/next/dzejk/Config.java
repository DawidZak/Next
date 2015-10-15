//package com.next.dzejk;
//
//import java.sql.SQLException;
//import java.util.Properties;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.hibernate.SessionFactory;
////import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jndi.JndiPropertySource;
//import org.springframework.orm.hibernate4.HibernateTransactionManager;
//import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//
//import com.next.dzejk.model.Candidate;
//
//@ComponentScan(value="com.next.dzejk")
//@Configuration
//@EnableTransactionManagement
//public class Config {
//
//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//	    BasicDataSource dataSource = new BasicDataSource();
//	    dataSource.setDriverClassName("org.h2.Driver");
//	    dataSource.setUrl("jdbc:h2:tcp//localhost/~/Next");
//	    dataSource.setUsername("sa");
//	    dataSource.setPassword("sa");
//	    
//	    return dataSource;
//	}
//	public Properties getHibernateProperties() {
//	    Properties properties = new Properties();
//	    properties.put("hibernate.show_sql", "true");
//	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//	    return properties;
//	}
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) {
//	 
//	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//	 
//	    sessionBuilder.addAnnotatedClasses(Candidate.class);
//	 
//	    return sessionBuilder.buildSessionFactory();
//	}
//	
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(
//	        SessionFactory sessionFactory) {
//	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//	            sessionFactory);
//	 
//	    return transactionManager;
//	}
//}
