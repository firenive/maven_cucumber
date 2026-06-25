package nicebank;

import java.math.BigDecimal;

public class Teller {
    private CashSlot cashSlot;
    public Teller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;

    }

    public void withdrawFrom(Account account, BigDecimal dollars) {
        cashSlot.dispense(dollars);

    }
}
