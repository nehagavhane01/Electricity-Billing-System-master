package com.example.demo.service;

import com.example.demo.model.Customer;

@FunctionalInterface
public interface GenerateBill {
	
	String generateBill(Customer customer);
}
