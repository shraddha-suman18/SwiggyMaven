package StepDefs;

import PageObjects.CheckoutPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CheckoutPageSteps {
    CheckoutPage checkoutPage =  new CheckoutPage();

    @Then("^I should see the following items in my cart$")
    public void iShouldSeeTheFollowingItemsIncart(DataTable table){
        checkoutPage.verifyItemsInCart(table);
    }

    @And("^I sign up with following details$")
    public void iSighUpWithDetails(DataTable table){
        checkoutPage.signUp(table);
    }

    @Then("^I should see message ([^\"]*)$")
    public void iShouldSeeErrorMessage(String message){
        checkoutPage.verifySignUperror(message);
    }
}
