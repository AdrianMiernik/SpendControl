package pl.miernik.spendcontroller.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("settings/categoryIncome")
@RequiredArgsConstructor
public class CategoryIncomeController {

    @Autowired
    private final CategoryIncomeService categoryIncomeService;

    @GetMapping("")
    public String findAllIncomeCategories(Model model) {
       model.addAttribute("categoryList",categoryIncomeService.findAllCategories());
       return ("category/list-income-category");
    }
}
