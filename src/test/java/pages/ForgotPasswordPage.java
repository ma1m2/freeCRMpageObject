package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends TestBase {
    @FindBy(tagName = "h2")
    WebElement forgotMyPassword;

    //Initialisation of Page Objects:
    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isForgotMyPasswordLabel(){
        return forgotMyPassword.isDisplayed();
    }
}
