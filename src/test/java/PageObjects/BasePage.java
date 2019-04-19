package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

     BasePage(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        if(driver==null){
            driver =  new ChromeDriver();
            driver.manage().window().maximize();
        }
        wait =  new WebDriverWait(driver,30);
    }

    public WebElement waitForElementToBeVisible(By elementLocator)
    {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waiForElementToHaveText(WebElement element, String text)
    {
         wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public WebElement waitForElementToBeClickable(By elementLocator){
         waitForElementToBeVisible(elementLocator);
         return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

}
