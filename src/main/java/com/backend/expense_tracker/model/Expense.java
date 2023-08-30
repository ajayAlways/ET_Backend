package com.backend.expense_tracker.model;

import java.time.LocalDate;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

@Entity
@Table
public class Expense {
    @TableGenerator(name = "expense_id_generator",
            table = "expense_id_generator",
            pkColumnName = "expense_id",
            valueColumnName = "expense_value",
            allocationSize = 1,
            initialValue = 20)
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.TABLE, generator = "expense_id_generator")
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
