package computer;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void testName() {
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        sendKeysToElement(By.xpath("//select[@id='products-orderby']"), "Name:A to Z");
        WebElement dropdown = driver.findElement(By.name("products-orderby"));
        Select select = new Select(dropdown);
        select.selectByValue("5");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        sendKeysToElement(By.xpath("//select[@id='products-orderby']"), "Name:A to Z");
        WebElement dropdown = driver.findElement(By.name("products-orderby"));
        Select select = new Select(dropdown);
        select.selectByValue("5");
        WebElement buildcomputer = driver.findElement(By.linkText("Build your own computer"));
       buildcomputer.click();

        WebElement processor = driver.findElement(By.name("product_attribute_1"));
        Select select1 = new Select(processor);
        select.selectByValue("1");





        WebElement addcartbutton = driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        addcartbutton.click();





    }

}
