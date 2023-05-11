package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customelisteners.CustomListeners;
import gov.uk.check.visa.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//label[text()]")
    List<WebElement> jobTypeList;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement clickOnContinue;

    public void clickOnContinueButton(){
        Reporter.log("click on continue" + clickOnContinue.toString());
        clickOnElement(clickOnContinue);
        CustomListeners.test.log(Status.PASS, "click on continue " + clickOnContinue);    }

    public void selectJobType(String job) {
        switch (job) {
            case "Health and care professional":
                clickOnElement(jobTypeList, job);
                break;
            case "Digital technology professional":
                clickOnElement(jobTypeList, job);
                break;
            case "Academic or researcher":
                clickOnElement(jobTypeList, job);
                break;
            case "Work in arts or culture":
                clickOnElement(jobTypeList, job);
                break;
            case "Professional sportsperson":
                clickOnElement(jobTypeList, job);
                break;
            case "Religious worker":
                clickOnElement(jobTypeList, job);
                break;
            case "I want to start a business":
                clickOnElement(jobTypeList, job);
                break;
            case "I want to do another type of job - show me other work visas":
            default:
                System.out.println("Invalid job");
        }
    }

}
