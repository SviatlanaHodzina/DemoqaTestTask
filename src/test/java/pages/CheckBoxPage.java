package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

import static pages.ElementsCardPage.ELEMENTS_PAGE_HEADER_ELEMENT_PATH;

public class CheckBoxPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    public final static String CHECK_BOX_PAGE_HEADER_ELEMENT_PATH = "//*[contains(@class,'main-header') " +
            "and contains(text(),'Check Box')]";
    public final String HOME_CHECK_BOX_UNTICKED_SVG_ELEMENT_XPATH = "//*[contains(local-name(),'svg') and contains(@class,'rct-icon rct-icon-uncheck')]";
    public final String HOME_CHECK_BOX_TICKED_SVG_ELEMENT_XPATH = "//*[contains(local-name(),'svg') and contains(@class,'rct-icon rct-icon-check')]";
    public final String HOME_TREE_NODE_PANEL_ELEMENT_XPATH = "//div[@id='tree-node']";
    public final String NOTE_BELOW_HOME_CHECKED_BOX_ELEMENT_XPATH = "//*[@id='result']";
    public final String RADIO_BUTTON_ITEM_ELEMENT_XPATH = "//div[@class='element-list collapse show']//ul/li[3]";
    public final String RADIO_BUTTON_HEADER_ELEMENT_XPATH = "//*[contains(@class,'main-header') " +
            "and contains(text(),'Radio Button')]";

    public CheckBoxPage() throws MalformedURLException {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CheckBoxPage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECK_BOX_PAGE_HEADER_ELEMENT_PATH)));
        logger.info("You have selected" + driver.findElement(By.xpath(CHECK_BOX_PAGE_HEADER_ELEMENT_PATH))
                .getAttribute("textContent") + " item on the side-bar 'Elements' menu.");
        return this;
    }

    public String getTheCheckBoxPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ELEMENTS_PAGE_HEADER_ELEMENT_PATH)));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CHECK_BOX_PAGE_HEADER_ELEMENT_PATH)));
        return driver.findElement(By.xpath(CHECK_BOX_PAGE_HEADER_ELEMENT_PATH)).getAttribute("textContent");
    }

    public CheckBoxPage tickTheHomeFolderCheckBoxElement() throws MalformedURLException {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HOME_TREE_NODE_PANEL_ELEMENT_XPATH)));
        WebElement untickedHomeFolderCheckBox = driver.findElement(By.xpath(HOME_CHECK_BOX_UNTICKED_SVG_ELEMENT_XPATH));
        Actions tickTheElement = new Actions(driver);
        tickTheElement.moveToElement(untickedHomeFolderCheckBox)
                .click()
                .build()
                .perform();
        logger.info("You have ticked the Home folder check box");
        return this;
    }

    public boolean homeFolderCheckBoxIsTicked() {
        logger.info("You have ticked the Home folder");
        return driver.findElement(By.xpath(HOME_CHECK_BOX_TICKED_SVG_ELEMENT_XPATH))
                .getAttribute("zoomAndPan").equals("2");
    }

    public String getTheNoteBelowTheHomeCheckedBox() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NOTE_BELOW_HOME_CHECKED_BOX_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(NOTE_BELOW_HOME_CHECKED_BOX_ELEMENT_XPATH)).getAttribute("outerText");
    }

    public RadioButtonPage navigateToRadioButtonItem() throws MalformedURLException {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(RADIO_BUTTON_ITEM_ELEMENT_XPATH))).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CHECK_BOX_PAGE_HEADER_ELEMENT_PATH)));
        logger.info("This is" + driver.findElement(By.xpath(RADIO_BUTTON_HEADER_ELEMENT_XPATH))
                .getAttribute("textContent"));
        return new RadioButtonPage();
    }
}