package com.custapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custapp.model.persistance.Customer;
import com.custapp.model.persistance.CustomerDao;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	@Override
	public List<Customer> getAllCustomers() {
		
		return dao.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(int custId) {
		Customer customer=dao.getCustomerById(custId);
		if(customer==null)
			throw new CustomerNotFoundException("customer with id "+custId+" is not found");
		
		return customer ;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return dao.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		return dao.updateCustomer(customer);
	}

	@Override
	public Customer removeCustomer(int custId) {
		
		return dao.removeCustomer(custId);
	}

}
