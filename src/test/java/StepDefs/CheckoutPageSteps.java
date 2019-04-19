package StepDefs;

import PageObjects.CheckoutPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage =  new CheckoutPage();

    @Then("^I should see the following items in my cart$")
    public void iShouldSeeTheFollowingItemsIncart(DataTable table){
        checkoutPage.verifyItemsInCart(table);
    }
}
