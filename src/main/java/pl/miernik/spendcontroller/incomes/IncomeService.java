package pl.miernik.spendcontroller.incomes;

import java.util.List;

public interface IncomeService {

    List<Income> findAllIncomes();
//    List<Income> findAllSumPerCategory();
    void saveIncome(Income income);
    Income getIncomeById(long id);
    void deleteIncomeById(long id);
//    List<Income> readByCategory(CategoryIncome category);
}
