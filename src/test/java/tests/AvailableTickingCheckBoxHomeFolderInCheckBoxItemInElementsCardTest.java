package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.DemoqaPage;
import pages.ElementsCardPage;

import java.net.MalformedURLException;

public class AvailableTickingCheckBoxHomeFolderInCheckBoxItemInElementsCardTest extends RequiredConditions {
    @Test(description = "Verifies that the 'Home' folder check box can be ticked " +
            "in the 'Check Box' item in the 'Elements' card")
    @Parameters("browser")
    public void verifyThatTheHomeFolderCheckBoxCanBeTickedInCheckBoxItemInElementsCard() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new ElementsCardPage().navigateToCheckBoxItem()
                .tickTheHomeFolderCheckBoxElement();

        boolean homeFolderCheckBoxIsTicked = new CheckBoxPage().homeFolderCheckBoxIsTicked();

        String errorMessageIfTheCheckBoxHomeIsNotTicked = "The 'Home' folder check box element is not ticked.";

        Assert.assertTrue(homeFolderCheckBoxIsTicked, errorMessageIfTheCheckBoxHomeIsNotTicked);
    }
}