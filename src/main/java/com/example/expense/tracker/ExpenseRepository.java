package com.example.expense.tracker;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	List<Expense> findByCategory(String category);

	List<Expense> findByDateBetween(LocalDate start, LocalDate end);

	@Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.date BETWEEN :start AND :end")
	double sumByDateBetween(LocalDate start, LocalDate end);

}
