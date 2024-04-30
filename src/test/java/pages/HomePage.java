package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(css = "div.header.item")
    WebElement logo;
    @FindBy(className = "user-display")
    WebElement usernameLabel; //div/span[text()='CLIENT Sveta'] //css = "span.user-display"
    @FindBy(id = "main-nav")
    WebElement sideMenu;//div[@id='main-nav']
    @FindBy(xpath = "//a/span[contains(text(),'Home')]")
    WebElement homeLink; //a/span[contains(text(),'Home')]
    @FindBy(xpath = "//a/span[contains(text(),'Calendar')]")
    WebElement calendarLink;
    @FindBy(xpath = "//a/span[contains(text(),'Contacts')]")
    WebElement contactsLink;//span[@class='item-text'][text()='Contacts']
    @FindBy(xpath = "(//i[@class='plus inverted icon'])[2]")
    WebElement addContactsIcon;
    @FindBy(xpath = "//a/span[contains(text(),'Companies')]")
    WebElement companiesLink;//span[@class='item-text'][text()='Companies']
    @FindBy(xpath = "//a/span[contains(text(),'Deals')]")
    WebElement dealsLink;//span[@class='item-text'][text()='Deals']
    @FindBy(xpath = "//a/span[contains(text(),'Tasks')]")
    WebElement tasksLink;//span[@class='item-text'][text()='Tasks']
    @FindBy(xpath = "//a/span[contains(text(),'Cases')]")
    WebElement casesLink;//span[@class='item-text'][text()='Cases']
    @FindBy(xpath = "//a/span[contains(text(),'Calls')]")
    WebElement callsLink;//span[@class='item-text'][text()='Calls']
    @FindBy(xpath = "//a/span[contains(text(),'Documents')]")
    WebElement documentsLink;//span[@class='item-text'][text()='Documents']
    @FindBy(xpath = "//a/span[contains(text(),'Email')]")
    WebElement emailLink;//span[@class='item-text'][text()='Email']
    @FindBy(xpath = "//a/span[contains(text(),'Campaigns')]")
    WebElement campaignsLink;//span[@class='item-text'][text()='Campaigns']
    @FindBy(xpath = "//a/span[contains(text(),'Forms')]")
    WebElement formsLink;//span[@class='item-text'][text()='Forms']
    @FindBy(xpath = "//a/span[contains(text(),'Reports')]")
    WebElement reportsLink;//span[@class='item-text'][text()='Reports']

    //Initialisation of Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public boolean isDisplaiedLogo(){
        return logo.isDisplayed();
    }

    public String validateTextUserName(){
        return usernameLabel.getText();
    }

    public void clickOnHomeLink(){
        homeLink.click();
    }

    public void clickOnCalendarLink(){
        calendarLink.click();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public CreateNewContactPage clickOnAddContactsIcon() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(sideMenu).build().perform();
        Thread.sleep(2000);
        addContactsIcon.click();
        Thread.sleep(2000);
        return new CreateNewContactPage();
    }

    public CompaniesPage clickOnCompaniesLink(){
        companiesLink.click();
        return new CompaniesPage();
    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public void clickOnTasksLink(){
        tasksLink.click();
    }

    public void clickOnCasesLink(){
        casesLink.click();
    }

    public void clickOnCallsLink(){
        callsLink.click();
    }

    public void clickOnDocumentsLink(){
        documentsLink.click();
    }

    public void clickOnEmailLink(){
        emailLink.click();
    }

    public void clickOnCampaignsLink(){
        campaignsLink.click();
    }

    public void clickOnFormsLink(){
        formsLink.click();
    }

    public void clickOnReportsLink(){
        reportsLink.click();
    }

}
