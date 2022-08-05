package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import pages.ElementsCardPage;

import java.net.MalformedURLException;

public class ElementsCardSelectionInDemoqaPageTest extends RequiredConditions {
    @Test(description = "Verifies that the 'Elements' card in Demoqa Page navigates to the 'Elements' card Page")
    @Parameters("browser")
    public void verifyThatTheElementsCardNavigatesToTheElementsCardPage() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        String actualElementsCardPageHeader = new ElementsCardPage().getTheElementsPageHeader();
        String expectedElementsCardPageHeader = "Elements";
        String errorMessageInElementsCardPageHeader = "The 'Elements' card in Demoqa Page does not navigate to 'Elements' card Page or the Page's title is written with an error.";

        Assert.assertEquals(actualElementsCardPageHeader, expectedElementsCardPageHeader, errorMessageInElementsCardPageHeader);
    }
}