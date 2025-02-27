package StepDefs;
import PageObjects.BasePage;
import PageObjects.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomePageSteps {
    HomePage homepage =  new HomePage();

    @Given("^I visit the home page")
    public void iVisitHomePage(){
        homepage.openUrl();
    }

    @When("I set my deliver location as ([^\"]*)$")
    public void iSetMyDeliverLocation(String location){
        homepage.setLocation(location);
    }

    @When("^I search and open restaurant ([^\"]*)$")
    public void iSearchAndOpenRestaurant(String restaurantName){
        homepage.searchForRestaurant(restaurantName);
    }

    @When("^I add following items to my cart$")
    public void iAddItemsToCart(DataTable table) throws  InterruptedException{
        homepage.addToCart(table);
    }

    @And("^I checkout$")
    public void iCheckout(){
        homepage.checkout();
    }



}
