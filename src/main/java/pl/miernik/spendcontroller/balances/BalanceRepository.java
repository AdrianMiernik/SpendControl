package pl.miernik.spendcontroller.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.miernik.spendcontroller.expenses.ExpenseDto;
import pl.miernik.spendcontroller.incomes.IncomeDto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Controller
public class BalanceRepository {

    @Autowired
    private EntityManager entityManager;


    public List<ExpenseDto> displaySumPerCategoryExpense() {
        Query nativeQuery = entityManager.createNativeQuery(
                "SELECT category_expense.name as name, sum(expenses.amount) as amount " +
                        "FROM category_expense, expenses WHERE expenses.category_expense_id = category_expense.id " +
                        "GROUP BY category_expense.name", "expense_dto");
        List<ExpenseDto> resultList = nativeQuery.getResultList();
        return resultList;
    }


    public List<IncomeDto> displaySumPerCategoryIncome() {
        Query nativeQuery = entityManager.createNativeQuery(
                "SELECT category_income.name as name, sum(incomes.amount) as amount " +
                        "FROM category_income, incomes WHERE incomes.category_income = category_income.id " +
                        "GROUP BY category_income.name", "income_dto");
        List<IncomeDto> resultList = nativeQuery.getResultList();
        return resultList;
    }
}
