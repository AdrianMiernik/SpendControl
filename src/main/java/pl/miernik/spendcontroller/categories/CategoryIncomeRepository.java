package pl.miernik.spendcontroller.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryIncomeRepository extends JpaRepository <CategoryIncome, Long> {

}
