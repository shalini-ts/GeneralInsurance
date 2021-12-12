package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.Test;

import com.lti.dao.ClaimDao;
import com.lti.entity.Claim;
import com.lti.entity.Insurance;

public class ClaimTest {

	ClaimDao dao = new ClaimDao();
	@Test
	public void findClaimByClaimId() {
		Claim claim = dao.findClaimByClaimId(1);
		System.out.println(claim.getClaimAmount()+ " "+claim.getApprovedAmount());
	}
	
	@Test
	public void addOrUpdateClaim() {
		Claim claim = new Claim();
		claim.setApprovalDate(LocalDate.of(2021, 12, 13));
		claim.setApprovalStatus("Pending");
		claim.setApprovedAmount(233);
		claim.setClaimAmount(1000);
		
	//TODO	Insurance insurance = dao.findInsuranceByInsuranceId(1);
	//	claim.setInsurance(insurance);
		
		dao.addOrUpdateClaim(claim);
	}

	@Test
	public void viewAllPendingClaims() {
		HashSet<Claim> claims = dao.viewAllPendingClaims();
		if(claims!= null) {
			for(Claim clm:claims)
				System.out.println(clm.getInsurance().getInsuranceId()+" "+clm.getClaimAmount());
		}
		else {
			System.out.println("No Pending Claims Found");
		}
	}
}
