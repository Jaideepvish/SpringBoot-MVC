/**
 * 
 */
package com.jaiworld.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jaiworld.springbootmvc.dao.Customer;
import com.jaiworld.springbootmvc.service.CustomerService;

/**
 * @author jaideepvish
 *
 */

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("customerSection")
	public String getCustomerPage() {
		return "customerHome";
	}
	
	@RequestMapping("/addCustomer")
	public ModelAndView addCustomer(Customer customer) {
		ModelAndView mv = new ModelAndView();		
		String result = customerService.addCustomer(customer);
		String message = "success".equalsIgnoreCase(result) ? "Customer added scussfully" : "Customer not added scussfully" ;
		mv.addObject("message", message);			
		mv.setViewName("customerHome");
		return mv;
	}
	
	@RequestMapping("/getCustomerDetails")
	public ModelAndView getCustomerById(@RequestParam("id") long customerId) {
		ModelAndView mv = new ModelAndView("customerHome");
		Customer customer = customerService.getCustomerById(customerId);
		if(customer == null) {
			mv.addObject("noRecordFound", "No results found");
		} else {
			mv.addObject(customer);
		}
		return mv;
		
	}
	
	@RequestMapping("/getAllCustomerDetails")
	public ModelAndView getAllCustomers() {
		ModelAndView mv = new ModelAndView("customerHome");
		mv.addObject("customerList",customerService.getAllCustomerDetails());
		return mv;
	}
	
	@RequestMapping("/deleteCustomer")
	public ModelAndView deleteCustomerById(@RequestParam("id") long customerId) {
		ModelAndView mv = new ModelAndView("customerHome");
		String result = customerService.deleteCustomerById(customerId);
		String message = "success".equalsIgnoreCase(result) ? "Customer deleted scussfully" : "Customer record not found" ;
		mv.addObject("deletionResult", message);			
		mv.setViewName("customerHome");
		return mv;
	}

}
