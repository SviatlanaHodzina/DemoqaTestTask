package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import pages.DemoqaPage;
import pages.ElementsCardPage;

import java.net.MalformedURLException;

public class InfoNoteOfTheSelectedCheckBoxHomeFolderInCheckBoxItemInElementsCardTest extends RequiredConditions {
    @Test(description = "Verifies that the 'Home' folder check box can be ticked " +
            "in the 'Check Box' item in the 'Elements' card with info note below")
    @Parameters("browser")
    public void verifyThatYouGetTheInfoNoteAfterTickingHomeFolderCheckBoxInCheckBoxItemInElementsCard() throws MalformedURLException {
        new DemoqaPage()
                .openPage()
                .navigateToElementsCardPage();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollBy(0,300)", "");
        new ElementsCardPage().navigateToCheckBoxItem()
                .tickTheHomeFolderCheckBoxElement();

        String actualNoteAboutTheSelectedFoldersAndFiles = new CheckBoxPage().getTheNoteBelowTheHomeCheckedBox();

        String expectedNoteAboutTheSelectedHomeFolderAndFiles = "You have selected :\nhome" +
                "\ndesktop\nnotes\ncommands\ndocuments\nworkspace\nreact\nangular\nveu" +
                "\noffice\npublic\nprivate\nclassified\ngeneral\ndownloads\nwordFile\nexcelFile";

        String errorMessageInTheTickedCheckBoxNote = "The ticking the 'Home' folder check box element results in a note " +
                "with not expected context or the noticed check box element is not ticked at all.";

        Assert.assertEquals(actualNoteAboutTheSelectedFoldersAndFiles, expectedNoteAboutTheSelectedHomeFolderAndFiles
                , errorMessageInTheTickedCheckBoxNote);
    }
}