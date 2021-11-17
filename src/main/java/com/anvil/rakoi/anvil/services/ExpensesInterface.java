package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Expenses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpensesInterface {
    Page<Expenses> getExpenseByTrip(String tripId, Pageable pageable);
    Page<Expenses> getExpeseByExpense(String expensesId, Pageable pageable);
    Page<Expenses> getAllExpenses(Pageable pageable);
    void DeleteExpense(Expenses expenses);
    void UpdateExpense(Expenses expenses);
    Expenses createExpense(Expenses expenses);
}
