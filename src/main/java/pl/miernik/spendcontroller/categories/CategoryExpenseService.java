package pl.miernik.spendcontroller.categories;
import java.util.List;
public interface CategoryExpenseService {

    List<CategoryExpense> finaAllCategoriesExp();
    void saveCategoryExpense(CategoryExpense categoryExpense);
    CategoryExpense getCategoryExpenseById( long id);
    void deleteCategoryExpense(long id);
}
