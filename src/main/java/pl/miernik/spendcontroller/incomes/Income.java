package pl.miernik.spendcontroller.incomes;

import lombok.*;
import pl.miernik.spendcontroller.categories.CategoryIncome;
import pl.miernik.spendcontroller.users.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
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

@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "category_income")
    private CategoryIncome categoryIncome;

    @Column(length = 128, nullable = false)
    private String comment;

    @ManyToOne
    private User user;




}