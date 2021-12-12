package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Travel {

	@Id
	@SequenceGenerator(name = "tvl_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "tvl_seq", strategy = GenerationType.SEQUENCE)
	int travelId;
	LocalDate startDate;
	LocalDate endDate;
	String city;
	//Travel_id,insu_id(FK),Travel_startdate,Travel_enddate,Travel_city
	
	@OneToOne
	@JoinColumn(name = "insurance_id")
	Insurance insurance;
	
	public Travel() {
		
	}
	
	public Travel(int travelId, LocalDate startDate, LocalDate endDate, String city, Insurance insurance) {
		super();
		this.travelId = travelId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.insurance = insurance;
	}


	public int getTravelId() {
		return travelId;
	}
	public void setTravelId(int travelId) {
		this.travelId = travelId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Travel [travelId=" + travelId + ", startDate=" + startDate + ", endDate=" + endDate + ", city=" + city
				+ ", insurance=" + insurance + "]";
	}
	
	
}
