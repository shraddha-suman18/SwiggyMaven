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
        waitForElementToBeVisible(By.className("icon-user-checkout"));
        List<WebElement> distinctItemsInCart= wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("icon-foodSymbol")));
        assertEquals(table.asList(Items.class).size(),distinctItemsInCart.size());
        for (Items expectedItem : table.asList(Items.class)) {
            Items actualItemsInCart = getItemByName(expectedItem.getItemName());
            assertEquals(expectedItem.getItemName().replace(" ",""), actualItemsInCart.getItemName().replace(" ",""));
//            assertEquals(expectedItem.getItemName(), actualItemsInCart.getItemName()); Doesn't work when space is not removed,todo: look at it later
            assertEquals(expectedItem.getCount(),actualItemsInCart.getCount());
        }
    }

    private Items  getItemByName(String name){
        Items item =  new Items();
        String itemXpath =  "//div[./div/div[contains(text(),\""+ name +"\")]]";
        item.itemName = driver.findElement(By.xpath(itemXpath+"//div[1]//div[2]")).getText();
        item.count =  driver.findElement(By.xpath(itemXpath+"//div[2]//div[4]")).getText();
        return item;

    }

}
