package com.backend.expense_tracker.model;

import java.time.LocalDate;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Expense {
    @Id
    private Long id;
    private String expenseTitle;
    @Nullable
    private String expenseDescription;
    private LocalDate expenseDate;
    private String expenseAmount;
    private String expenseCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(String expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    // Zero argument constructor
    public Expense() {
    }

    // all argument constructor
    public Expense(Long id, String expenseTitle, String expenseDescription, LocalDate expenseDate, String expenseAmount, String expenseCategory) {
        this.id = id;
        this.expenseTitle = expenseTitle;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.expenseCategory = expenseCategory;
    }

    // constructor without id
    public Expense(String expenseTitle, String expenseDescription, LocalDate expenseDate, String expenseAmount, String expenseCategory) {
        this.expenseTitle = expenseTitle;
        this.expenseDescription = expenseDescription;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.expenseCategory = expenseCategory;
    }

    // tostring
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", expenseTitle='" + expenseTitle + '\'' +
                ", expenseDescription='" + expenseDescription + '\'' +
                ", expenseDate='" + expenseDate + '\'' +
                ", expenseAmount='" + expenseAmount + '\'' +
                ", expenseCategory='" + expenseCategory + '\'' +
                '}';
    }

}
