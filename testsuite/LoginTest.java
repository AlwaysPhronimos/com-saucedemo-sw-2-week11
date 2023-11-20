package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on page
 */
public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(4000);
        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(4000);
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(4000);
        //Verify the text “PRODUCTS”
        String expectedText = "PRODUCTS";
        Thread.sleep(4000);
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(4000);
        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(4000);
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(4000);
        //Verify the first item is displayed
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(productCount, 6);
        Thread.sleep(4000);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
