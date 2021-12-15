package com.lti.entity;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Insurance {

	@Id
	@SequenceGenerator(name = "ins_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "ins_seq", strategy = GenerationType.SEQUENCE)
	int insuranceId;
	LocalDate issueDate;
	LocalDate expiryDate;
	
	//insurance_id,customer_id(FK), policy_id(FK), insurance_issue_date
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "policy_id")
	Policy policy;
	
	@OneToOne(mappedBy = "insurance",cascade = CascadeType.ALL)
	Vehicle vehicle;
	
	@OneToOne(mappedBy = "insurance",cascade = CascadeType.ALL)
	Travel travel;
	
	@OneToOne(mappedBy = "insurance",cascade = CascadeType.ALL)
	Claim claim;
	
//	public Insurance() {
//		
//	}
	
//	public Insurance(int insuranceId, LocalDate issueDate, Customer customer, Policy policy, Vehicle vehicle,
//			Travel travel, Claim claim) {
//		super();
//		this.insuranceId = insuranceId;
//		this.issueDate = issueDate;
//		this.customer = customer;
//		this.policy = policy;
//		this.vehicle = vehicle;
//		this.travel = travel;
//		this.claim = claim;
//	}



	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	

}
