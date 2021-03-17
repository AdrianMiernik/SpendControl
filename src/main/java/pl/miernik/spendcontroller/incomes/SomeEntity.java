package pl.miernik.spendcontroller.incomes;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedNativeQuery(
        name = "income_test_source",
        query = "SELECT category_income.name as name, sum(incomes.amount) as amount FROM category_income, incomes WHERE incomes.category_income = category_income.id GROUP BY category_income.name",
        resultSetMapping = "income_test_result"
)
@SqlResultSetMapping(
        name = "income_test_result",
        classes = @ConstructorResult(
                targetClass = IncomeTest.class,
                columns = {
                        @ColumnResult(name = "amount", type = BigDecimal.class),
                        @ColumnResult(name = "name", type = String.class),
                }
        )
)
public class SomeEntity {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
