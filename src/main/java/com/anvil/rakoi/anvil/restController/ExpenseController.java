package com.anvil.rakoi.anvil.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anvil.rakoi.anvil.entities.Expense;
import com.anvil.rakoi.anvil.services.ExpenseServiceImpl;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
	
	@Autowired
	ExpenseServiceImpl expenseService;

	
	@GetMapping("/all")
	Page<Expense> getAllExpenses(Pageable pageable){
			return expenseService.getAllExpenses(pageable);
	}
	@GetMapping("/getExpense/{id}")
	Expense getExpense(@PathVariable int id) {
		return expenseService.getExpense(id);
	}
	@GetMapping("/deleteExpense/{id}")
	ResponseEntity<?> deleteExpense(@PathVariable int id) {
		expenseService.deleteExpense(id);
		
		return ResponseEntity.ok("success");
	}
	
	
}
