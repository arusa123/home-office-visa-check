package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {
    @CacheLookup
    @FindBy(id = "response-0")
    WebElement yes;

    @CacheLookup
    @FindBy(id = "response-1")
    WebElement no;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

    public void selectImmigrationStatus(String status) {
        switch (status) {
            case "Yes":
                clickOnElement(yes);
                break;
            case "No":
                clickOnElement(no);
            default:
                System.out.println("Invalid selection");
        }
    }

    public void clickNextStepButton() {
        Reporter.log("Click on Next Step Button " + nextStepButton.toString());
        clickOnElement(nextStepButton);
        CustomListeners.test.log(Status.PASS, "Clicked on Next Step Button ");

    }

}
