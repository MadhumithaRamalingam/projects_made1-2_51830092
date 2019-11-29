package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.exceptions.AccountNotFoundException;


@RestController
@RequestMapping(path="api")
public class RestAppcontroller {


	/*@GetMapping(path = "home")
	public String home() {
		return "hello to home";
	}

	@GetMapping(path = "admin")
	public String homeAdmin() {
		return "hello to home admin";
	}

	@GetMapping(path = "mgr")
	public String homeMgr() {
		return "hello to home mgr";
	}

	@GetMapping(path = "clerk")
	public String homeuser() {
		return "hello to home clerk";
	}*/
	@Autowired
	private AccountService accountService;
	
	
	private CustomerService customerService;
/*
	@Autowired
	public RestAppcontroller(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	*/
	
	 @Autowired
	public RestAppcontroller(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	/*@GetMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllProduct()
	{
		return new ResponseEntity<List<Account>>(accountService.getAllAccount(),HttpStatus.OK);
	}*/
	
	@GetMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomer()
	{
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping(path = "account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getAnProduct(@PathVariable(name = "id") Long id) {
		Customer customer= customerService.findCustomerById(id).orElseThrow(AccountNotFoundException::new);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProduct(@PathVariable(name = "id") Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path = "account/{accountNumber}", consumes = MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAcc(@PathVariable(name = "accountNumber") Long accountNumber,
			@RequestBody FormUpdateRequest formUpdateBean) {
		
		Account account=accountService.getAccountById(accountNumber);
		Customer customer=accountService.getCustomerById(accountNumber);
		customer.setAddress(formUpdateBean.getAddress());
		customer.setPhone(formUpdateBean.getPhone());
		customer.setCity(formUpdateBean.getCity());
		customer.setEmail(formUpdateBean.getEmail());
		customer.setAccount(account);
		account.setCustomer(customer);
		/*account.getCustomer().setEmail(formUpdateBean.getEmail());
		account.getCustomer().setAddress(formUpdateBean.getAddress());
		account.getCustomer().setPhone(formUpdateBean.getPhone());
		account.getCustomer().setCity(formUpdateBean.getCity());*/
		/*accountService.createAccount(account);	*/
		
	
		return new ResponseEntity<Account>(accountService.createAccount(account),HttpStatus.OK);
	}
	

	@PostMapping(path = "account", consumes = MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addAcc(@RequestBody FormBeanRequest formBean) {
		Customer customer=new Customer(formBean.getName(), formBean.getEmail(), formBean.getPhone(),
				formBean.getAddress(), formBean.getCity(), formBean.getCountry());
		Account account=new Account(formBean.getBalance(), customer, formBean.isBlocked());
		customer.setAccount(account);
		return new ResponseEntity<Account>(accountService.addAccount(account),HttpStatus.CREATED);
	}
	
	

}
