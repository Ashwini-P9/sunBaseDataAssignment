package com.jsp.sunbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.sunbase.entity.Customer;
import com.jsp.sunbase.service.CustomerService;

@RestController
@RequestMapping("/rest/SunBasedata")
public class CustomerController {

	 
	@Autowired
	private CustomerService customerService;

	//display list of customer
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomers",customerService.getAllCustomer());
	    return "index";
	}

	@GetMapping("/showNewCustomerForm") 
	//create model attribute to bind form data
	public String showNewCustomerForm(Model model) {
	Customer customer = new Customer();
	model.addAttribute("customer", customer);
	return "new_customer";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer customer) {
		//save Customer  to database
		customerService.saveCustomer(customer);
		return "redirect:/";
		
	}
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable ( value="id")long id,Model model) {
		
		//get customer from the service
		Customer customer =customerService.getCustomerById(id);
		
		//set customer as a model attributre to pre-populate the form
		model.addAttribute("customer", customer);
		return "update_customer";

	}
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable ( value="id")long id) {
		//call delete from service
		 this.customerService.deleteCustomerById(id);
		 return "redirect:/";
	}
		


	}




