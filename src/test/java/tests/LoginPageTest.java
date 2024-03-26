package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    SignUpPage signUpPage;
    ForgotPasswordPage forgotPasswordPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Cogmento CRM", "Wrong title of page.");
    }

    @Test(priority = 2)
    public void isBellTest() throws InterruptedException {
        Thread.sleep(2000);
        boolean flag = loginPage.isBell();
        Assert.assertTrue(flag,"No bell on login page.");
    }

    @Test(priority = 3)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 3)
    public void signUpLinkTest(){
        signUpPage = loginPage.clickSingUpLink();
    }

    @Test(priority = 3)
    public void forgotPasswordLinkTest(){
        forgotPasswordPage = loginPage.clickForgotPasswordLink();
        Assert.assertTrue(forgotPasswordPage.isForgotMyPasswordLabel(),"No such Lable");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
