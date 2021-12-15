package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.VehicleDao;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;


public class VehicleTest {
	VehicleDao dao = new VehicleDao();
	
	@Test
	public void addOrUpdateVehicle() {
		Vehicle v = new Vehicle();
		v.setRegistrationNo(3619999);
		v.setVehicleType("car");
		v.setEngineNo(5678);
		v.setChassisNo(6789);
		v.setPurchaseDate(LocalDate.of(2021,12,12));
		v.setVehicleModel("micro");
		v.setManufacturer("indica");
		
		dao.addOrUpdateVehicle(v);
	}

	@Test
	public void findByVehicleId() {
		Vehicle v = dao.findByVehicleId(5);
		System.out.println(v.getRegistrationNo() + " " + v.getVehicleType());
	}
	
	

//	@Test
//	public void fetchVehicleByNewInsuraceId(int insuranceId) {
//		Insurance i = dao.fetchVehicleByNewInsuranceId(insuranceId);
//		System.out.println(i.getCustomerId() + " " + i.getPolicyId() + " " + i.getIssuedate());
//	}
}
