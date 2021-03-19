package pl.miernik.spendcontroller.expenses;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miernik.spendcontroller.categories.CategoryExpense;
import pl.miernik.spendcontroller.categories.CategoryExpenseService;
import pl.miernik.spendcontroller.payments.PaymentMethod;
import pl.miernik.spendcontroller.payments.PaymentMethodService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final CategoryExpenseService categoryExpenseService;
    private final PaymentMethodService paymentMethodService;

    //Displaying list of expenses
    @GetMapping("")
    public String displayExpenseList(Model model){
        model.addAttribute("expenseList",expenseService.findAllExpenses());
        return ("expense/e-list");
    }

    //Adding new expense
    @GetMapping("/add")
    public String addFormExpense(Model model){
        model.addAttribute("expense", new Expense());
        return ("expense/e-form");
    }
    @PostMapping("/add")
    public String addFormExpensePost(@Valid Expense expense, BindingResult validations){
        if(validations.hasErrors()){
            return ("expense/e-form");
        }
        expenseService.saveExpense(expense);
        return ("redirect:/expense");
    }

    //Updating expense
    @GetMapping("/update/{id}")
    public String updateFormExpense(@PathVariable long id, Model model){
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return ("expense/e-update");
    }
    @PostMapping("/update")
    public String updateFormExpensePost(@Valid Expense expense, BindingResult validations){
        if(validations.hasErrors()){
            return ("expense/e-update");
        }
        expenseService.saveExpense(expense);
        return ("redirect:/expense");
    }

    //Deleting expense
    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable long id){
        this.expenseService.deleteExpense(id);
        return ("redirect:/expense");
    }

    @ModelAttribute("categories")
       private List<CategoryExpense> categories(){
           return categoryExpenseService.finaAllCategoriesExp();
        }

    @ModelAttribute("paymentMethods")
    private List<PaymentMethod> paymentMethods(){
        return paymentMethodService.findAllMethods();
    }


}
