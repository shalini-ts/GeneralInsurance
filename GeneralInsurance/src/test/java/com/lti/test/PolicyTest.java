package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.PolicyDao;
import com.lti.entity.Customer;
import com.lti.entity.Policy;

public class PolicyTest {
	PolicyDao dao  = new PolicyDao();

	@Test
	public void addOrUpdatePolicy() {
		Policy policy = new Policy();
		policy.setPolicyType("2 wheeler comprehensive");
		policy.setPolicyPremium(5000);
		policy.setPolicyDuration("7");
		
		dao.addOrUpdatePolicy(policy);
	}
	
	@Test
	public void findPolicyByPolicyId(){
		Policy p = dao.findPolicyByPolicyId(1);
		System.out.println(p.getPolicyType()+" "+p.getPolicyDuration());
	}

	@Test
	public void removePolicyByPolicyId(){
		dao.removePolicyByPolicyId(1);
		
	}

}
