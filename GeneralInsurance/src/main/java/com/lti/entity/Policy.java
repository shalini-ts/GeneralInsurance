package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Policy {

	@Id
	@SequenceGenerator(name = "plc_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "plc_seq", strategy = GenerationType.SEQUENCE)
	int policyId;
	double policyPremium;
	String policyType;
	String policyDuration;
	// Policy-id,policy_premium,policy_type ,Policy_duration

	@ManyToOne
	@JoinColumn(name = "insurance_id")
	Insurance insurance;
	
	public Policy() {

	}

	public Policy(int policyId, double policyPremium, String policyType, String policyDuration, Insurance insurance) {
		super();
		this.policyId = policyId;
		this.policyPremium = policyPremium;
		this.policyType = policyType;
		this.policyDuration = policyDuration;
		this.insurance = insurance;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public double getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getPolicyDuration() {
		return policyDuration;
	}

	public void setPolicyDuration(String policyDuration) {
		this.policyDuration = policyDuration;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyPremium=" + policyPremium + ", policyType=" + policyType
				+ ", policyDuration=" + policyDuration + ", insurance=" + insurance + "]";
	}

}
