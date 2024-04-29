package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage  extends TestBase {
    //Page Factory - OR(object repository):
    //url = https://ui.cogmento.com/
    @FindBy(xpath = "//span[@class='selectable '][text()='Contacts']")
    WebElement labelContacts;
    @FindBy(xpath = "//button[text()='Create']")
    WebElement buttonCreate;

    //Initialisation of Page Objects:
    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String verifyTextContactsLable(){
        return labelContacts.getText();
    }

    public  boolean isContactLable(){
        return labelContacts.isDisplayed();
    }

    public  boolean isCreateButton(){
        return buttonCreate.isDisplayed();
    }

    public CreateNewContactPage clickOnCreateButton(){
        buttonCreate.click();
        return new CreateNewContactPage();
    }

}
