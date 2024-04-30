package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CreateNewContactPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    CreateNewContactPage createNewContactPage;
    CreatedContactPage createdContactPage;

    public CreateNewContactPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        init();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        createNewContactPage = homePage.clickOnAddContactsIcon();
    }

    @Test(priority = 1)
    public void validateCreateNewContact() throws InterruptedException {
        String ftName = "Rita3";
        String ltName = "Lvovna3";
        String email = "x1y1z64+rita3@gmail.com";
        createdContactPage = createNewContactPage.createNewContact(ftName, ltName, email);
        Thread.sleep(5000);
        Assert.assertTrue(createdContactPage.isStarRating(), "No Rating Stars on the page");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
