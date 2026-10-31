package steps.part2;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import nicebank.CashSlot;
import org.junit.jupiter.api.Assertions;
import support.TestCashSlot;

import java.math.BigDecimal;
@ScenarioScoped
public class CashSlotSteps {
    CashSlot cashSlot;
    @Inject
    public CashSlotSteps(TestCashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Then("${bigdecimal} should be dispensed")
    public void $ShouldBeDispensed(BigDecimal amount) {
        Assertions.assertEquals(amount, cashSlot.getContents(), "Incorrect amount dispensed");
    }

}
