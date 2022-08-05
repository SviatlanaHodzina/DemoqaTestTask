package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoqaPage;

import java.net.MalformedURLException;

public class DemoqaPageOriginHrefTest extends RequiredConditions {
    @Test(description = "Verifies that the origin href of Demoqa Page is ToolsQA Selenium training site")
    @Parameters("browser")
    public void verifyThatTheOriginHrefOfTheDemoqaPageIsToolsQASeleniumTrainingSite() throws MalformedURLException {
        new DemoqaPage()
                .openPage();
        String actualOriginHrefOfTheDemoqaPage = new DemoqaPage().getTheOriginHrefOfTheDemoqaPage();
        String expectedOriginHrefOfTheDemoqaPage = "https://www.toolsqa.com";
        String errorMessageInDemoqaPageOriginHref = "The Page's origin Href differs from the expected one.";

        Assert.assertEquals(actualOriginHrefOfTheDemoqaPage, expectedOriginHrefOfTheDemoqaPage, errorMessageInDemoqaPageOriginHref);
    }
}