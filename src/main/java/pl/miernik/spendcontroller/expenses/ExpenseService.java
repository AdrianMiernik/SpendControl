package pl.miernik.spendcontroller.expenses;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAllExpenses();
    void saveExpense(Expense expense);
    Expense getExpenseById(Long id);
    void deleteExpense(Long id);
}
