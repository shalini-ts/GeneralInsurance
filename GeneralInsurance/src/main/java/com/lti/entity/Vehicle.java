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
public class Vehicle {
	

	@Id
	@SequenceGenerator(name = "v_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "v_seq", strategy = GenerationType.SEQUENCE)
	private int vehicleId;
	private int registrationNo;
	private String vehicleType;
	private int engineNo;
	private int chassisNo;
	private LocalDate purchaseDate;
	private String vehicleModel;
	private String manufacturer;
	
	//vehicle_id, insu_id(FK), registration_number, vehicle_type , engine_no, chassis_no, purchase_date,
	//vehicle_model, vehicle_manufacturer
	
	@OneToOne
	@JoinColumn(name = "insurance_id")
	Insurance insurance;
	
	public Vehicle() {
		
	}
	
	public Vehicle(int vehicleId, int registrationNo, String vehicleType, int engineNo, int chassisNo,
			LocalDate purchaseDate, String vehicleModel, String manufacturer, Insurance insurance) {
		super();
		this.vehicleId = vehicleId;
		this.registrationNo = registrationNo;
		this.vehicleType = vehicleType;
		this.engineNo = engineNo;
		this.chassisNo = chassisNo;
		this.purchaseDate = purchaseDate;
		this.vehicleModel = vehicleModel;
		this.manufacturer = manufacturer;
		this.insurance = insurance;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(int engineNo) {
		this.engineNo = engineNo;
	}

	public int getChassisNo() {
		return chassisNo;
	}

	public void setChassisNo(int chassisNo) {
		this.chassisNo = chassisNo;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", registrationNo=" + registrationNo + ", vehicleType=" + vehicleType
				+ ", engineNo=" + engineNo + ", chassisNo=" + chassisNo + ", purchaseDate=" + purchaseDate
				+ ", vehicleModel=" + vehicleModel + ", manufacturer=" + manufacturer + ", insurance=" + insurance
				+ "]";
	}

		

}
