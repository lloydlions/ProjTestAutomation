package pageobject;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class FileUploadPage extends BasePage {

    public FileUploadPage() {
        super(DriverFactory.initialize());
    }

    public void navigateToPage(){
        loadUrl("https://formy-project.herokuapp.com/fileupload");
        Assert.assertEquals(getPageTitle(),"File upload");
    }

    public void insertSamplePath(String text){
        try{
            JavascriptExecutor executor = (JavascriptExecutor)this.getDriver();
            executor.executeScript("document.getElementById('file-upload-field').setAttribute('value', '" + text + "')");
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    private String getPageTitle(){
        return getElementTextByXpath("//h1");
    }
}
