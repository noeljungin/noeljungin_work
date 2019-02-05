package com.example.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
//	
//	@RequestMapping(method=RequestMethod.GET)
//	List<Customer> getCustomers(){
//		List<Customer> customers = customerService.findAll();
//		return customers;
//	}
//	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.findOne(id);
		return customer;
	}
	
	//add new customers
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Customer postCustomers(@RequestBody Customer customer) {
		return customerService.create(customer);
	}
	
	//update customer information
	@RequestMapping(value="{id}", method=RequestMethod.POST)
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}

	// delete customer
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Page<Customer> getCustomers(@PageableDefault Pageable pageable){
		Page<Customer> customers = customerService.findAll(pageable);
		return customers;
	}
	
	
	
	
	
	
}
