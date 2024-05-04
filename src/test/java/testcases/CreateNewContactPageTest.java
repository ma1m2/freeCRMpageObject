package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;
import util.TestUtil;

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
        Thread.sleep(1000);
        createNewContactPage = homePage.goToCreateNewContactPage();
        Thread.sleep(1000);
    }

    @Test(priority = 1)
    public void verifyCreateNewContactPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(createNewContactPage.isCreateNewContactLabel(), "No Create New Contact Label on the page");
    }

    @DataProvider
    public Object[][] getDataFromExcel(){
        return TestUtil.getTestData("contacts");
    }

    @Test(priority = 1, dataProvider = "getDataFromExcel")
    public void validateCreateNewContact(String ftName, String  ltName, String email)  throws InterruptedException {
        createdContactPage = createNewContactPage.createNewContact(ftName, ltName, email);
        Assert.assertTrue(createdContactPage.isStarRating(), "No Rating Stars on the page");
    }

    //@Test(priority = 1)
    public void getDataFromCsvFile(){
        TestUtil.readCsvFile();
    }

    //@Test(priority = 1)
    public void getCurrentAndUserDir(){
        System.out.println(TestUtil.getCurrentDir());
        System.out.println(TestUtil.getUserDir());
    }

    //@Test(priority = 1)
    public void writeNewProperties(){
        TestUtil.writeReadPropertiesFile();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
