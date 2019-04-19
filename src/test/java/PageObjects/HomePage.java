package PageObjects;

import DomainObjects.Items;
import com.cucumber.listener.Reporter;
import cucumber.api.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {


    public void openUrl(){
        driver.get("http://swiggy.com");
    }

    public void setLocation(String searchLocationText){
        WebElement locationSearchBox = waitForElementToBeVisible(By.id("location"));
        locationSearchBox.sendKeys(searchLocationText);
        WebElement firstMatchingLocation = waitForElementToBeVisible(By.cssSelector("div div[tabindex=\"2\"]"));
        firstMatchingLocation.click();
        waitForElementToBeVisible(By.className("global-nav"));
    }

    public void searchForRestaurant(String resturantName){
        waitForElementToBeClickable(By.xpath(".//span[contains(text(),\"Search\")]")).click();
        waitForElementToBeVisible(By.cssSelector("input[placeholder=\"Search for restaurants or dishes\"]")).sendKeys(resturantName+ Keys.ENTER);
        waitForElementToBeVisible(By.xpath(".//a[contains(text(),\"Restaurants\")]"));
        driver.findElements(By.xpath("//div[contains(text(),\"Bite Me\")]")).get(0).click();
    }

    public void addToCart(DataTable table) throws InterruptedException{
        for (Items item : table.asList(Items.class)) {
            addToCount(Integer.parseInt(item.getCount()),item.getItemName());
        }
    }

    private WebElement getItemWithName(String name){
        return waitForElementToBeVisible(By.xpath(".//div[@itemtype=\"http://schema.org/MenuItem\"][.//div[@itemprop=\"name\"][contains(text(),\""+name+"\")]]"));

    }

    private void addToCount(int count, String name) throws InterruptedException{
        String xpathOfItem=".//div[@itemtype=\"http://schema.org/MenuItem\"][.//div[@itemprop=\"name\"][contains(text(),\""+name+"\")]]";
        waitForElementToBeVisible(By.xpath(xpathOfItem));
        WebElement addElement = driver.findElement(By.xpath(xpathOfItem+"//div[contains(text(),\"ADD\")]"));
        addElement.click();
        waiForElementToHaveText(driver.findElement(By.xpath(xpathOfItem+"//div[4]")), Integer.toString(1));
        waitForCountTObeUpdated(xpathOfItem);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        for(int addCount=1;addCount<count;addCount++){
            waitForCountTObeUpdated(xpathOfItem);
            WebElement addButton = waitForElementToBeClickable(By.xpath(xpathOfItem+"//div[contains(text(),\"+\")]"));
            addButton.click();
            waiForElementToHaveText(driver.findElement(By.xpath(xpathOfItem+"//div[4]")), Integer.toString(addCount+1));

        }
    }

    private void waitForCountTObeUpdated(String xpath) throws InterruptedException{
        Boolean towait = true;
        int attempt=0;
        while(towait && attempt<5){
            if(driver.findElements(By.xpath(xpath+"//div[3]//div[2]//span")).size()==0){
                towait=false;
            };
            Thread.sleep(1000);
            attempt++;
        }
    }

    public void checkout(){
        waitForElementToBeClickable(By.xpath(".//div[contains(text(),\"Checkout\")]")).click();
        wait.until(ExpectedConditions.urlContains("checkout"));
    }
}
