package com.jsp.sunbase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.sunbase.entity.Customer;
import com.jsp.sunbase.repository.CustomerRepository;

@Service
public class CustomerService {
@Autowired
private CustomerRepository customerRepository;

public List<Customer> getAllCustomer(){
	return customerRepository.findAll();
}
	
public void saveCustomer(Customer customer) {
      this.customerRepository.save(customer);
}
public  Customer getCustomerById(long id) {
	Optional <Customer>optional = customerRepository.findById(id);
	Customer customer = null;
	if(optional.isPresent()) {
		 customer =optional.get(); 
	}
	else {
		throw new RuntimeException("Customer not found for id ::"+id);
	}
	return customer;
}
public void deleteCustomerById(long id) {
	this.customerRepository.deleteById(id);

}
}

 

