package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.dao.PaymentDao;
import com.lti.entity.Customer;
import com.lti.entity.Payment;

public class PaymentTest {

	PaymentDao dao = new PaymentDao();
	CustomerDao dao1 = new CustomerDao();
	
	@Test
	public void findByPaymentId() {
		
		Payment p = dao.findByPaymentId(1);
		System.out.println(p.getPaymentAmount());
	}
	
	@Test
	public void findByCustomerId() {
		Payment p = dao.findByCustomerId(1);
		System.out.println(p.getPaymentAmount());
	}
	
	@Test
	public void addOrUpdatePaymentByCustomerId() {
		
		Payment p = new Payment();
		p.setPaymentAmount(10000);
		p.setPaymentDate(LocalDate.of(2021, 11, 26));
		
		Customer c = dao1.findByCustomerId(1);
		p.setCustomer(c);

		Payment pmt = dao.addOrUpdatePaymentByCustomerId(p);
		System.out.println(pmt);
		
	}
	
}
