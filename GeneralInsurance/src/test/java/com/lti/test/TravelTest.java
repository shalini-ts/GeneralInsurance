package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.TravelDao;
import com.lti.entity.Travel;

public class TravelTest {

	TravelDao dao = new TravelDao();
	
	public void addOrUpdate() {
		Travel t = new Travel();
		t.setStartDate(LocalDate.of(2021, 12, 20));
		t.setEndDate(LocalDate.of(2021, 12, 25));
		t.setCity("Hell");
		
	}

	@Test
	public void findByTravelId() {
		Travel t = dao.findByTravelId(1);
		System.out.println(t.getTravelId() + " " + t.getCity() + " " + t.getStartDate() + " " + t.getEndDate() + " "
				+ t.getInsurance());
	}

}
