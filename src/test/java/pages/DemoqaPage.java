package pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class DemoqaPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    final String DEMOQA_PAGE_LINK = "https://demoqa.com/";
    public final static String DEMOQA_PAGE_CONTENT_ELEMENT_XPATH = "//*[@class='home-body']";
    public final String HEADER_BASE_URI_OF_DEMOQA_PAGE_ELEMENT_XPATH = "//*[@id='app']/header/a";
    public final String ORIGIN_HREF_OF_DEMOQA_PAGE_ELEMENT_XPATH = "//div[@class='home-banner']/a";
    public final String CARD_ELEMENTS_ELEMENT_XPATH = "//*[@class='category-cards']/div[1]";

    @FindBy(how = How.XPATH, using = "//*[@class='category-cards']/div")
    private List<WebElement> cardsMenuList;

    @FindBy(how = How.XPATH, using = "")
    private List<WebElement> elementsItemsMenuList1;

    public DemoqaPage() throws MalformedURLException {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public DemoqaPage openPage() {
        driver.navigate().to(DEMOQA_PAGE_LINK);
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DEMOQA_PAGE_CONTENT_ELEMENT_XPATH)));
        logger.info("Google.com main Page is loaded");
        return this;
    }

    public String getTheHeaderOfTheDemoqaPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HEADER_BASE_URI_OF_DEMOQA_PAGE_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(HEADER_BASE_URI_OF_DEMOQA_PAGE_ELEMENT_XPATH)).getAttribute("href");
    }

    public ElementsCardPage navigateToElementsCardPage() throws MalformedURLException {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CARD_ELEMENTS_ELEMENT_XPATH))).click();
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CARD_ELEMENTS_ELEMENT_XPATH)));
        logger.info("You have chosen Elements card");
        return new ElementsCardPage();
    }

    public String getTheOriginHrefOfTheDemoqaPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ORIGIN_HREF_OF_DEMOQA_PAGE_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(ORIGIN_HREF_OF_DEMOQA_PAGE_ELEMENT_XPATH))
                .getAttribute("origin");
    }
}