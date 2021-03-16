package pl.miernik.spendcontroller.balances;

import lombok.Getter;
import lombok.Setter;
import pl.miernik.spendcontroller.expenses.Expense;
import pl.miernik.spendcontroller.incomes.Income;


@Getter
@Setter
public class Balance {

    private Long id;
    private Income income;
    private Expense expense;
}
