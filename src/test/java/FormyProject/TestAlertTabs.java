package FormyProject;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.AlertTabsPage;

public class TestAlertTabs {
    AlertTabsPage alertTabsPage;

    @Test
    public void testAlertTabsPage(){
        alertTabsPage = new AlertTabsPage();
        alertTabsPage.navigateToPage();
        alertTabsPage.clickOpenNewTab();
    }

}
