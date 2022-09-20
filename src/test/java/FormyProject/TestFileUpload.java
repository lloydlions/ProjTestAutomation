package FormyProject;

import org.testng.annotations.Test;
import pageobject.FileUploadPage;

public class TestFileUpload {
    FileUploadPage fileUploadPage;

    @Test
    public void testAlertTabsPage(){
        fileUploadPage = new FileUploadPage();
        fileUploadPage.navigateToPage();
        fileUploadPage.insertSamplePath("lloyd test");
    }
}
