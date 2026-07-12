package nicebank;

import java.math.BigDecimal;

public class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();
    private String message;
    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }

    public void process() {
        do {
             message = queue.read();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!message.isEmpty()) {
                BigDecimal balance = BalanceStore.getBalance();
                BigDecimal transactionAmount = new BigDecimal(message.substring(1));
                if (isCreditTransaction(message)) {
                    BalanceStore.setBalance(balance.add(transactionAmount));
                } else {
                    BalanceStore.setBalance(balance.subtract(transactionAmount));
                }
            }
        } while (true);
    }
}
