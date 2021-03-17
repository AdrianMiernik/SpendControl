package pl.miernik.spendcontroller.incomes;


import lombok.*;

import java.math.BigDecimal;

@Value
public class IncomeTest {
    private BigDecimal amount;
    private String name;
}
