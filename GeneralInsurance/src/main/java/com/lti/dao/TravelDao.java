package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Insurance;
import com.lti.entity.Travel;

public class TravelDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public TravelDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Travel findByTravelId(int travelId) {

		try {
			return em.find(Travel.class, travelId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
