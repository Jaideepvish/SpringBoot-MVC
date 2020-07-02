package com.jaiworld.springbootmvc.service;

import java.util.List;

import com.jaiworld.springbootmvc.dao.Customer;

public interface CustomerService {
	
	String addCustomer(Customer customer);
	Customer getCustomerById(long id);
	List<Customer> getAllCustomerDetails();
	String deleteCustomerById(long customerId);

}
