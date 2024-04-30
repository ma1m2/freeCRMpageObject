package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewContactPage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(xpath = "//span[@class='selectable '][text()='Create New Contact']")
    WebElement createNewContactLabel; //css = "div.header.item"
    @FindBy(name = "first_name")
    WebElement firstName;
    @FindBy(name = "last_name")
    WebElement lastName;
    @FindBy(name = "//span[text()='New']")
    WebElement status; //*[@name='status']/span[text()='New']
    @FindBy(css = "i.checkmark.icon")
    WebElement emailChechmarkIcon; //i[@class='checkmark icon']
    @FindBy(xpath = "//input[@placeholder='Email address']")
    WebElement emailField;
    @FindBy(xpath = "(//div[@class='ui toggle checkbox'])[3]")
    WebElement doNotEmailToggle;
    @FindBy(css = "button.ui.linkedin.button")
    WebElement saveBtn;

    //Initialisation of Page Objects:
    public CreateNewContactPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public boolean isCreateNewContactLabel(){
        return createNewContactLabel.isDisplayed();
    }

    public CreatedContactPage createNewContact(String ftName, String ltName, String email){
        firstName.sendKeys(ftName);
        lastName.sendKeys(ltName);
        emailChechmarkIcon.click();
        emailField.sendKeys(email);
        doNotEmailToggle.click();
        saveBtn.click();
        return new CreatedContactPage();
    }

}
