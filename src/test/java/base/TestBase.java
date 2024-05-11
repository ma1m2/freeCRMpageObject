package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestUtil;
import util.Listener;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    private static WebDriver original;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init(){
        String browserName = prop.getProperty("browser");
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().clearDriverCache().setup();
            original = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("FF")){
            WebDriverManager.firefoxdriver().setup();
            original = new FirefoxDriver();
        }

        //Create instance of Listener Class
        Listener listener = new Listener();
        //Pass listener to constructor
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listener);
        driver = decorator.decorate(original);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }


    //@Test
/*    public void getProp() throws InterruptedException {
        File currentFile = new File(".");
        System.out.println(prop.getProperty("browser"));
        System.out.println("Absolute Path to project" + System.getProperty("user.dir"));
        System.out.println("Absolute Path " + currentFile.getAbsolutePath());
        init();
        //driver.get(prop.getProperty("url"));
        Thread.sleep(2000);
        driver.quit();
    }*/

}
