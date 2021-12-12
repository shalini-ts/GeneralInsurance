package com.lti.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Claim;
import com.lti.entity.Customer;

public class ClaimDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public ClaimDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Claim addOrUpdateClaim(Claim claim) {
		try {
			tx.begin();
			Claim clm = em.merge(claim);
			tx.commit();
			return clm;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Claim findClaimByClaimId(int claimId) {
		try {
			return em.find(Claim.class, claimId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public HashSet<Claim> viewAllPendingClaims() {
		try {
			String jpql = " select clm from Claim clm where clm.approvalStatus=:'pending'";
			TypedQuery<Claim> query = em.createQuery(jpql, Claim.class);
			return new HashSet<Claim>(query.getResultList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
