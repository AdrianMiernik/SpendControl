package pl.miernik.spendcontroller.users;

import lombok.*;
import pl.miernik.spendcontroller.expenses.Expense;
import pl.miernik.spendcontroller.incomes.Income;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank
    @Column(nullable = false, unique = true)
    @Size(max = 25)
    private String username;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String password;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true)
    private Set<Income> incomes = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true)
    private Set<Expense> expenses = new HashSet<>();

}

