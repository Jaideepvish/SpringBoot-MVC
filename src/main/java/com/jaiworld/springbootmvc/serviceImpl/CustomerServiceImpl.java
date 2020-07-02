package com.jaiworld.springbootmvc.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jaiworld.springbootmvc.dao.Customer;
import com.jaiworld.springbootmvc.repositories.CustomerRepository;
import com.jaiworld.springbootmvc.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public String addCustomer(Customer customer) {
		customerRepo.save(customer);
		return "success";
	}

	@Override
	public Customer getCustomerById(long id) {
		Customer customer;
		try {
			customer = customerRepo.findById(id).get();
		}catch(NoSuchElementException ex) {
			customer = null;
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCustomerDetails() {
		List<Customer> customerList = (List<Customer>) customerRepo.findAll();
		return customerList;
	}

	@Override
	public String deleteCustomerById(long customerId) {
		String result;
		try {
			customerRepo.deleteById(customerId);
			result = "success";
		}catch(EmptyResultDataAccessException e) {
			result = "failure";
		}catch(Exception ex) {
			result = "failure";
		}
		return result;
	}

}
