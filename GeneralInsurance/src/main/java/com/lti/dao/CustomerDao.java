package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Customer;

public class CustomerDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public CustomerDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Customer addOrUpdateCustomer(Customer customer) {
		try {
			tx.begin();
			Customer cus = em.merge(customer);
			tx.commit();
			return cus;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return null;
	}

	public Customer findByCustomerId(int customerId) {
		try {
			return em.find(Customer.class, customerId);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return null;
	}

	public Customer findByCustomerUserName(String customerUserName) {
		try {
			String jpql = "select c from Customer c where c.customerUserName=:cun";
			TypedQuery<Customer> query = em.createQuery(jpql, Customer.class);
			query.setParameter("cun", customerUserName);
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public boolean validateCustomerLogin(String customerUserName, String password) {
		try {
			String jpql = "select count(c) from Customer c where c.customerUserName=:cun and c.password=:pwd";
			TypedQuery<Long> query = em.createQuery(jpql, Long.class);
			query.setParameter("cun", customerUserName);
			query.setParameter("pwd", password);
			Long i = query.getSingleResult();

			if (i > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return false;
	}
}
