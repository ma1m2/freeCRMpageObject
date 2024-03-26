package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginBtn; //"//*[contains(@class,'submit')]"
    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPasswordLink;
    @FindBy(linkText = "Sign Up")
    WebElement signUpLink;//xpath//a[text()='Sign Up']
    @FindBy(id = "onesignal-bell-launcher")
    WebElement bell;

    //Initialisation of Page Objects:
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isBell(){
        return bell.isDisplayed();
    }

    public HomePage login(String un, String pwd){
        email.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new  HomePage();
    }

    public SignUpPage clickSingUpLink(){
        signUpLink.click();
        return new SignUpPage();
    }

    public ForgotPasswordPage clickForgotPasswordLink(){
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }



}
