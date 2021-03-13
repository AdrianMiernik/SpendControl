package pl.miernik.spendcontroller.payments;
import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethod> findAllMethods();
}
