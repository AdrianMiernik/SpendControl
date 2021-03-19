package pl.miernik.spendcontroller.expenses;

import lombok.*;
import pl.miernik.spendcontroller.categories.CategoryExpense;
import pl.miernik.spendcontroller.payments.PaymentMethod;
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
@Builder
@ToString
@Entity
@SqlResultSetMapping(
        name = "expense_dto",
        classes = @ConstructorResult(
                targetClass = pl.miernik.spendcontroller.expenses.ExpenseDto.class,
                columns = {
                        @ColumnResult(name = "amount", type = BigDecimal.class),
                        @ColumnResult(name = "name", type = String.class),
                }
        )
)

@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "This field cannot be null.")
    @Min(value = 1, message ="Number must be greater than or equal to {value}." )
    private BigDecimal amount;

    @NotNull(message = "This field cannot be null.")
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "categoryExpense_id")

    private CategoryExpense categoryExpense;

    @NotBlank(message = "This field cannot be blank.")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    private User user;


}