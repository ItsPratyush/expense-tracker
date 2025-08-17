package com.example.expense.tracker;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@PostMapping
	public Expense addExpense(@RequestBody Expense expense) {
		return expenseService.addExpense(expense);
	}
	
	@GetMapping
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/{id}")
	public Expense getExpenseById(@PathVariable Long id) {
		return expenseRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/category/{category}")
	public List<Expense> getExpenseByCategory(@PathVariable String category) {
		return expenseService.getExpensesByCategory(category);
	}
	
	@GetMapping("/filter")
	public List<Expense> getExpenseInDateRange(@RequestParam LocalDate start,
			@RequestParam LocalDate end) {
		return expenseService.getExpensesInDateRange(start, end);
	}
	
	@GetMapping("/total")
	public double getTotalExpensesForMonth(@RequestParam int year, @RequestParam int month) {
		return expenseService.getTotalExpensesForMonth(year, month);
	}
	
	@DeleteMapping("/{id}")
	public void deleteExpense(@PathVariable Long id) {
		expenseRepository.deleteById(id);
	}

}
