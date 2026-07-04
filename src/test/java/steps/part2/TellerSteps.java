package steps.part2;

import io.cucumber.java.en.When;
import support.KnowsTheDomain;

import java.math.BigDecimal;

public class TellerSteps {
    KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }
    @When("I withdraw ${bigdecimal}")
    public void iWithdraw$(BigDecimal amount) {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), amount);
    }
}
