package pl.miernik.spendcontroller.categories;
import java.util.List;
public interface CategoryIncomeService {

    List <CategoryIncome> findAllCategories();
    void saveCategoryIncome(CategoryIncome categoryIncome);
    CategoryIncome getCategoryIncomeById(long id);
    void deleteCategoryIncome(long id);
}
