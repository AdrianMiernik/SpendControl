package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryIncomeServiceImpl implements CategoryIncomeService {

    @Autowired
    private final CategoryIncomeRepository categoryIncomeRepository;

    @Override
    public List<CategoryIncome> findAllCategories() {
        return categoryIncomeRepository.findAll();
    }

    @Override
    public void saveCategoryIncome(CategoryIncome categoryIncome) {
    categoryIncomeRepository.save(categoryIncome);
    }

    @Override
    public CategoryIncome getCategoryIncomeById(long id) {
        Optional<CategoryIncome> optional = categoryIncomeRepository.findById(id);
        CategoryIncome categoryIncome = null;
        if(optional.isPresent()){
            categoryIncome = optional.get();
        } else{
            System.out.println("Optional not found for this id: " +  id);
        }
        return categoryIncome;
    }

    @Override
    public void deleteCategoryIncome(long id) {
    categoryIncomeRepository.deleteById(id);
    }
}
