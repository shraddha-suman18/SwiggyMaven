package PageObjects;


import java.util.Date;

public class Hooks extends BasePage {

    Utils utils = new Utils();

    public void cleanUp(String scenaioName) {
        Date date = new Date();
        String filePath = "screenshot/"+scenaioName.replace(" ","")+date.getTime()+".png";
        utils.takeScreenshot(filePath);
        if (BasePage.driver != null) {
            BasePage.driver.close();
        }
    }


}