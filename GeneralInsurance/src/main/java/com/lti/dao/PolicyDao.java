package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.Customer;
import com.lti.entity.Policy;

public class PolicyDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public PolicyDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Policy addOrUpdatePolicy(Policy policy) {
		try {
			tx.begin();
			Policy pol = em.merge(policy);
			tx.commit();
			return pol;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Policy findPolicyByPolicyId(int policyId) {
		try {
			return em.find(Policy.class, policyId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

//	public void removePolicyByPolicyId(int policyId) {
//		try {
//			Policy policy = findPolicyByPolicyId(policyId);
//			em.remove(policy);
//			System.out.println(" removed");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
	
	
}
