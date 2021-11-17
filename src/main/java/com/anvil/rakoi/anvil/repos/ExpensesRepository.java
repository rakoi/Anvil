package com.anvil.rakoi.anvil.repos;

import com.anvil.rakoi.anvil.entities.Expenses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository  extends PagingAndSortingRepository<Expenses,Integer> {

    @Query( value = "SELECT * FROM expenses e WHERE e.trip_id = ?",nativeQuery = true)
    Page<Expenses> findByTrip(String trip_id, Pageable pageable);
    @Query( value = "SELECT * FROM expenses e WHERE e.expense_id = ?",nativeQuery = true)
    Page <Expenses> findExpensesByExpense(String expenseId,Pageable pageable);
}
