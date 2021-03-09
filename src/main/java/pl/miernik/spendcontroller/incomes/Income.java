
package pl.miernik.spendcontroller.model;

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


    //@ManyToOne(fetch = FetchType.EAGER)
    //@ManyToOne
    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryIncome categoryIncome;


    private String comment;


}