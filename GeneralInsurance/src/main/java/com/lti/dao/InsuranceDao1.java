package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Customer;
import com.lti.entity.Insurance;

public class InsuranceDao1 {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public InsuranceDao1() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
//	public Insurance addOrUpdateInsurance(Insurance insurance) {
//		try {
//			tx.begin();
//			Insurance i = em.merge(insurance);
//			tx.commit();
//			return i;
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//		}finally {
//			em.close();
//		}
//		return null;
//	}
	
	public Insurance addOrUpdateNewInsuranceWithNewVehicle(Insurance insurance) {
		try {
			tx.begin();
			Insurance ins = em.merge(insurance);
			tx.commit();
			return ins;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Insurance addOrUpdateNewInsuranceWithTravel(Insurance insurance) {
		try {
			tx.begin();
			Insurance ins = em.merge(insurance);
			tx.commit();
			return ins;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	
	public Insurance findById(int insuranceId) {
		try {
			return em.find(Insurance.class, insuranceId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Customer fetchInsuranceByCustomerId(int customerId) {
		String jpql = "select c from customer c where c.customerId=:cust";
		TypedQuery<Customer> query = em.createNamedQuery(jpql, Customer.class);
		query.setParameter("cust", customerId);
		return query.getSingleResult();
	}
	
	public Insurance addOrUpdateInsuranceByCustomerId(Insurance insurance) {
			tx.begin();
			Insurance i = em.merge(insurance);
			tx.commit();
			return i;
	}
}
