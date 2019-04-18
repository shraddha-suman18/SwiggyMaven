package PageObjects;

import DomainObjects.Items;
import cucumber.api.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

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

    public void addToCart(DataTable table){
        for (Items item : table.asList(Items.class)) {
            WebElement itemEle = getItemWithName(item.getItemName());
            addToCount(itemEle,Integer.parseInt(item.getCount()),item.getItemName());
        }
    }

    private WebElement getItemWithName(String name){
        return waitForElementToBeVisible(By.xpath(".//div[@itemtype=\"http://schema.org/MenuItem\"][.//div[@itemprop=\"name\"][contains(text(),\""+name+"\")]]"));

    }

    private String getItemWithNameXpath(String name){
        return ".//div[@itemtype=\"http://schema.org/MenuItem\"][.//div[@itemprop=\"name\"][contains(text(),\""+name+"\")]]";
    }

    private void addToCount(WebElement itemEle, int count, String name){
        String xpathOfItem=".//div[@itemtype=\"http://schema.org/MenuItem\"][.//div[@itemprop=\"name\"][contains(text(),\""+name+"\")]]";
        waitForElementToBeVisible(By.xpath(xpathOfItem));
        WebElement addElement = driver.findElement(By.xpath(xpathOfItem+"//div[contains(text(),\"ADD\")]"));
        addElement.click();
        waiForElementToHaveText(driver.findElement(By.xpath(xpathOfItem+"//div[4]")), Integer.toString(1));

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
//        itemEle.findElement(By.xpath("//div[contains(text(),\"ADD\")]"));

        for(int addCount=1;addCount<count;addCount++){
//            WebElement addButton = driver.findElement(By.xpath(xpathOfItem+"//div[contains(text(),\"" +addCount + "\")]"));
            WebElement addButton = driver.findElement(By.xpath(xpathOfItem+"//div[contains(text(),\"+\")]"));
            Actions act = new Actions(driver);
            addButton.click();
            waiForElementToHaveText(driver.findElement(By.xpath(xpathOfItem+"//div[4]")), Integer.toString(addCount+1));

        }
    }
}
