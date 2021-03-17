package pl.miernik.spendcontroller.incomes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

// working but not aggregating data



//    @Query(name = "income_test_result", nativeQuery = true)
//    List<IncomeTest> displayIncomeSumPerCategory0();

    @Query("SELECT DISTINCT c.name, Sum(i.amount) FROM CategoryIncome c, Income i WHERE i.categoryIncome = c.id GROUP BY c.name")
    List<Income> displayIncomeSumPerCategory0();


    @Query(value = "SELECT category_income.name, sum(incomes.amount)\n" +
            "FROM category_income, incomes\n" +
            "WHERE incomes.category_income = category_income.id\n" +
            "GROUP BY category_income.name",
            nativeQuery = true)
    List<Income> displayIncomeSumPerCategory1();

    @Transactional
    @Query(value = "SELECT incomes.id, category_income.name, sum(incomes.amount)\n" +
            "FROM category_income, incomes\n" +
            "WHERE incomes.category_income = category_income.id\n" +
            "GROUP BY category_income.name",
            nativeQuery = true)
    List<Income> displayIncomeSumPerCategory2();

    @Transactional
    @Query(value = "SELECT incomes.id, category_income.name, sum(incomes.amount)\n" +
            "FROM category_income, incomes\n" +
            "WHERE incomes.category_income = category_income.id\n" +
            "GROUP BY category_income.name, incomes.id",
            nativeQuery = true)
    List<Income> displayIncomeSumPerCategory3();

    @Transactional
    @Query(value = "SELECT sum(incomes.amount) as total, category_income.name\n" +
            "FROM incomes\n" +
            "left join category_income on incomes.category_income = category_income.id\n" +
            "GROUP BY category_income.name;",
            nativeQuery = true)
    List<Income> displayIncomeSumPerCategory4();
}