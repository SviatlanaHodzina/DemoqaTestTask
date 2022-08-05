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

import static pages.CheckBoxPage.CHECK_BOX_PAGE_HEADER_ELEMENT_PATH;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

public class RadioButtonPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    public final String RADIO_BUTTON_HEADER_ELEMENT_XPATH = "//*[contains(@class,'main-header') " +
            "and contains(text(),'Radio Button')]";
    public final String IMPRESSIVE_RADIO_BUTTON_ELEMENT_XPATH = "//label[@for='impressiveRadio']";
    public final String YES_RADIO_BUTTON_ELEMENT_XPATH = "//label[@for='yesRadio']";
    public final String NO_RADIO_BUTTON_ELEMENT_XPATH = "//input[@id='noRadio']";
    public final String SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH = "//p[@class='mt-3']";

    @FindBy(how = How.XPATH, using = "//div[@class='custom-control custom-radio custom-control-inline']//label")
    private List<WebElement> enabledAnswerOptionsList;

    public RadioButtonPage() throws MalformedURLException {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public RadioButtonPage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RADIO_BUTTON_HEADER_ELEMENT_XPATH)));
        logger.info("You have selected" + driver.findElement(By.xpath(RADIO_BUTTON_HEADER_ELEMENT_XPATH))
                .getAttribute("textContent") + " item on the side-bar 'Elements' menu.");
        return this;
    }

    public String getTheRadioButtonPageHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CHECK_BOX_PAGE_HEADER_ELEMENT_PATH)));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RADIO_BUTTON_HEADER_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(RADIO_BUTTON_HEADER_ELEMENT_XPATH)).getAttribute("textContent");
    }

    public RadioButtonPage selectAnswerImpressiveToTheQuestion() throws MalformedURLException {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfAllElements(enabledAnswerOptionsList));
        for (WebElement enabledAnswer : enabledAnswerOptionsList) {
            if (enabledAnswer.getAttribute("textContent").matches("Impressive")) {
                enabledAnswer.click();
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath(SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH)));
        logger.info("You have selected" + driver
                .findElement(By.xpath(SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH))
                .getAttribute("textContent"));
        return this;
    }

    public RadioButtonPage selectAnswerYesToTheQuestion() throws MalformedURLException {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfAllElements(enabledAnswerOptionsList));
        for (WebElement enabledAnswer : enabledAnswerOptionsList) {
            if (enabledAnswer.getAttribute("textContent").matches("Yes")) {
                enabledAnswer.click();
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath(SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH)));
        logger.info("You have selected" + driver
                .findElement(By.xpath(SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH))
                .getAttribute("textContent"));
        return this;
    }

    public boolean yesAnswerIsSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(YES_RADIO_BUTTON_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(YES_RADIO_BUTTON_ELEMENT_XPATH)).isSelected();
    }

    public boolean impressiveAnswerIsSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IMPRESSIVE_RADIO_BUTTON_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(IMPRESSIVE_RADIO_BUTTON_ELEMENT_XPATH)).isSelected();
    }

    public String getTheSelectedAnswerNoteToTheQuestion() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH)));
        return driver.findElement(By.xpath(SELECTED_ANSWER_TO_THE_QUESTION_NOTE_ELEMENT_XPATH)).getAttribute("textContent");
    }
}