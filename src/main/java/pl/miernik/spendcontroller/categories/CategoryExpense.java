package pl.miernik.spendcontroller.categories;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
@Table
public class CategoryExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "This field cannot be blank.")
    @Size(min = 4, max = 25, message = "Minimum size {min} characters, maximum {max} characters.")
    private String name;
}
