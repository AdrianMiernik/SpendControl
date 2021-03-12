package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryExpenseServiceImpl implements CategoryExpenseService {

    @Autowired
    private CategoryExpenseRepository categoryExpenseRepository;

    @Override
    public List<CategoryExpense> finaAllCategoriesExp() {
       return this.categoryExpenseRepository.findAll();
    }

    @Override
    public void saveCategoryExpense(CategoryExpense categoryExpense) {
    categoryExpenseRepository.save(categoryExpense);
    }

    @Override
    public CategoryExpense getCategoryExpenseById(long id) {
        Optional<CategoryExpense> optional = categoryExpenseRepository.findById(id);
        CategoryExpense categoryExpense = null;
        if(optional.isPresent()){
            categoryExpense = optional.get();
        } else{
            System.out.println("Category not found for id: " + id);
        }
        return categoryExpense;
    }

    @Override
    public void deleteCategoryExpense(long id) {
    categoryExpenseRepository.deleteById(id);
    }

}
