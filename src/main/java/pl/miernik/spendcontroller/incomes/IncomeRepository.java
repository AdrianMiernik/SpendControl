package pl.miernik.spendcontroller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.miernik.spendcontroller.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {


}