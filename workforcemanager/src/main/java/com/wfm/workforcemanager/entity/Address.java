package com.wfm.workforcemanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private int pincode;
	private String city;
	private String village;
	private String state;
	
	
	
	public Address(int aid, int pincode, String city, String village, String state) {
		super();
		this.aid = aid;
		this.pincode = pincode;
		this.city = city;
		this.village = village;
		this.state = state;
	}
	public Address() {
		super();
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", pincode=" + pincode + ", city=" + city + ", village=" + village + ", state="
				+ state + "]";
	}
	
}
