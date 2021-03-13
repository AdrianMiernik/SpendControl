package pl.miernik.spendcontroller.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService{
    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> findAllMethods() {
        return paymentMethodRepository.findAll();
    }
}
