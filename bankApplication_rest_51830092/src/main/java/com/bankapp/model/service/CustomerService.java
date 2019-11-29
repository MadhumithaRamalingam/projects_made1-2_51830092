package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.bankapp.model.entities.Customer;
import com.bankapp.web.controller.FormUpdateRequest;



public interface CustomerService {
	public List<Customer> getAllCustomer();

	public Optional<Customer> findCustomerById(Long id);

	public void deleteCustomer(Long id);

	public Customer addCustomer(Customer customer);

	Customer updateCustomer(Long id, Customer customer);

}
