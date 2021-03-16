package pl.miernik.spendcontroller.incomes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {


    @Transactional
    @Query(value = "SELECT incomes.id, category_income.name, sum(incomes.amount) from incomes inner join category_income on incomes.category_income = category_income.id group by category_income.name",
            nativeQuery = true)
    List<Income> displayIncomeSumPerCategory();



}