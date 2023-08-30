package com.backend.expense_tracker.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.expense_tracker.service.ExpenseService;

import com.backend.expense_tracker.model.Expense;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/expense")
public class ExpenseController {
    @Autowired
    private static ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        ExpenseController.expenseService = expenseService;
    }

    // get all expenses
    @GetMapping("/all")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // get expense by id
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // get expenses by category
    @GetMapping("/category/{category}")
    public List<Expense> getExpenseByCategory(@PathVariable String category) {
        return expenseService.getExpenseByCategory(category);
    }

    // get expenses by date
    @GetMapping("/date/{date}")
    public List<Expense> getExpenseByDate(@PathVariable LocalDate date) {
        return expenseService.getExpenseByDate(date);
    }

    // add expense
    @PostMapping("/add")
    public Expense addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    // update expense by id
    @PutMapping("/update/{id}")
    public Expense updateExpenseById(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpenseById(id, expense);
    }

    // delete expense by id
    @DeleteMapping("/delete/{id}")
    public String deleteExpenseById(@PathVariable Long id) {
        return expenseService.deleteExpenseById(id);
    }

}
