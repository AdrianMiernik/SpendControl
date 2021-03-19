package pl.miernik.spendcontroller.balances;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.miernik.spendcontroller.expenses.ExpenseService;
import pl.miernik.spendcontroller.incomes.IncomeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/balance")
public class BalanceController {
    private final IncomeService incomeService;
    private final ExpenseService expenseService;
    private final BalanceRepository balanceRepository;

    @GetMapping("")
    public String displayBalance(Model model) {
        model.addAttribute("incomeList", incomeService.findAllIncomes());
        model.addAttribute("expenseList", expenseService.findAllExpenses());
        model.addAttribute("timeOptions", populateTimeOptions());
        model.addAttribute("incomeSum", balanceRepository.displaySumPerCategoryIncome());
        model.addAttribute("expenseSum", balanceRepository.displaySumPerCategoryExpense());
        return ("balance/b-list");
    }

    @ModelAttribute(name = "timeOptions")
    public List<String> populateTimeOptions() {
        List<String> timeOptions = new ArrayList<String>();
        timeOptions.add("Current Month");
        timeOptions.add("Previous Month");
        timeOptions.add("Last Year");
        timeOptions.add("Custom Period");
        return timeOptions;
    }


}









