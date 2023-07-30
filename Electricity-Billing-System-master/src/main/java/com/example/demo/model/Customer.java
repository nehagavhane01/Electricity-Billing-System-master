package com.example.demo.model;

public class Customer {

	private String customerType;
	private int units;
	private int days;
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "Customer [customerType=" + customerType + ", units=" + units + ", days=" + days + "]";
	}
	public Customer(String customerType, int units, int days) {
		super();
		this.customerType = customerType;
		this.units = units;
		this.days = days;
	}
}