package com.lti.entity;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	
	@Id
	@SequenceGenerator(name = "cu_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "cu_seq", strategy = GenerationType.SEQUENCE)
	private int customerId;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String customerUserName;
	private String password;
	private String address;
	private LocalDate customerDateOfBirth;
	private String licenseNo;

	//customer_id, customer_name, customer_mobile, customer_email, customer_username,
	//customer_password, customer_address, customer_dob, license_number
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	Set<Insurance> insurance;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	Set<Payment> payment;
	
	public Customer() {
		
	}
		
	public Customer(int customerId, String customerName, String customerMobile, String customerEmail,
			String customerUserName, String password, String address, LocalDate customerDateOfBirth, String licenseNo,
			Set<Insurance> insurance, Set<Payment> payment) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerUserName = customerUserName;
		this.password = password;
		this.address = address;
		this.customerDateOfBirth = customerDateOfBirth;
		this.licenseNo = licenseNo;
		this.insurance = insurance;
		this.payment = payment;
	}


	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}
	public void setCustomerDateOfBirth(LocalDate customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Set<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Set<Insurance> insurance) {
		this.insurance = insurance;
	}

	public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", customerUserName=" + customerUserName
				+ ", password=" + password + ", address=" + address + ", customerDateOfBirth=" + customerDateOfBirth
				+ ", licenseNo=" + licenseNo + ", insurance=" + insurance + ", payment=" + payment + "]";
	}
	
}
