package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	public List<Transaction> findAll() {

		List<Transaction> retailTransactions = transactionRepo.findAll();;

		Collections.sort(retailTransactions, (retailTransactions1, retailTransactions2) -> retailTransactions1.getDate()
				.compareTo(retailTransactions2.getDate()));

//		List<Transaction> sortedRetailer = retailTransactions.stream().collect(Collectors.toList();
//
//		return sortedRetailer;
		return retailTransactions;
	}

	public Transaction findById(Long transactionId) {

		Optional<Transaction> getTransactionsbyId = transactionRepo.findAll().stream()
				.filter(o -> o.getId().equals(transactionId)).findAny();

		return getTransactionsbyId.orElse(new Transaction());

	}

}
