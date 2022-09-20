package FormyProject;

import org.testng.annotations.Test;
import pageobject.FormPage;

public class TestWebForm {
    FormPage formPage;

    @Test
    public void testAlertTabsPage(){
        formPage = new FormPage();
        formPage.navigateToPage();
        formPage.fillInFirstName("Lloyd");
        formPage.fillInLastName("QA");
        formPage.fillInJobTitle("Automation QA");
        formPage.setEducation("College");
        formPage.setSex("Male");
        formPage.setSex("Prefer not to say");
        formPage.setExperience(7);
        formPage.setDate("09/20/2022");
        formPage.clickSubmitBtn();
    }
}
