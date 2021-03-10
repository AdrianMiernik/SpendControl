package pl.miernik.spendcontroller.incomes;

import lombok.*;
import pl.miernik.spendcontroller.categories.CategoryIncome;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal amount;

    private String date;

    @ManyToOne
    @JoinColumn(name = "categoryIncome_id")
    private CategoryIncome categoryIncome;

    @Column(length = 128, nullable = false)
    private String comment;


}