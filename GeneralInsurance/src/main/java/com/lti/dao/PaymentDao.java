package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Customer;
import com.lti.entity.Payment;

public class PaymentDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public PaymentDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Payment findByPaymentId(int paymentId) {

		return em.find(Payment.class, paymentId);
	}

	public Payment findByCustomerId(int customerId) {

		return em.find(Payment.class, customerId);
	}
	
	public Payment addOrUpdatePaymentByCustomerId(Payment payment) {
		try {
			tx.begin();
			Payment p = em.merge(payment);
			tx.commit();
			return p;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return null;

	}

}
