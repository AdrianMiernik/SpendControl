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
@SqlResultSetMapping(
        name = "income_dto",
        classes = @ConstructorResult(
                targetClass = IncomeDto.class,
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