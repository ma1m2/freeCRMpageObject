package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactsPageTest extends TestBase {
    //url = https://ui.cogmento.com/
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = homePage.clickOnContactsLink();
    }

    @Test(priority = 1)
    public void verifyContactLableTest() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(contactsPage.isContactLable(), "Contact label is missing on the page.");
                //assertEquals(contactsPage.verifyTextContactsLable(),"Contacts", "Contact label is missing on the page.");
    }

    @Test(priority = 2)
    public void verifyCreateButtonTest() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(contactsPage.isCreateButton(), "Button Create is missing on the page.");
    }

    @Test(priority = 2)
    public void verifyClickOnCreateButtonTest() throws InterruptedException {
        boolean isLabel = contactsPage.clickOnCreateButton().isCreateNewContactLabel();
        Thread.sleep(3000);
        Assert.assertTrue(isLabel, "Create New Contact label is missing on the page.");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
