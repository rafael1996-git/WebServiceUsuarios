package com.ine.WebSeviceUsuarios.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ine.WebSeviceUsuarios.dto.Usuarios;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory ==null) {
			try {
				Configuration configuracion =new Configuration();
				Properties settings=new Properties();
				settings.put(Environment.DATASOURCE, "java:jboss/datasources/controldb");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "none");
				configuracion.setProperties(settings);
				configuracion.addAnnotatedClass(Usuarios.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuracion.getProperties()).build();
				sessionFactory = configuracion.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		return sessionFactory;
		
		
	}
}
