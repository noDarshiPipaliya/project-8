package eletronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class EletronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textverified() {

        Actions actions = new Actions(driver);

        WebElement eletronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellphones = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        actions.moveToElement(eletronics).moveToElement(cellphones).click().build().perform();
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() {
        Actions actions = new Actions(driver);

        WebElement eletronics = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        WebElement cellphones = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        actions.moveToElement(eletronics).moveToElement(cellphones).click().build().perform();

        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        String expectedMessage1 = "Nokia Lumia 1020";
        String actualMessage1 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        String expectedMessage2 = "$349.00";
        String actualMessage2 = getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);


//        WebElement nokia = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/img[1]"));
//        nokia.click();

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/a[1]/img[1]"));

        driver.findElement(By.id("product_enteredQuantity_20")).sendKeys("2");

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //The product has been added to your shopping cart
        ////body/div[@id='bar-notification']/div[1]
        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        WebElement shoppingcart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        WebElement gotocart = driver.findElement(By.xpath("//button[contains(text(),'Go to cart')]"));
        actions.moveToElement(shoppingcart).moveToElement(gotocart).click().build().perform();

        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        String expectedMessage5 = "2";
        String actualMessage5 = getTextFromElement(By.xpath("//input[@id='itemquantity11232']"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        String expectedMessage6 = "$698.00";
        String actualMessage6 = getTextFromElement(By.xpath("//tbody/tr[4]/td[1]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));

        String expectedMessage7 = "Welcome, Please Sign In!";
        String actualMessage7 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        String expectedMessage8 = "Register";
        String actualMessage8 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        sendKeysToElement(By.name("FirstName"),"Devanshi");
        sendKeysToElement(By.name("LastName"),"Pipaliya");
        sendKeysToElement(By.name("Email"),"devpatel@gmail.com");
        sendKeysToElement(By.id("Password"),"Devanshi");
        sendKeysToElement(By.id("ConfirmPassword"),"Devanshi");
        clickOnElement(By.xpath("//button[@id='register-button']"));

        String expectedMessage9 = "Your registration completed";
        String actualMessage9 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("navigate to page area", expectedMessage, actualMessage);

        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }


}

