package com.custapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.custapp.model.persistance.Customer;
import com.custapp.model.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "allcustomers", method = RequestMethod.GET)
	public String getCustomers(ModelMap map) {
		System.out.println("------------------------");
		map.addAttribute("customers", customerService.getAllCustomers());
		return "all_customers";
	}
	
	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		// adding an form bean
		map.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addCustomerUpdatePost(
			 @ModelAttribute(value = "customer") @Valid Customer customer,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addcustomer";
		} else {
			if (customer.getCust_id() == 0)
				customerService.addCustomer(customer);
			else
				customerService.updateCustomer(customer);
			return "redirect:allcustomers";
		}
	}

	// controller mapped for delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		int custId = Integer.parseInt(req.getParameter("id"));
		customerService.removeCustomer(custId);
		return "redirect:allcustomers";
	}

	// update get part
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateCustomerGet(HttpServletRequest req, ModelMap map) {
		int custId = Integer.parseInt(req.getParameter("id"));
		Customer customerToBeUpdate = customerService.getCustomerById(custId);
		System.out.println(customerToBeUpdate);

		map.addAttribute("customer", customerToBeUpdate);
		return "addcustomer";
	}

}
