package com.niit.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.User;

@Configurable
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {
 
	@Bean(name = "dataSource")
	public BasicDataSource getDataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:~/test");
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addAnnotatedClasses(User.class);
	return sessionBuilder.buildSessionFactory();
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
		}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	return transactionManager;
	}
}
