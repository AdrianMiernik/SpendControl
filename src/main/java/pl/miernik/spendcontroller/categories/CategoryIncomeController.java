package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/settings/categoryIncome")
@RequiredArgsConstructor
public class CategoryIncomeController {


    private final CategoryIncomeService categoryIncomeService;

    @GetMapping("")
    public String findAllIncomeCategories(Model model) {
       model.addAttribute("categoryList",categoryIncomeService.findAllCategories());
       return ("category/ic-list");
    }

    @GetMapping("/add")
    public String addFormCategoryIncome(Model model){
        model.addAttribute("categoryIncome",new CategoryIncome());
        return ("category/ic-form");
    }
    @PostMapping("/add")
    public String addFormIncomeCategoryPost(@Valid CategoryIncome categoryIncome, BindingResult validations) {
        if (validations.hasErrors()) {
            return ("category/ic-form");
        }
        categoryIncomeService.saveCategoryIncome(categoryIncome);
        return ("redirect:/settings/categoryIncome");
    }
    @GetMapping("/update/{id}")
    public String updateCategoryIncome(@PathVariable long id, Model model){
        CategoryIncome category = categoryIncomeService.getCategoryIncomeById(id);
        model.addAttribute("categoryIncome", category);
        return ("category/ic-update");
    }
    @PostMapping("/update")
    public String updateFormIncomeCategory(@Valid CategoryIncome categoryIncome, BindingResult validations) {
        if (validations.hasErrors()) {
            return ("category/ic-form");
        }
        categoryIncomeService.saveCategoryIncome(categoryIncome);
        return ("redirect:/settings/categoryIncome");
    }
    @GetMapping("/delete/{id}")
    public String deleteIncomeCategory(@PathVariable long id){
        this.categoryIncomeService.deleteCategoryIncome(id);
        return ("redirect:/settings/categoryIncome");
    }
}
