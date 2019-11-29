package com.bankapp.web.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;

@RestController
@RequestMapping(path="api/transaction")
public class TransactionalController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionLogService tnxService;
	
	@PostMapping(path="depoist")
	public ResponseEntity<Account> depoist(@RequestBody DepoistWithdrawRequest request,Principal principal)
	{
		accountService.deposit(request.getAccountNumber(), request.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@PostMapping(path="withdraw")
	public ResponseEntity<Account> withdraw(@RequestBody DepoistWithdrawRequest request,Principal principal)
	{
		accountService.withdraw(request.getAccountNumber(), request.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@PostMapping(path="transfer")
	public ResponseEntity<Account> transfer(@RequestBody TransactionalRequest request,Principal principal)
	{
		accountService.transfer(request.getFromAccount(), request.getToAccount(), request.getAmount());
		return new ResponseEntity<Account>(HttpStatus.OK);
	}

	@GetMapping(path="alltransaction",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionLog>getAllTransaction(){
		return tnxService.getAllTransaction();
		
	}
	
	@GetMapping(path="alltransaction/{fromAccount}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>>getAllTransactionById(
			@PathVariable(name="fromAccount")Long fromAccount){
		
		return new ResponseEntity<List<TransactionLog>>(tnxService.findByfromAccount(fromAccount),HttpStatus.OK);
		
	}
}



