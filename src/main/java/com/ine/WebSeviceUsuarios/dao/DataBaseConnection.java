package com.ine.WebSeviceUsuarios.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.logging.impl.Log4jLogger;

import com.ine.WebSeviceUsuarios.dto.Usuarios;
import com.ine.WebSeviceUsuarios.hibernate.HibernateUtil;



   




	public List<Usuarios> getConsultaDAO() throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = builder.createQuery(Usuarios.class);
		Root<Usuarios> root = criteriaQuery.from(Usuarios.class);
		criteriaQuery.select(root);
		List<Usuarios> result = session.createQuery(criteriaQuery).getResultList();
		session.close();
		return result;

	}
	public void closeSession() {
		session.close();
	}
}
