package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage extends TestBase {
    //Page Factory - OR(object repository):
    @FindBy(xpath = "//span[@class='selectable '][text()='Deals']")
    WebElement labelDeals;

    //Initialisation of Page Objects:
    public DealsPage() {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String verifyTextContactsLable(){
        return labelDeals.getText();
    }

}
