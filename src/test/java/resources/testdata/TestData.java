package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "visa application 1")
    public Object[][] getData() {
        Object[][] data1 = new Object[][]{
                {"Australia", "Tourism or visiting family and friends", "You will not need a visa to come to the UK"},

        };
        return data1;
    }

    @DataProvider(name = "visa application 2")
    public Object[][] visaApplication() {
        Object[][] visa2 = new Object[][]{
                {"Chile", "Work, academic visit or business", "longer than 6 months", "Health and care professional", "You need a visa to work in health and care"},
        };
        return visa2;
    }

    @DataProvider(name = "visa application 3")
    public Object[][] visaApplication3() {
        Object[][] visa3 = new Object[][]{
                {"Colombia", "Join partner or family for a long stay", "yes", "You’ll need a visa to join your family or partner in the UK"}
        };
        return visa3;
    }
}
