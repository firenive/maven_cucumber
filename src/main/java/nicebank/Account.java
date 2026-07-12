package nicebank;

import java.math.BigDecimal;

public class Account {
    private BigDecimal balance;

    public void setBalance(BigDecimal amount) {
        this.balance = amount;

    }
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void debit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public Account() {
        this.balance = BigDecimal.ZERO;
    }



    public BigDecimal getBalance() {
        return balance;
    }

    public boolean hasSufficientFunds(BigDecimal amount) {
        return balance.compareTo(amount) >= 0;
    }
}
