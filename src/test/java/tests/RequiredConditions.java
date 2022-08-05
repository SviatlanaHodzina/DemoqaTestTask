package tests;

import driver.WebDriverConnector;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import util.TestListener;

import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class RequiredConditions {
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeMethod()
    public void setUp(String browser) throws MalformedURLException {
        driver = WebDriverConnector.getDriver("browser");
    }
    @AfterMethod(alwaysRun = true)
    public void stopBrowser("browser") {
        WebDriverConnector.closeDriver();
    }
}
