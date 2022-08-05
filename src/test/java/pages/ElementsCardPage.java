package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import static pages.DemoqaPage.DEMOQA_PAGE_CONTENT_ELEMENT_XPATH;

public class ElementsCardPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    public final static String ELEMENTS_PAGE_HEADER_ELEMENT_PATH = "//*[contains(@class,'main-header')" +
            "and contains(text(),'Elements')]";

    @FindBy(how = How.XPATH, using = "//div[@class='element-list collapse show']//ul/li")
    private List<WebElement> elementsItemsMenuList;

    public ElementsCardPage() throws MalformedURLException {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public ElementsCardPage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ELEMENTS_PAGE_HEADER_ELEMENT_PATH)));
        logger.info("You are in Elements items menu.");
        return this;
    }

    public String getTheElementsPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(DEMOQA_PAGE_CONTENT_ELEMENT_XPATH)));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ELEMENTS_PAGE_HEADER_ELEMENT_PATH)));
        return driver.findElement(By.xpath(ELEMENTS_PAGE_HEADER_ELEMENT_PATH)).getAttribute("textContent");
    }

    public CheckBoxPage navigateToCheckBoxItem() throws MalformedURLException {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfAllElements(elementsItemsMenuList));
        for (WebElement elementItem : elementsItemsMenuList) {
            if (elementItem.getAttribute("textContent").matches("Check Box")) {
                elementItem.click();
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ELEMENTS_PAGE_HEADER_ELEMENT_PATH)));
        logger.info("This is a Check Box item");
        return new CheckBoxPage();
    }
}