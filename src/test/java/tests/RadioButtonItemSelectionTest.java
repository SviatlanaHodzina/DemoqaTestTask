package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import pages.ElementsCardPage;
import pages.RadioButtonPage;

import java.net.MalformedURLException;

public class RadioButtonItemSelectionTest extends RequiredConditions {
    @Test(description = "Verifies that the 'Radio Button' item in 'Elements' card is selected")
    @Parameters("browser")
    public void verifyThatTheRadioButtonItemInElementsCardIsSelected() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new ElementsCardPage().navigateToCheckBoxItem()
                .navigateToRadioButtonItem();

        String actualRadioButtonPageHeader = new RadioButtonPage().getTheRadioButtonPageHeader();
        String expectedRadioButtonPageHeader = "Radio Button";
        String errorMessageInRadioButton = "The 'Radio Button' item in 'Elements' card does not navigate " +
                "to the 'Radio Button' item or the item Page's header is written with an error.";

        Assert.assertEquals(actualRadioButtonPageHeader, expectedRadioButtonPageHeader, errorMessageInRadioButton);
    }
}