package steps.part2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    public void theBalanceOfMyAccountShouldBe$(BigDecimal amount) {
        Assertions.assertEquals(amount, helper.getMyAccount().getBalance(),
                "Incorrect account balance");
    }

    @And("I should be told that I have insufficient funds in my account")
    public void iShouldBeToldThatIHaveInsufficientFundsInMyAccount() {
        Assertions.assertTrue(helper.getAtmUserInterface().containsMessage("Insufficient funds"),  "Expected insufficient funds message");

    }

    @When("I check my balance")
    public void iCheckMyBalance() {
        helper.getAtmUserInterface().checkBalance(helper.getMyAccount());
    }

    @Then("I should see that my balance is ${bigdecimal}")
    public void iShouldSeeThatMyBalanceIs$(BigDecimal amount) {
        Assertions.assertTrue(helper.getAtmUserInterface().containsMessage("$" + amount));
    }
}
