package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void selectMenu(String menu){
        clickOnElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));

        String expectedMessage = "Welcome to our store";
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("navigate to page area",expectedMessage,actualMessage);
    }




















}
