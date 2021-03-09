package pl.miernik.spendcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.miernik.spendcontroller.model.Income;

import pl.miernik.spendcontroller.repository.IncomeRepository;

import java.util.Optional;

@Controller
@RequestMapping("/income")
public class IncomeController {
    private final IncomeRepository incomeRepository;


    @Autowired
    public IncomeController(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;

    }

    //Displaying list of incomes
    @GetMapping("")
    public String displayIncomeList(Model model) {
        model.addAttribute("incomeList", incomeRepository.findAll());
        return ("income/i-list");
    }

    //Adding new income
    @GetMapping("/add")
    public String addFormIncome(Model model) {
        model.addAttribute("income", new Income());
        return ("income/i-form");
    }
    @PostMapping("/add")
    public String addFormIncomePost(@ModelAttribute Income income) {
        this.incomeRepository.save(income);
        return ("redirect:/income");
    }

    //Upading income
    @GetMapping("/update/{id}")
    public String updateFormIncome(@PathVariable long id, Model model) {
        Optional<Income> income = incomeRepository.findById(id);
        model.addAttribute("income", income);
        return "income/i-update";
    }

    @PostMapping("/update")
    public String updateFormIncomePost(@ModelAttribute Income income) {
        this.incomeRepository.save(income);
        return ("redirect:/income");
    }

    //Deleting income
    @GetMapping("/delete/{id}")
    public String deleteIncome(@PathVariable long id) {
        this.incomeRepository.deleteById(id);
        return ("redirect:/income");
    }

//    @GetMapping("/get/{id}")
//    public Income getIncomeById(@PathVariable long id) {
//        return this.incomeRepository.findById(id).orElseThrow(() -> {
//            throw new RuntimeException("Income not found by id :: " + id);
//        });
//    }

}