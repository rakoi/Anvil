package com.anvil.rakoi.anvil.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anvil.rakoi.anvil.entities.Expense;
import com.anvil.rakoi.anvil.repos.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseServiceInterface {
	
	@Autowired
	ExpenseRepository expenseRespository;

	@Override
	public Page<Expense> getAllExpenses(Pageable pageable) {
		
		return expenseRespository.findAll(pageable);
	}

	@Override
	public Expense getExpense(int id) {
		
		return  expenseRespository.findById(id).get();
	}

	@Override
	public void deleteExpense(int id) {
		expenseRespository.deleteById(id);
		
	}

}
