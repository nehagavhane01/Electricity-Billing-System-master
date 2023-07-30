package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Consumer;
import com.example.demo.model.Customer;
import com.example.demo.repository.BillRepository;

@Service
public class ConsumerService{
	
	private BillRepository repo;
	
	public ConsumerService(BillRepository repo) {
		this.repo = repo;
	}
	
	public List<Consumer> getConsumer() {
		return repo.findAll();
	}

	public Consumer getConsumerByType(String consumerType) {
		return repo.findById(consumerType).orElse(null);
	}
	
	public Consumer updateConsumer(Consumer consumer) {
		Consumer existingConsumer = repo.findById(consumer.getConsumerType()).orElse(null);
		if(existingConsumer==null)
			return repo.save(consumer);
		else {
			existingConsumer.setFreeUnits(consumer.getFreeUnits());
			existingConsumer.setPerUnitPrice(consumer.getPerUnitPrice());
			return repo.save(existingConsumer);
		}		
	}
	
	public String generateBill(Customer cust) {
		return gb.generateBill(cust);
	}

	GenerateBill gb = (Customer customer) -> {
	
		String customerType = customer.getCustomerType();
		int usedUnits = customer.getUnits();
		int days = customer.getDays();
		
		int totalBill=0;
		int perUnitPrice=0;
		int freeUnits=0;
		
		Consumer consumer = new Consumer();
		consumer = repo.findById(customerType).orElse(null);
		perUnitPrice = consumer.getPerUnitPrice();
		freeUnits = consumer.getFreeUnits();
		usedUnits -= freeUnits;
			
		totalBill = (usedUnits * days *perUnitPrice);
		
		return "Your bill due is "+((totalBill<0)?0:totalBill)+".";	

	};
}
