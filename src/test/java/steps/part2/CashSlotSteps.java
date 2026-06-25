package steps.part2;

import io.cucumber.java.en.Then;
import nicebank.support.KnowsTheDomain;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class CashSlotSteps {
    KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("${bigdecimal} should be dispensed")
    public void $ShouldBeDispensed(BigDecimal amount) {
        Assertions.assertEquals(amount, helper.getCashSlot().getContents(), "Incorrect amount dispensed");
    }

}
