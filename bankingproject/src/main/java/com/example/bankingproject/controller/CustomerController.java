
package com.example.bankingproject.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingproject.entity.Customer;
import com.example.bankingproject.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService custServ;
	
	@PostMapping("/createAccount")
	public Customer createAcc(@RequestBody Customer customer){
		Customer customer1 = custServ.createAccount(customer);
				return customer1;
	}
	
	@GetMapping("/getAccDetails")
	public List<Customer> fetchDetails(){
		List <Customer> l1= custServ.getDetails();
		return l1;
		
	}
	
	@GetMapping("/getByID/{id}")
	public Optional<Customer> findById(@PathVariable long id) {
		Optional<Customer> cs= custServ.getByid(id);
		return cs;
	}
	
	@GetMapping("/getByName/{accountHolderName}")
	public List<Customer> findByname(@PathVariable  String accountHolderName){
		List <Customer> css= custServ.getByname(accountHolderName);
		return css;
	}
	
	@PutMapping("/{id}/deposit")
	public Customer deposit(@PathVariable long id, @RequestBody Map<String,Double> customer) {
		
		Double amount= customer.get("amount");
		Customer savedAccount = custServ.deposit(id, amount);
		return savedAccount;
	}
	
	@PostMapping("/{id}/withdraw")
	public Customer withdraw(@PathVariable long id, @RequestParam double amount) {
		
		//Double amount= customer.get("amount");
		Customer savedAccount =custServ.withdraw(id, amount);
		return savedAccount;
		}
	}
	


