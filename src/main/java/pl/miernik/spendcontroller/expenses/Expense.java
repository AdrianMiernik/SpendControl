package pl.miernik.spendcontroller.expenses;

import lombok.*;
import pl.miernik.spendcontroller.categories.CategoryExpense;
import pl.miernik.spendcontroller.payments.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private BigDecimal amount;
    private String date;
    @ManyToOne
    @JoinColumn(name = "categoryExpense_id")
    private CategoryExpense categoryExpense;
    @Column(length = 128, nullable = false)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "paymentMethod_id")
    private PaymentMethod paymentMethod;


}