package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.CreateNewContactPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    CreateNewContactPage createNewContactPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void isLogoTest(){
        boolean flag = homePage.isDisplaiedLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 1)
    public void verifyUsernameTest(){
        String name = homePage.validateTextUserName();
        Assert.assertEquals(name,"CLIENT Sveta","Wrong name of user on HomePage");
    }
    @Test(priority = 1)
    public void verifyContactsLinkTest() {
        contactsPage = homePage.clickOnContactsLink();
        String label = contactsPage.verifyTextContactsLable();
        Assert.assertEquals(label,"Contacts","Wrong label on ContactsPage");
    }
    @Test(priority = 1)
    public void verifyClickOnAddContactsIcon() throws InterruptedException {
        createNewContactPage = homePage.clickOnAddContactsIcon();
        boolean isLabel = createNewContactPage.isCreateNewContactLabel();
        Assert.assertTrue(isLabel, "CreateNewContactLabel is missing on page");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
