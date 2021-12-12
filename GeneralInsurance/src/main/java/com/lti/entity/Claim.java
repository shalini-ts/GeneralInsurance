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
public class Claim {

	@Id
	@SequenceGenerator(name = "clm_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "clm_seq", strategy = GenerationType.SEQUENCE)
	private int claimId;
	private String typeOfAction;
	private LocalDate approvalDate;
	private String approvalStatus;
	private double claimAmount;
	private double approvedAmount;
	private String aadharCard;
	
	//claim_id, insu_Id(FK),approval_date, approval_status, claim_amount,claim_reason--,adharcard,approved-amount

	@OneToOne
	@JoinColumn(name = "insurance_id")
	Insurance insurance;
	
	public Claim() {
		
	}
	
	public Claim(int claimId, String typeOfAction, LocalDate approvalDate, String approvalStatus, double claimAmount,
			double approvedAmount, String aadharCard, Insurance insurance) {
		super();
		this.claimId = claimId;
		this.typeOfAction = typeOfAction;
		this.approvalDate = approvalDate;
		this.approvalStatus = approvalStatus;
		this.claimAmount = claimAmount;
		this.approvedAmount = approvedAmount;
		this.aadharCard = aadharCard;
		this.insurance = insurance;
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getTypeOfAction() {
		return typeOfAction;
	}

	public void setTypeOfAction(String typeOfAction) {
		this.typeOfAction = typeOfAction;
	}

	public LocalDate getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(LocalDate approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}


	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}


	public String getAadharCard() {
		return aadharCard;
	}


	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}


	public Insurance getInsurance() {
		return insurance;
	}


	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}


	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", typeOfAction=" + typeOfAction + ", approvalDate=" + approvalDate
				+ ", approvalStatus=" + approvalStatus + ", claimAmount=" + claimAmount + ", approvedAmount="
				+ approvedAmount + ", aadharCard=" + aadharCard + ", insurance=" + insurance + "]";
	}

	// Insurance insurance;
	

}
