package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class CustomerTest {
	
	CustomerDao dao = new CustomerDao();

	@Test
	public void addOrUpdateCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("Marie");
		customer.setAddress("Bangalore");
		customer.setCustomerDateOfBirth(LocalDate.of(1999, 12, 3));
		customer.setCustomerEmail("Marie@lti.com");
		customer.setCustomerMobile("9998765656");
		customer.setCustomerUserName("marie");
		customer.setLicenseNo("23456765");
		customer.setPassword("marie123");
		
		dao.addOrUpdateCustomer(customer);
	}
	
	@Test
	public void findByCustomerId(){
		Customer c = dao.findByCustomerId(1);
		System.out.println(c.getCustomerName()+" "+c.getCustomerUserName());
	}

	@Test
	public void findByCustomerUserName() {
		Customer c = dao.findByCustomerUserName("marie");
		System.out.println(c.getCustomerName()+" "+c.getCustomerUserName());

	}
	
	@Test
	public void validateCustomerLogin() {
		boolean isValid =dao.validateCustomerLogin("marie", "marie123");
		System.out.println(isValid);
	}
}
