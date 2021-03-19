package pl.miernik.spendcontroller.incomes;

import lombok.*;
import pl.miernik.spendcontroller.categories.CategoryIncome;
import pl.miernik.spendcontroller.users.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @NotNull(message = "This field cannot be null.")
    @Min(value = 1, message ="Number must be greater than or equal to {value}." )
    private BigDecimal amount;

    @NotNull(message = "This field cannot be null.")
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "category_income")
    private CategoryIncome categoryIncome;

    @NotBlank(message = "This field cannot be blank.")
    private String comment;

    @ManyToOne
    private User user;

}