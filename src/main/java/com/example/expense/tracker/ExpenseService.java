package com.example.expense.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Expense addExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
	
	public List<Expense> getExpensesByCategory(String category) {
		return expenseRepository.findByCategory(category);
	}
	
	public List<Expense> getExpensesInDateRange(LocalDate start, LocalDate end) {
		return expenseRepository.findByDateBetween(start, end);
	}
	
	public double getTotalExpensesForMonth(int year, int month) {
		LocalDate start = YearMonth.of(year, month).atDay(1);
		LocalDate end = YearMonth.of(year, month).atEndOfMonth();
		return expenseRepository.sumByDateBetween(start, end);
	}

}
