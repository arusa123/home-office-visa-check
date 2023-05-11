package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reject additional cookies']")
    WebElement rejectCookies;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Start now']")
    WebElement startNow;
    public void setRejectCookies(){
        clickOnElement(rejectCookies);
       // clickOnElement(rejectCookies);
    }
    public void clickStartNow(){
        Reporter.log("Click on start now Button " + startNow.toString());
        clickOnElement(startNow);
        CustomListeners.test.log(Status.PASS, "Clicked on start now Button ");

    }

}
