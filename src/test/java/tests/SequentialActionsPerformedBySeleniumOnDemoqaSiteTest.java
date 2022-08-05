package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.DemoqaPage;
import pages.ElementsCardPage;
import pages.RadioButtonPage;

import java.net.MalformedURLException;

public class SequentialActionsPerformedBySeleniumOnDemoqaSiteTest extends RequiredConditions {
    @Test(description = "Verifies performing sequential actions on Demoqa site with the help of Selenium.")
    @Parameters("browser")
    public void verifyTheSequentialActionsPerformedBySeleniumOnDemoqaSite() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new ElementsCardPage().navigateToCheckBoxItem()
                .tickTheHomeFolderCheckBoxElement();
        JavascriptExecutor jeScrolltoRadioB = (JavascriptExecutor) driver;
        jeScrolltoRadioB.executeScript("window.scrollBy(0,300)", "");
        new CheckBoxPage().navigateToRadioButtonItem()
                .selectAnswerImpressiveToTheQuestion()
                .selectAnswerYesToTheQuestion();

        boolean yesAnswerIsSelectedInRadioButtonPage = new RadioButtonPage()
                .getTheSelectedAnswerNoteToTheQuestion().contains("Yes");
        String theErrorAnswer = new RadioButtonPage().getTheSelectedAnswerNoteToTheQuestion();

        Assert.assertTrue(yesAnswerIsSelectedInRadioButtonPage, theErrorAnswer);
    }
}