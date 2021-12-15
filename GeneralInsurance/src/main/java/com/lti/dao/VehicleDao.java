package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;

public class VehicleDao {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public VehicleDao() {
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	public Vehicle addOrUpdateVehicle(Vehicle vehicle) {
		try {
			tx.begin();
			Vehicle v = em.merge(vehicle);
			tx.commit();
			return v;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
		return null;
	}

	public Vehicle findByVehicleId(int id) {
		try {
			tx.begin();
			Vehicle v = em.find(Vehicle.class, id);
			tx.commit();
			return v;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Vehicle fetchVehicleByInsuranceId(int insuranceId) {
		String jpql = "select i from insurance i where i.insuranceId=:insu";
		TypedQuery<Vehicle> query = em.createNamedQuery(jpql, Vehicle.class);
		query.setParameter("insu", insuranceId);
		return query.getSingleResult();
	}

	public Vehicle addOrUpdateInsuranceWithNewVehicle(Vehicle vehicle) {
		try {
			tx.begin();
			Vehicle veh = em.merge(vehicle);
			tx.commit();
			return veh;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}