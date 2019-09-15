package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Customer;

@Repository
public class CustomerRepository {
	private final ConcurrentMap<Integer, Customer> customerMap = new ConcurrentHashMap<>();
	
	public List<Customer> findAll(){
		return new ArrayList<>(customerMap.values());
	}
	
	//get - key의 value return
	public Customer findOne(Integer customerId) {
		return customerMap.get(customerId);
	}
	
	//put - key의 value return
	public Customer save(Customer customer) {
		return customerMap.put(customer.getId(), customer);
	}
	
	public void delete(Integer customerId) {
		customerMap.remove(customerId);
	}
}
