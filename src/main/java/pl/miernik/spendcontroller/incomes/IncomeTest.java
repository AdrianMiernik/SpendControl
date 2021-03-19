package pl.miernik.spendcontroller.incomes;
import java.math.BigDecimal;


public class IncomeTest {
    private BigDecimal amount;
    private String name;

    public IncomeTest(){}

    public IncomeTest(BigDecimal amount, String name) {
        this.amount = amount;
        this.name = name;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}