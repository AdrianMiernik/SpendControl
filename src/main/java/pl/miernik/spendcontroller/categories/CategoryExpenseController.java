package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/settings/categoryExpense")
public class CategoryExpenseController {

    @Autowired
    private final CategoryExpenseService categoryExpenseService;

    @GetMapping("")
    public String displayCategoryExpenseList(Model model) {
        model.addAttribute("categoryList", categoryExpenseService.finaAllCategoriesExp());
        return ("category/ec-list");
    }

    @GetMapping("/add")
    public String addCategoryExpenseForm(Model model) {
        model.addAttribute("categoryExpense", new CategoryExpense());
        return ("category/ec-form");
    }

    @PostMapping("/add")
    public String addCategoryExpenseFormPost(@Valid CategoryExpense categoryExpense, BindingResult validations) {
        if(validations.hasErrors()){
            return ("category/ec-form");
        }
        categoryExpenseService.saveCategoryExpense(categoryExpense);
        return ("redirect:/settings/categoryExpense");
    }

    @GetMapping("/update/{id}")
    public String updateCategoryExpense(@PathVariable long id, Model model) {
        CategoryExpense category = categoryExpenseService.getCategoryExpenseById(id);
        model.addAttribute("categoryExpense", category);
        return ("category/ec-update");
    }
    @PostMapping("/update")
    public String updateCategoryExpensePost(@Valid CategoryExpense categoryExpense, BindingResult validations) {
        if(validations.hasErrors()){
            return ("category/ec-update");
        }
        this.categoryExpenseService.saveCategoryExpense(categoryExpense);
        return ("redirect:/settings/categoryExpense");
    }

    @GetMapping("/delete/{id}")
    public String deleteCategoryExpenseById(@PathVariable long id) {
    this.categoryExpenseService.deleteCategoryExpense(id);
    return ("redirect:/settings/categoryExpense");
    }
}
