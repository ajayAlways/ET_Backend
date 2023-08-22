package com.backend.expense_tracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.expense_tracker.model.Expense;
import com.backend.expense_tracker.repository.ExpenseRepository;

@Service
public class ExpenseService {
    private static ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        ExpenseService.expenseRepository = expenseRepository;
    }

    // get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // get expense by id
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // get expense by category
    public List<Expense> getExpenseByCategory(String category) {
        return expenseRepository.findByExpenseCategory(category);
    }

    // get expense by date
    public List<Expense> getExpenseByDate(LocalDate date) {
        return expenseRepository.findByExpenseDate(date);
    }

    // add expense
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    
    // update expense by id
    public Expense updateExpenseById(Long id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        if(existingExpense == null) return null;
        existingExpense.setExpenseTitle(expense.getExpenseTitle());
        existingExpense.setExpenseDescription(expense.getExpenseDescription());
        existingExpense.setExpenseDate(expense.getExpenseDate());
        existingExpense.setExpenseAmount(expense.getExpenseAmount());
        existingExpense.setExpenseCategory(expense.getExpenseCategory());
        return expenseRepository.save(existingExpense);
    }

    // delete expense by id
    public String deleteExpenseById(Long id) {
        if(expenseRepository.findById(id).orElse(null) == null) return "Expense not found";
        expenseRepository.deleteById(id);
        return "Expense deleted successfully";
    }

}
