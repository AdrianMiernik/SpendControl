package pl.miernik.spendcontroller.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("settings/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private final PaymentMethodService paymentMethodService;

    @GetMapping("")
    public String displayPaymentMethodList(Model model){
        model.addAttribute("paymentMethods", paymentMethodService.findAllMethods());
        return ("payment/list-payment-method");
    }
}
