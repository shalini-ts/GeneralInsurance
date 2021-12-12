package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Admin;
import com.lti.entity.Payment;

public class AdminDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public AdminDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Admin addOrUpdateAdmin(Admin admin) {
		try {
			tx.begin();
			Admin admin1 = em.merge(admin);
			tx.commit();
			return admin1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
		
		return null;
	}
	
	public boolean validateAdminLogin(String userName, String password) {
		String jpql="select count(a) from Admin a where a.adminUserName=:un and a.adminPassword=:pwd";
		
		TypedQuery<Long> query=em.createQuery(jpql, Long.class);
		query.setParameter("un", userName);
		query.setParameter("pwd", password);
		Long i = query.getSingleResult();
		
		if(i>0)
			return true;
		else
			return false;
		
	}
	
}
