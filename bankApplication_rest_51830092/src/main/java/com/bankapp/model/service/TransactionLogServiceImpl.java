package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.TransactionLogRepository;

@Service
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService {
	
	@Autowired
	private TransactionLogRepository tnxRepo;

	@Override
	public List<TransactionLog> getAllTransaction() {
		
		return tnxRepo.findAll();
	}

	@Override
	public List<TransactionLog> findByfromAccount(Long fromAccount) {
		
return tnxRepo.findByfromAccount(fromAccount);	}
	

}
