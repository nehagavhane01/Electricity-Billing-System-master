package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="unit_price")
public class Consumer {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consumer_type")
	private String consumerType=null;
	@Column(name="free_units")
	private int freeUnits=0;
	@Column(name="per_unit_price")
	private int perUnitPrice=0;
	public String getConsumerType() {
		return consumerType;
	}
	public void setConsumerType(String consumerType) {
		this.consumerType = consumerType;
	}
	public int getFreeUnits() {
		return freeUnits;
	}
	public void setFreeUnits(int freeUnits) {
		this.freeUnits = freeUnits;
	}
	public int getPerUnitPrice() {
		return perUnitPrice;
	}
	public void setPerUnitPrice(int perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}
	@Override
	public String toString() {
		return "BillService [consumerType=" + consumerType + ", freeUnits=" + freeUnits + ", perUnitPrice="
				+ perUnitPrice + "]";
	}
	public Consumer(String consumerType, int freeUnits, int perUnitPrice) {
		super();
		this.consumerType = consumerType;
		this.freeUnits = freeUnits;
		this.perUnitPrice = perUnitPrice;
	}
	public Consumer() {
		super();
	}
}
