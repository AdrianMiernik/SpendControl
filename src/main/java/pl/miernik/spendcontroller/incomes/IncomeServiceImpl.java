package pl.miernik.spendcontroller.incomes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public List<Income> findAllIncomes() {
       return incomeRepository.findAll();
    }

    @Override
    public void saveIncome(Income income) {
    this.incomeRepository.save(income);
    }

    @Override
    public Income getIncomeById(long id) {
        Optional<Income> optional = incomeRepository.findById(id);
        Income income = null;
        if(optional.isPresent()){
            income = optional.get();
        } else{
            throw new RuntimeException("Income not found for id: " +id);
        }
        return income;
    }

    @Override
    public void deleteIncomeById(long id) {
    this.incomeRepository.deleteById(id);
    }


}
