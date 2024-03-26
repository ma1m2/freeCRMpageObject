package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import util.TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    protected static WebDriver driver;
    protected static Properties prop;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("FF")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }


    //@Test
    public void getProp() throws InterruptedException {
        File currentFile = new File(".");
        System.out.println(prop.getProperty("browser"));
        System.out.println("Absolute Path to project" + System.getProperty("user.dir"));
        System.out.println("Absolute Path " + currentFile.getAbsolutePath());
        init();
        //driver.get(prop.getProperty("url"));
        Thread.sleep(2000);
        driver.quit();
    }

}
