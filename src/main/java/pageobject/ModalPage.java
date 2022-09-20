package pageobject;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class ModalPage extends BasePage {
    protected By modalBtn = By.id("modal-button");
    protected By ModalCancel = By.id("close-button");

    public ModalPage() {
        super(DriverFactory.initialize());
    }

    public void navigateToPage(){

        loadUrl("https://formy-project.herokuapp.com/modal");
        Assert.assertEquals(getPageTitle(),"Modal");
    }

    public void clickModalBtn(){
        this.clickWebElement(modalBtn);
    }

    public void clickModalCancelBtn(){
        this.clickWebElement(ModalCancel);
    }

    private String getPageTitle(){
        return getElementTextByXpath("//h1");
    }
}
