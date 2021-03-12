package pl.miernik.spendcontroller.paymentMethods;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
@Table
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    @Column(length = 45, nullable = false, unique = true)
    private String name;
}
