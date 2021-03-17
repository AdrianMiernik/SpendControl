package pl.miernik.spendcontroller.incomes;


import java.math.BigDecimal;


public class IncomeTest {
    private BigDecimal amount;
    private String name;

    public BigDecimal getAmount() {
        return amount;
    }

    public IncomeTest setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getName() {
        return name;
    }

    public IncomeTest setName(String name) {
        this.name = name;
        return this;
    }
}
