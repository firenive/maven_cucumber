package steps.part2;

import io.cucumber.java.en.Then;
import nicebank.CashSlot;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class CashSlotSteps {
    CashSlot cashSlot;

    public CashSlotSteps(CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Then("${bigdecimal} should be dispensed")
    public void $ShouldBeDispensed(BigDecimal amount) {
        Assertions.assertEquals(amount, cashSlot.getContents(), "Incorrect amount dispensed");
    }

}
