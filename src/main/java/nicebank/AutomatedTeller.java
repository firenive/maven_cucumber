package nicebank;

import java.math.BigDecimal;

public class AutomatedTeller implements Teller {
    private CashSlot cashSlot;
    public AutomatedTeller(CashSlot cashSlot) {
        this.cashSlot = cashSlot;

    }

    public void withdrawFrom(Account account, BigDecimal dollars) {
        if (!account.hasSufficientFunds(dollars)) return;
        account.debit(dollars);
        cashSlot.dispense(dollars);

    }
}
