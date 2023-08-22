package com.backend.expense_tracker.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.expense_tracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
    // get expense by category
    @Query(value = "SELECT * FROM expense e WHERE e.expense_category = ?1", nativeQuery = true)
    List<Expense> findByExpenseCategory(String category);

    // get expense by date
    @Query(value = "SELECT * FROM expense e WHERE e.expense_date = ?1", nativeQuery = true)
    List<Expense> findByExpenseDate(LocalDate date);
}
