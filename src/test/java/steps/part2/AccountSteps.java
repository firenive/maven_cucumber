package steps.part2;

import io.cucumber.java.en.Given;
import nicebank.support.KnowsTheDomain;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class AccountSteps {
    KnowsTheDomain helper;
    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }
    @Given("I have deposited ${bigdecimal} in my account")
    public void iHaveDeposited$InMyAccount(BigDecimal amount) {
        helper.getMyAccount().deposit(amount);
        Assertions.assertEquals(amount, helper.getMyAccount().getBalance(),
                "Incorrect account balance - ");
    }


}
