package com.anvil.rakoi.anvil.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.anvil.rakoi.anvil.entities.Expense;

public interface ExpenseRepository  extends PagingAndSortingRepository<Expense ,Integer>{
	
}

