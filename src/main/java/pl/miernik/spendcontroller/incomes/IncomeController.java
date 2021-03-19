package pl.miernik.spendcontroller.incomes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.miernik.spendcontroller.categories.CategoryIncome;
import pl.miernik.spendcontroller.categories.CategoryIncomeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/income")
@RequiredArgsConstructor
public class IncomeController {
    private final IncomeService incomeService;
    private final CategoryIncomeService categoryIncomeService;


    //Displaying list of incomes
    @GetMapping("")
    public String displayIncomeList(Model model) {
        model.addAttribute("incomeList", incomeService.findAllIncomes());
        return ("income/i-list");
    }

    //Adding new income
    @GetMapping("/add")
    public String addFormIncome(Model model) {
        model.addAttribute("income", new Income());
        model.addAttribute("categories",categoryIncomeService.findAllCategories());
        return ("income/i-form");
    }
    @PostMapping("/add")
    public String addFormIncomePost(@Valid Income income, BindingResult violations) {
        if(violations.hasErrors()){
            return "income/i-form";
        }
        this.incomeService.saveIncome(income);
        return ("redirect:/income");
    }

    //Upading income
    @GetMapping("/update/{id}")
    public String updateFormIncome(@PathVariable long id, Model model) {
        Income income = incomeService.getIncomeById(id);
        model.addAttribute("income", income);
        model.addAttribute("categories", categoryIncomeService.findAllCategories());
        return "income/i-update";
    }

    @PostMapping("/update")
    public String updateFormIncomePost(@Valid Income income, BindingResult violations) {
        if(violations.hasErrors()){
            return "income/i-update";
        }
        this.incomeService.saveIncome(income);
        return ("redirect:/income");
    }

    //Deleting income
    @GetMapping("/delete/{id}")
    public String deleteIncome(@PathVariable long id) {
        this.incomeService.deleteIncomeById(id);
        return ("redirect:/income");
    }

    @ModelAttribute("categories")
    private List<CategoryIncome> categories(){
        return categoryIncomeService.findAllCategories();
    }



}