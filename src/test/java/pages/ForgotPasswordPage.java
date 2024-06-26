package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(tagName = "h2")
    WebElement forgotMyPassword;

    //Initialisation of Page Objects:
    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public boolean isForgotMyPasswordLabel(){
        return forgotMyPassword.isDisplayed();
    }
}
