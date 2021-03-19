package pl.miernik.spendcontroller.incomes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@Repository
public class IncomeRepositoryDao  {
    @Autowired
    private EntityManager entityManager;
    public List<IncomeTest> getDisplayIncomeSumPerCategory0() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT category_income.name as name, sum(incomes.amount) as amount FROM category_income, incomes WHERE incomes.category_income = category_income.id GROUP BY category_income.name","income_test_result" );
        List<IncomeTest> resultList = nativeQuery.getResultList();
        return resultList;
    }
}