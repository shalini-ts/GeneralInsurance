package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;
import static org.junit.Assert.*;
import com.lti.dao.CustomerDao;
import com.lti.dao.InsuranceDao1;
import com.lti.entity.Customer;
import com.lti.entity.Insurance;
import com.lti.entity.Travel;
import com.lti.entity.Vehicle;

public class InsuranceTest1 {

	InsuranceDao1 dao = new InsuranceDao1();
	CustomerDao dao1 = new CustomerDao();

	
	@Test
	public void addOrUpdateInsuranceByCustomerId() {
		Insurance insurance = new Insurance();
		
		insurance.setIssueDate(LocalDate.of(2021, 10, 15));
		
		Customer c = dao1.findByCustomerId(1);
		insurance.setCustomer(c);
		
		dao.addOrUpdateInsuranceByCustomerId(insurance);
		
	}
	
	@Test
	public void addOrUpdateNewInsuranceWithNewVehicle() {
		Insurance insurance=new Insurance();
		
		insurance.setIssueDate(LocalDate.of(2012, 2, 1));  
		System.out.println("hi");
//		Vehicle v = new Vehicle();
//		
//		v.setRegistrationNo(12454);
//		v.setVehicleType("bike");
//		v.setEngineNo(785);
//		v.setChassisNo(4526);
//		v.setPurchaseDate(LocalDate.of(2021,11,11));
//		v.setVehicleModel("micro");
//		v.setManufacturer("suzuki");
//		v.setInsurance(insurance);
//		
//		insurance.setVehicle(v);
		
		dao.addOrUpdateNewInsuranceWithNewVehicle(insurance);		
	}
	
	@Test
	public void addOrUpdateNewInsuranceWithTravel() {
		Insurance insurance=new Insurance();
		insurance.setIssueDate(LocalDate.of(2010, 10, 5));
				
		Travel t = new Travel();
		t.setStartDate(LocalDate.of(2021, 11, 10));
		t.setEndDate(LocalDate.of(2021, 11, 15));
		t.setCity("vizianagaram");
		t.setInsurance(insurance);
		
		insurance.setTravel(t);
		
		dao.addOrUpdateNewInsuranceWithTravel(insurance);
	}
	
	@Test
	public void findByInsuranceId(){
		Insurance i = dao.findById(1);
		System.out.println(i.getIssueDate());
	}
	
	@Test
	public void fetchInsuranceByCustomerId(int customerId) {
		Customer c = dao.fetchInsuranceByCustomerId(customerId);
		System.out.println(c.getCustomerId()+""+c.getCustomerName()+" "+c.getCustomerEmail()+" "+c.getCustomerMobile()+" "+c.getAddress()+" "+c.getLicenseNo()+" "+c.getPassword());
	}
	
}
