package com.jaiworld.springbootmvc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jaiworld.springbootmvc.dao.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
