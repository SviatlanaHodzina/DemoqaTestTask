package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import pages.ElementsCardPage;
import pages.RadioButtonPage;

import java.net.MalformedURLException;

public class AnswerImpressiveNoteInRadioButtonPageTest extends RequiredConditions {
    @Test(description = "Verifies that the answer 'Impressive' in 'Radio Button Page' is selected")
    @Parameters("browser")
    public void verifyThatTheAnswerImpressiveInRadioButtonPageIsSelected() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new ElementsCardPage().navigateToCheckBoxItem()
                .navigateToRadioButtonItem()
                .selectAnswerImpressiveToTheQuestion();
        String actualAnswerNote = new RadioButtonPage().getTheSelectedAnswerNoteToTheQuestion();
        String expectedAnswerNote = "You have selected Impressive";

        String errorMismatchedImpressiveAnswerMessage = "Note answer should be Impressive, but shows the other note";
        Assert.assertEquals(actualAnswerNote, expectedAnswerNote, errorMismatchedImpressiveAnswerMessage);
    }
}