package steps.part2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import support.KnowsTheDomain;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class AccountSteps {
    KnowsTheDomain helper;
    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }
    @Given("my account has been credited with ${bigdecimal}")
    public void myAccountHasBeenCreditedWith$(BigDecimal amount) {
        helper.getMyAccount().credit(amount);
    }


    @And("the balance of my account should be ${bigdecimal}")
    public void theBalanceOfMyAccountShouldBe$(BigDecimal amount) throws InterruptedException {
        int timeoutMilliSecs = 3000;
        int pollIntervalMilliSecs = 100;
        while (!helper.getMyAccount().getBalance().equals(amount) && timeoutMilliSecs > 0) {
            Thread.sleep(pollIntervalMilliSecs);
            timeoutMilliSecs -=pollIntervalMilliSecs;
        }
        Assertions.assertEquals(amount, helper.getMyAccount().getBalance(),
                "Incorrect account balance");

    }
}
