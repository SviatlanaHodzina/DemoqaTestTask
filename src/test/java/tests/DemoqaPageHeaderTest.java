package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoqaPage;

import java.net.MalformedURLException;

public class DemoqaPageHeaderTest extends RequiredConditions {
    @Test(description = "Verifies the Demoqa Page's base URI header")
    @Parameters("browser")
    public void verifyThatTheBaseURIHeaderOfDemoqaPageIsDemoqaCom() throws MalformedURLException {
        new DemoqaPage()
                .openPage();

        String actualHeaderOfTheDemoqaPage = new DemoqaPage().getTheHeaderOfTheDemoqaPage();
        String expectedHeaderOfTheDemoqaPage = "https://demoqa.com/";
        String errorMessageInDemoqaPageHeader = "The Demoqa Page's base URI Header differs from the expected one.";

        Assert.assertEquals(actualHeaderOfTheDemoqaPage, expectedHeaderOfTheDemoqaPage, errorMessageInDemoqaPageHeader);
    }
}