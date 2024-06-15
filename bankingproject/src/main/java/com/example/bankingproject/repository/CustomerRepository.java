package com.example.bankingproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankingproject.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	List <Customer> findByaccountHolderName(String accountHolderName);

}
