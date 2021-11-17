package com.anvil.rakoi.anvil.services;

import com.anvil.rakoi.anvil.entities.Expenses;
import com.anvil.rakoi.anvil.repos.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExpensesImpl  implements ExpensesInterface{
    @Autowired
    ExpensesRepository expensesRepository;
    @Override
    public Page<Expenses> getExpenseByTrip(String tripId, Pageable pageable) {
        return expensesRepository.findByTrip(tripId,pageable);
    }

    @Override
    public Page<Expenses> getExpeseByExpense(String expensesId, Pageable pageable) {
        return expensesRepository.findExpensesByExpense(expensesId,pageable);
    }

    @Override
    public Page<Expenses> getAllExpenses(Pageable pageable) {
        return expensesRepository.findAll(pageable);
    }

    @Override
    public void DeleteExpense(Expenses expense) {
        expensesRepository.delete(expense);
    }

    @Override
    public void UpdateExpense(Expenses expenses) {
        expensesRepository.save(expenses);
    }

    @Override
    public Expenses createExpense(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public void deleteExpense(Integer expenseId){
        expensesRepository.deleteById(expenseId);
    }
    public Expenses getExpenseById(int id){
        return expensesRepository.findById(id).get();
    }
}
