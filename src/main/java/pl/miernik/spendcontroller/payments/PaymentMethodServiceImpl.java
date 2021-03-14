package pl.miernik.spendcontroller.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService{

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public List<PaymentMethod> findAllMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public void savePaymentMethod(PaymentMethod paymentMethod) {
    paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod getPaymentMethodById(long id) {
       Optional<PaymentMethod> optional = paymentMethodRepository.findById(id);
       PaymentMethod paymentMethod = null;
       if(optional.isPresent()){
           paymentMethod = optional.get();
       } else {
           System.out.printf("Optional not found for id: " + id);
       }
        return paymentMethod;
    }

    @Override
    public void deletePaymentMethod(long id) {
    paymentMethodRepository.deleteById(id);
    }
}
