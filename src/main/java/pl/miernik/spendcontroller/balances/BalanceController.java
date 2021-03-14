package pl.miernik.spendcontroller.balances;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.miernik.spendcontroller.categories.CategoryExpenseService;
import pl.miernik.spendcontroller.categories.CategoryIncomeService;
import pl.miernik.spendcontroller.expenses.ExpenseService;
import pl.miernik.spendcontroller.incomes.IncomeService;
import pl.miernik.spendcontroller.payments.PaymentMethodService;

@Controller
@RequestMapping("/balance")
public class Balance {

    @Autowired
    private IncomeService incomeService;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private CategoryIncomeService categoryIncomeService;
    @Autowired
    private CategoryExpenseService categoryExpenseService;
    @Autowired
    private PaymentMethodService paymentMethodService;
    @Autowired
    private ModelMapper modelMapper;






}
