package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.DemoqaPage;
import pages.ElementsCardPage;

import java.net.MalformedURLException;

public class CheckBoxItemSelectionTest extends RequiredConditions {
    @Test(description = "Verifies that the 'Check Box' item in 'Elements' card is selected")
    @Parameters("browser")
    public void verifyThatTheCheckBoxItemInElementsCardIsSelected() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new ElementsCardPage().navigateToCheckBoxItem();

        String actualCheckBoxPageHeader = new CheckBoxPage().getTheCheckBoxPageHeader();
        String expectedCheckBoxPageHeader = "Check Box";
        String errorMessageInCheckBox = "The 'Check Box' item in 'Elements' card does not navigate " +
                "to the 'Check Box' item or the item Page's header is written with an error.";
        Assert.assertEquals(actualCheckBoxPageHeader, expectedCheckBoxPageHeader, errorMessageInCheckBox);
    }
}