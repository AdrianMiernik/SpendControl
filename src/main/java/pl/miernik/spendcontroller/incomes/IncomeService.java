package pl.miernik.spendcontroller.incomes;

import java.util.List;

public interface IncomeService {

    List<Income> findAllIncomes();

    void saveIncome(Income income);
    Income getIncomeById(long id);
    void deleteIncomeById(long id);

    // DTO methods
//    List<IncomeDto> findIncomeSumPerCategory();
}
