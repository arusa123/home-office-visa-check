package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customelisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class VisaConfirmationTest extends BaseTest {
    DurationOfStayPage durationOfStayPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    ReasonForTravelPage reasonForTravelPage;
    ResultPage resultPage;
    SelectNationalityPage selectNationalityPage;
    StartPage startPage;
    WorkTypePage workTypePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
        reasonForTravelPage = new ReasonForTravelPage();
        resultPage = new ResultPage();
        selectNationalityPage = new SelectNationalityPage();
        startPage = new StartPage();
        workTypePage = new WorkTypePage();
    }


    @Test(dataProvider = "visa application 1", dataProviderClass = TestData.class, groups = {"sanity", "regression"})
    public void anAustralianComingToUKForTourism(String nationality, String reason, String result) {
        startPage.setRejectCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickOnContinue();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickOnContinue();
        resultPage.confirmResultMessage(result);

    }

    @Test(dataProvider = "visa application 2", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(String nationality, String reason, String moreOrLess, String job, String result) throws InterruptedException {
        startPage.setRejectCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickOnContinue();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
        durationOfStayPage.selectLengthOfStay(moreOrLess);
        durationOfStayPage.clickNextStepButton();
        workTypePage.selectJobType(job);
        workTypePage.clickOnContinueButton();
        resultPage.confirmResultMessage(result);
    }

    @Test(dataProvider = "visa application 3", dataProviderClass = TestData.class, groups = "regression")
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card(String nationality, String reason, String status, String result) {
        startPage.setRejectCookies();
        startPage.clickStartNow();
        selectNationalityPage.selectNationality(nationality);
        selectNationalityPage.clickOnContinue();
        reasonForTravelPage.selectReasonForVisit(reason);
        reasonForTravelPage.clickNextStepButton();
        // familyImmigrationStatusPage.selectImmigrationStatus(status);
        //  familyImmigrationStatusPage.clickNextStepButton();
        resultPage.confirmResultMessage(result);

    }

}
