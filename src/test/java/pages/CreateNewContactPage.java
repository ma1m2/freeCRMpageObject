package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(xpath = "//span[@class='selectable '][text()='Create New Contact']")
    WebElement createNewContactLabel; //css = "div.header.item"

    //Initialisation of Page Objects:
    public CreateNewContactPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public boolean isCreateNewContactLabel(){
        return createNewContactLabel.isDisplayed();
    }

}
