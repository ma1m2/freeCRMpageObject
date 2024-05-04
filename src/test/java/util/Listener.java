package util;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class Listener extends TestBase implements WebDriverListener {

    public void beforeTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    public void afterTo(WebDriver.Navigation navigation, String url){
        System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeClick(WebElement element){
        System.out.println("Trying to click on: " + element.toString());
    }

    public void afterClick(WebElement element) {
        System.out.println("Clicked on: " + element.toString());
    }

    public void beforeFindElement(WebDriver driver, By by){
        System.out.println("Trying to find Element By : " + by.toString());
    }

    public void afterFindElement(WebDriver driver, By by, WebElement result){
        System.out.println("Found Element By : " + by.toString());
    }

}
