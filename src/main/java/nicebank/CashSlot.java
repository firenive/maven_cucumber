package nicebank;

import java.math.BigDecimal;

public class CashSlot {
    private BigDecimal contents;

    public BigDecimal getContents() {
        return contents;
    }

    public CashSlot() {
        this.contents = BigDecimal.ZERO;
    }

    public void dispense(BigDecimal dollars) {
        this.contents = dollars;
    }
}
