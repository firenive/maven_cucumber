package nicebank;

import java.math.BigDecimal;

public interface Teller {
    void withdrawFrom(Account account, BigDecimal dollars);
}
