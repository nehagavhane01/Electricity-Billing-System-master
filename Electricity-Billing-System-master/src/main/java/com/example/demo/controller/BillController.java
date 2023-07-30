package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Consumer;
import com.example.demo.model.Customer;
import com.example.demo.service.ConsumerService;

@RestController
public class BillController {
	
	private ConsumerService service;
	
	public BillController(ConsumerService service) {
		this.service = service;
	}
	
	//API : http://localhost:9191/generate-bill?customerType={customerType}&units={units}&days={days}
	@RequestMapping("/generate-bill")
	public String generateBill(Customer customer) {
		return service.generateBill(customer);
	}
	
	//API : http://localhost:9191/get-all-current-rates
	@RequestMapping("/get-all-current-rates")
	public List<Consumer> getCurrentRates(){
		return service.getConsumer();
	}
	
	//API : http://localhost:9191/get-current-rate-by-type/{consumerType}
	@GetMapping("/get-current-rate-by-type/{type}")
	public Consumer getConsumerByType(@PathVariable String type) {
		return service.getConsumerByType(type);
	}	
	
	//API : http://localhost:9191/revise-consumer-rates?consumerType="{type}"&freeUnits="{units}"&perUnitPrice="{price}"
	@PutMapping("/revise-consumer-rates")
	public Consumer updateConsumer(Consumer consumer) {
		return service.updateConsumer(consumer);
	}
}
