package pl.miernik.spendcontroller.payments;
import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> findAllMethods();
    void savePaymentMethod(PaymentMethod paymentMethod);
    PaymentMethod getPaymentMethodById(long id);
    void deletePaymentMethod(long id);
}
