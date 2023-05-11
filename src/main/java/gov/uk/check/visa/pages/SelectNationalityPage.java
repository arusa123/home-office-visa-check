package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='response']")
    WebElement nationalityDropDownList;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;

public void selectNationality(String nationality){
    selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
}

public void clickOnContinue(){
    Reporter.log("Click on Next Step Button " + nextStepButton.toString());
    clickOnElement(nextStepButton);
    CustomListeners.test.log(Status.PASS, "Clicked on Next Step Button ");
}

}
