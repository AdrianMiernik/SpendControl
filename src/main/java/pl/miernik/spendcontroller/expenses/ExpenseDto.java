package pl.miernik.spendcontroller.expenses;

import java.math.BigDecimal;

public class ExpenseDto {
    private BigDecimal amount;
    private String name;

    public ExpenseDto() {}
    public ExpenseDto(BigDecimal amount, String name) {
        this.amount = amount;
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ExpenseDto setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExpenseDto setName(String name) {
        this.name = name;
        return this;
    }
}
