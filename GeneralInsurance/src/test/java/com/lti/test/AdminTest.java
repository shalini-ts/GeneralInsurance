package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;

public class AdminTest {

	AdminDao dao = new AdminDao();
	
	@Test
	public void addOrUpdateAdmin() {
		
		Admin a = new Admin();
		
		a.setAdminUserName("admin@121");
		a.setAdminEmail("admin123@gmail.com");
		a.setAdminPassword("admin@121");
		a.setAdminName("admin");
		
		dao.addOrUpdateAdmin(a);
	}
	
	@Test
	public void validateAdminLogin() {
		String userName = "admin@121";
		String password = "admin@12";
		boolean x = dao.validateAdminLogin(userName, password);
		System.out.println(x);
		
	}
	
	
}
