package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesPage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(xpath = "//span[@class='selectable '][text()='Companies']")
    WebElement labelCompanies;

    //Initialisation of Page Objects:
    public CompaniesPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String verifyTextContactsLable(){
        return labelCompanies.getText();
    }
}
