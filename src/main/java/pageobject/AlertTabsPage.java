package pageobject;

import core.BaseTestCase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AlertTabsPage extends BaseTestCase {

    protected String newTabBtn = "new-tab-button";
    protected String alertBtn = "alert-button";

    public void navigateToPage(){
        loadUrl("https://formy-project.herokuapp.com/switch-window");
        Assert.assertEquals(getPageTitle(),"Switch Window");
    }

    public void clickOpenNewTab(){
        clickElementByID(newTabBtn);
        Assert.assertEquals(getPageTitle(),"Welcome to Formy");
    }

    public void closeTabWindows(){
//        ArrayList<String> tabs_windows = new ArrayList<String> (Web.getWindowHandles());
//        driver.switchTo().window(tabs_windows.get(index))
    }

    private String getPageTitle(){
        return getElementTextByXpath("//h1");
    }
}
