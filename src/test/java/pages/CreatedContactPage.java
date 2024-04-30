package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatedContactPage extends TestBase {
    //Page Factory - OR(object repository):
    //url = https://ui.cogmento.com/
    @FindBy(css = "div.ui.star.rating")
    WebElement starRating;

    //Initialisation of Page Objects:
    public CreatedContactPage() {
        PageFactory.initElements(driver,this);
    }

    //Actions:
    public boolean isStarRating(){
        return starRating.isDisplayed();
    }


}
