package steps.part2;

import io.cucumber.java.en.When;
import nicebank.Teller;
import support.AtmUserInterface;
import support.TestAccount;

import java.math.BigDecimal;

public class TellerSteps {
    Teller teller;
    TestAccount account;

    public TellerSteps(AtmUserInterface teller, TestAccount account) {
       this.teller = teller;
       this.account = account;
    }
    @When("I withdraw ${bigdecimal}")
    public void iWithdraw$(BigDecimal amount) {
        teller.withdrawFrom(account.getAccount(), amount);
    }
}
