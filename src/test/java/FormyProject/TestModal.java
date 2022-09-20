package FormyProject;

import org.testng.annotations.Test;
import pageobject.ModalPage;

public class TestModal {
    ModalPage modalPage;

    @Test
    public void testAlertTabsPage(){
        modalPage = new ModalPage();
        modalPage.navigateToPage();
        modalPage.clickModalBtn();
        modalPage.clickModalCancelBtn();
    }
}
