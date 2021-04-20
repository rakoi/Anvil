package com.anvil.rakoi.anvil.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.anvil.rakoi.anvil.entities.Expense;

public interface ExpenseServiceInterface {


	Page<Expense> getAllExpenses(Pageable pageable);
	Expense getExpense(int id);
	void deleteExpense(int id);
}
