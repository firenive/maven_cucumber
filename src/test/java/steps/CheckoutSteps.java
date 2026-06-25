package steps;

import nicebank.Checkout;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSteps {
    Checkout checkout = new Checkout();
    Map<String, Integer> prices = new HashMap<>();


    @Given("the price of a {string} is {int}c")
    public void thePriceOfAIsC(String item, Integer price) {
        prices.put(item, price);

    }

    @When("I checkout {int} {string}")
    public void iCheckout(Integer itemCount, String item) {
        int price = prices.get(item);
        checkout.add(item, itemCount, price);
    }

    @Then("the total price should be {int}c")
    public void theTotalPriceShouldBeC(int total) {
        assertEquals(total, checkout.total());
    }



    @Given("I have ${int} in my Account")
    public void iHave$InMyAccount(int arg0) {
    }

    @Given("I have deposited ${int} in my {string} Account")
    public void iHaveDeposited$InMyAccount(int amount, String account) {

    }

    @When("I transfer ${int} from my {string} Account into my {string} Account")
    public void iTransferMoneyFromOneAccountToAnother(int money, String fromAccount, String toAccount) {

    }



}
