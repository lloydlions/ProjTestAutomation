package pageobject;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormPage extends BasePage {
    protected String firstName = "first-name";
    protected String lastName = "last-name";
    protected String jobTitle = "job-title";
    protected String selectMenu = "select-menu";


    public FormPage() {
        super(DriverFactory.initialize());
    }

    public void navigateToPage(){

        loadUrl("https://formy-project.herokuapp.com/form");
        Assert.assertEquals(getPageTitle(),"Complete Web Form");
    }

    public void fillInFirstName(String text){
        this.inputValueByID(firstName, text);
    }

    public void fillInLastName(String text){
        this.inputValueByID(lastName, text);
    }

    public void fillInJobTitle(String text){
        this.inputValueByID(jobTitle, text);
    }

    public void setEducation(String education){
        switch(education){
            case "High School" :
                this.clickWebElement(By.id("radio-button-1"));
                break;
            case "College" :
                this.clickWebElement(By.id("radio-button-2"));
                break;
            case "Grad School" :
                this.clickWebElement(By.id("radio-button-3"));
                break;
        }
    }

    public void setSex(String sex){
        switch(sex){
            case "male" :
                this.clickWebElement(By.id("checkbox-1"));
                break;
            case "Female" :
                this.clickWebElement(By.id("checkbox-2"));
                break;
            case "Prefer not to say" :
                this.clickWebElement(By.id("checkbox-3"));
                break;
        }
    }


    public void setExperience(Integer experience){
        driver = this.getDriver();
        if(experience > 1){
            this.selectDropDownIdThenSelectByText(selectMenu,"0-1");
        }
        if(experience <= 2 || experience >= 4){
            this.selectDropDownIdThenSelectByText(selectMenu,"2-4");
        }
        if(experience <= 5 || experience >= 9){
            this.selectDropDownIdThenSelectByText(selectMenu,"5-9");
        }
        if(experience >= 10){
            this.selectDropDownIdThenSelectByText(selectMenu,"10+");
        }
    }

    public void setDate(String date){
        this.inputValueByID("datepicker", date);
    }

    public void clickSubmitBtn(){
        this.clickWebElement(By.xpath("//a[text()='Submit']"));
    }

    private String getPageTitle(){
        return getElementTextByXpath("//h1");
    }
}
