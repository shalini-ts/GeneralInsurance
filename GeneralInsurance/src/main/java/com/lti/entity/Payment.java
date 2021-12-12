package com.lti.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Payment {

	@Id
	@SequenceGenerator(name = "pmt_seq",initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "pmt_seq", strategy = GenerationType.SEQUENCE)
	int paymentId;
	LocalDate paymentDate;
	double paymentAmount;
	// payment_id, customer_id(FK), payment_date, payment_amount,
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	Customer customer;

	public Payment() {

	}

	public Payment(int paymentId, LocalDate paymentDate, double paymentAmount, Customer customer) {
		super();
		this.paymentId = paymentId;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.customer = customer;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount
				+ ", customer=" + customer + "]";
	}

}
