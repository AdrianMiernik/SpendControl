package pl.miernik.spendcontroller.expenses;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void saveExpense(Expense expense) {
    expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> optional = expenseRepository.findById(id);
        Expense expense = null;
        if(optional.isPresent()){
            expense = optional.get();
        } else {
            System.out.println("Expense not found for id: " + id);
        }
        return expense;
    }

    @Override
    public void deleteExpense(Long id) {
    expenseRepository.deleteById(id);
    }
}
