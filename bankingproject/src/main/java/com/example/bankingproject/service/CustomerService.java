package com.example.bankingproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingproject.entity.Customer;
import com.example.bankingproject.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	public Customer createAccount(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public List <Customer> getDetails() {
		return customerRepo.findAll();
	}
	
	public Optional<Customer> getByid(long id) {
		return customerRepo.findById(id);
	}
	
	public List<Customer> getByname(String accountHolderName){
		return customerRepo.findByaccountHolderName(accountHolderName);
	}
	
	public Customer deposit(long id, double amount) {
		
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		double totalAmount =customer.getBalance()+amount;
		customer.setBalance(totalAmount);
		Customer savedAccount =customerRepo.save(customer);
		return savedAccount;
		
	}
	
	public Customer withdraw (long id,double amount) {
		Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
		if(customer.getBalance()< amount) {
			throw new RuntimeException("insufficient funds");
		}
		double remainingBal =customer.getBalance()-amount;
		customer.setBalance(remainingBal);
		Customer savedAccount=customerRepo.save(customer);
		return savedAccount;
	}

}
