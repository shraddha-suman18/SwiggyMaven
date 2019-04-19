package PageObjects;

import DomainObjects.Items;
import static org.junit.Assert.assertEquals;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutPage extends BasePage {

    public void verifyItemsInCart(DataTable table){
        List<WebElement> distinctItemsInCart= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("icon-foodSymbol")));
        assertEquals(table.asList(Items.class).size(),distinctItemsInCart.size());

        for (Items item : table.asList(Items.class)) {
//            assertEquals();
        }
    }

}
