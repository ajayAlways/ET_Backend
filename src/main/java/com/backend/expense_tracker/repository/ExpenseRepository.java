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

    // get this month expenses
    @Query(value = "SELECT * FROM expense e WHERE MONTH(e.expense_date) = MONTH(CURRENT_DATE()) AND YEAR(e.expense_date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    List<Expense> findThisMonthExpenses();

    // get last 3 months expenses
    @Query(value = "SELECT * FROM expense e WHERE MONTH(e.expense_date) >= MONTH(CURRENT_DATE()) - 3 AND YEAR(e.expense_date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    List<Expense> findLast3MonthsExpenses();

    // get last 6 months expenses
    @Query(value = "SELECT * FROM expense e WHERE MONTH(e.expense_date) >= MONTH(CURRENT_DATE()) - 6 AND YEAR(e.expense_date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    List<Expense> findLast6MonthsExpenses();

    // get this year expenses
    @Query(value = "SELECT * FROM expense e WHERE YEAR(e.expense_date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    List<Expense> findThisYearExpenses();

}
