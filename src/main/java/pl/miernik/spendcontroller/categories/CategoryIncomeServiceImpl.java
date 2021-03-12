package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryIncomeServiceImpl implements CategoryIncomeService {

    @Autowired
    private final CategoryIncomeRepository categoryIncomeRepository;

    @Override
    public List<CategoryIncome> findAllCategories() {
        return categoryIncomeRepository.findAll();
    }
}
