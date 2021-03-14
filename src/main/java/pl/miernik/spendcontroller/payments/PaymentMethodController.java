package pl.miernik.spendcontroller.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/settings/paymentMethod")
public class PaymentMethodController {


    private final PaymentMethodService paymentMethodService;

    @GetMapping("")
    public String displayPaymentMethodList(Model model) {
        model.addAttribute("paymentMethodList", paymentMethodService.findAllMethods());
        return ("payment/pm-list");
    }

    @GetMapping("/add")
    public String addFormPaymentMethod(Model model) {
        model.addAttribute("paymentMethod", new PaymentMethod());
        return ("payment/pm-form");
    }

    @PostMapping("/add")
    public String addFormPaymentMethodPost(@ModelAttribute PaymentMethod paymentMethod) {
        this.paymentMethodService.savePaymentMethod(paymentMethod);
        return ("redirect:/settings/paymentMethod");
    }

    @GetMapping("/update/{id}")
    public String updatePaymentMethod(@PathVariable long id, Model model) {
        PaymentMethod method = paymentMethodService.getPaymentMethodById(id);
        model.addAttribute("paymentMethod", method);
        return ("payment/pm-update");
    }
    @PostMapping("/update")
    public String updatePaymentMethodPost(@ModelAttribute PaymentMethod paymentMethod) {
        this.paymentMethodService.savePaymentMethod(paymentMethod);
        return ("redirect:/settings/paymentMethod");
    }


    @GetMapping("/delete/{id}")
    public String deletePaymentMethodById(@PathVariable long id){
        this.paymentMethodService.deletePaymentMethod(id);
        return ("redirect:/settings/paymentMethod");
    }

}
