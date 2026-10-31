package steps.part2;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.When;
import nicebank.Teller;
import support.AtmUserInterface;
import support.TestAccount;

import java.math.BigDecimal;
@ScenarioScoped
public class TellerSteps {
    Teller teller;
    TestAccount account;
    @Inject
    public TellerSteps(AtmUserInterface teller, TestAccount account) {
       this.teller = teller;
       this.account = account;
    }
    @When("I withdraw ${bigdecimal}")
    public void iWithdraw$(BigDecimal amount) {
        teller.withdrawFrom(account.getAccount(), amount);
    }
}
