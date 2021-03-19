package pl.miernik.spendcontroller.expenses;

import lombok.*;
import pl.miernik.spendcontroller.categories.CategoryExpense;
import pl.miernik.spendcontroller.payments.PaymentMethod;
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

    private BigDecimal amount;


    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "categoryExpense_id")

    private CategoryExpense categoryExpense;

    @Column(length = 128, nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    private User user;


}