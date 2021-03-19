package pl.miernik.spendcontroller.incomes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

//    @Transactional
//    @Query(value = "SELECT incomes.id, category_income.name, sum(incomes.amount)\n" +
//            "FROM category_income, incomes\n" +
//            "WHERE incomes.category_income = category_income.id\n" +
//            "GROUP BY category_income.name, incomes.id",
//            nativeQuery = true)
//    List<Income> displayIncomeSumPerCategory();
}