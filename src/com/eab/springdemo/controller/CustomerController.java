package com.eab.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eab.springdemo.dao.CustomerDAO;
import com.eab.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject DAO implementation into controller 
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		// get the customers from DAO
		List<Customer> customers = customerDAO.getCustomers();

		// add customers to model
		model.addAttribute("customers",customers);
		
		return "list-customers";
	}
}
