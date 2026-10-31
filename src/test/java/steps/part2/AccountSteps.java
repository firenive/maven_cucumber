package steps.part2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import support.TestAccount;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class AccountSteps {
    private final TestAccount account;
    public AccountSteps(TestAccount account) {
        this.account = account;
    }
    @Given("my account has been credited with ${bigdecimal}")
    public void myAccountHasBeenCreditedWith$(BigDecimal amount) {
        account.getAccount().credit(amount);
    }


    @And("the balance of my account should be ${bigdecimal}")
    public void theBalanceOfMyAccountShouldBe$(BigDecimal amount) throws InterruptedException {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;
        while (!account.getAccount().getBalance().equals(amount) && timeoutMilliSecs > 0) {
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -=pollIntervalMilliSecs;
        }
        Assertions.assertEquals(amount, account.getAccount().getBalance(),
                "Incorrect account balance");

    }
}
