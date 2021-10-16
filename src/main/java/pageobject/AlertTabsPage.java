package pageobject;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class AlertTabsPage extends BasePage {
    protected String newTabBtn = "new-tab-button";
    protected String alertBtn = "alert-button";
    protected static WebDriver driver;

    public AlertTabsPage() {
        super(DriverFactory.initialize());
    }

    public void navigateToPage(){
        loadUrl("https://formy-project.herokuapp.com/switch-window");
        Assert.assertEquals(getPageTitle(),"Switch Window");
    }

    public void clickOpenNewTab(){
        clickElementByID(newTabBtn);
        closeTabIfNotSwitchWindow();
    }

    public void closeTabIfNotSwitchWindow(){
        //retain parent tab, then close other tabs
        driver = getDriver();
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        for(int i = 1; i < tabs_windows.toArray().length; i++){
            driver.switchTo().window(tabs_windows.get(i));
            driver.close();
        }
        driver.switchTo().window(tabs_windows.get(0));
    }

    public void clickOpenAlert(){
        clickElementByID(alertBtn);

        driver = getDriver();
        driver.switchTo().alert().accept();
    }

    private String getPageTitle(){
        return getElementTextByXpath("//h1");
    }
}
