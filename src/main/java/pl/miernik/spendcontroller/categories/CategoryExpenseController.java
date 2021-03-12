package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("settings/categoryExpense")
@RequiredArgsConstructor
public class CategoryExpenseController {

    @Autowired
    private final CategoryExpenseService categoryExpenseService;

    @GetMapping("")
    public String findAllExpenseCategories(Model model) {
       model.addAttribute("categoryList",categoryExpenseService.finaAllCategoriesExp());
       return ("category/list-expense-category");
    }
}
