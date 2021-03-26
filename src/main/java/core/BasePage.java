package core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import utilities.PropertyHelper;

import java.util.ArrayList;

public class BasePage {
    final Logger LOGGER = LogManager.getLogger(BasePage.class);
    protected static WebDriver driver;
    protected WebDriverWait wait = null;
    protected Actions actions;
    private String url;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected void loadUrl(String url){
        try {
            if(url.equals(null)) {
                url = PropertyHelper.getPropValue("URL");
            }

            LOGGER.info("LAUNCH " + url);
            driver.get(url);
            setMaximizeWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadUrl(){
        try {
            url = PropertyHelper.getPropValue("URL");

            LOGGER.info("LAUNCH " + url);
            driver.get(url);
            setMaximizeWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    ACTIONS VIA WEB ELEMENT CLASS
     */

    //send keys by ID
    protected void inputValueByID(String identifier,String inputString){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
            driver.findElement(By.id(identifier)).sendKeys(inputString);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN PERFORM SENDKEYS : " + inputString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //send keys by Xpath
    protected void inputValueByXPATH(String identifier,String inputString){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            driver.findElement(By.xpath(identifier)).sendKeys(inputString);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN PERFORM SENDKEYS : " + inputString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //click by Id
    protected void clickElementByID(String identifier){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
            driver.findElement(By.id(identifier)).click();

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN PERFORM CLICK");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //click by Xpath
    protected void clickElementByXPATH(String identifier){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            driver.findElement(By.xpath(identifier)).click();

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN PERFORM CLICK");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //click by Link Text
    protected void clickElementByLinkText(String identifier){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(identifier)));
            driver.findElement(By.linkText(identifier)).click();

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN PERFORM CLICK");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //select text by drop down Id
    protected void selectDropDownIdThenSelectByText(String identifier, String value){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
            Select dropDown = new Select(driver.findElement(By.id(identifier)));
            dropDown.selectByVisibleText(value);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN SELECT DROPDOWN VALUE : " + value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //select text by drop down xpath
    protected void selectDropDownXpathThenSelectByText(String identifier, String value){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            Select dropDown = new Select(driver.findElement(By.xpath(identifier)));
            dropDown.selectByVisibleText(value);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN SELECT DROPDOWN VALUE : " + value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //select value by drop down Id
    protected void selectDropDownIdThenSelectByValue(String identifier, String value){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
            Select dropDown = new Select(driver.findElement(By.id(identifier)));
            dropDown.selectByValue(value);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN SELECT DROPDOWN VALUE : " + value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //select value by drop down xpath
    protected void selectDropDownXpathThenSelectByValue(String identifier, String value){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            Select dropDown = new Select(driver.findElement(By.xpath(identifier)));
            dropDown.selectByValue(value);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN SELECT DROPDOWN VALUE : " + value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //calendar picker by value ---- ex. yyyy/mm/dd TAb hh:mm AM/PM
    protected void enterDateByValues(String identifier, String date, String time){
        try{
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            WebElement datePicker = driver.findElement(By.xpath(identifier));
            datePicker.sendKeys(date);
            datePicker.sendKeys(Keys.TAB);
            datePicker.sendKeys(time);

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN SET DATE TIME AS : " + date + " " + time);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

     /*
    ACTIONS VIA ACTIONS CLASS
     */

    //ctrl + A
    protected void keyEvent_SelectAll(){
        try {
            actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL);
            actions.sendKeys("a");
            actions.keyUp(Keys.CONTROL);
            actions.build().perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //ctrl + C
    protected void keyEvent_Copy(){
        try {
            actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL);
            actions.sendKeys("c");
            actions.keyUp(Keys.CONTROL);
            actions.build().perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //ctrl + V
    protected void keyEvent_Paste(){
        try {
            actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL);
            actions.sendKeys("v");
            actions.keyUp(Keys.CONTROL);
            actions.build().perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //press Tab key
    protected void keyEvent_PressTab(){
        try {
            actions = new Actions(driver);
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //drag and drop
    protected void dragElementThenDropToById(String sourceId, String destinationId){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sourceId)));
            WebElement sourceElement = driver.findElement(By.id(sourceId));

            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(destinationId)));
            WebElement destinationElement = driver.findElement(By.id(destinationId));

            actions = new Actions(driver);
            actions.dragAndDrop(sourceElement,destinationElement);

            LOGGER.info("DRAG " + sourceElement + " TO " + destinationElement);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //get text via html element
    protected String getElementTextByXpath(String identifier){
        String text = null;
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            text = driver.findElement(By.xpath(identifier)).getText();
            LOGGER.info("PAGE TITLE: " + text );
        }catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }

    /*
    ACTIONS VIA JAVASCRIPT EXECUTOR
     */

    //click by id via js executor
    protected void jsExecute_ClickById(String identifier){
        try{
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identifier)));
            WebElement element = driver.findElement(By.id(identifier));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);

            LOGGER.info("CLICK " + element + " BY JAVASCRIPT EXECUTOR");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //click by xpath via js executor
    protected void jsExecute_ClickByXpath(String identifier){
        try{
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            WebElement element = driver.findElement(By.xpath(identifier));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);

            LOGGER.info("CLICK " + element + " BY JAVASCRIPT EXECUTOR");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //enable field via Class Name
    protected void jsExecute_EnableTextFieldByClassName(String domIdentifier){
        String script = "document.getElementsByClassName(" + domIdentifier + ")[1].removeAttribute('disabled')";
        LOGGER.info("ENABLE FIELD " + domIdentifier + " VIA HTML DOM");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(script);
    }

    //enable field via Id
    protected void jsExecute_EnableTextFieldById(String domIdentifier){
        String script = "document.getElementsById(" + domIdentifier + ")[1].removeAttribute('disabled')";
        LOGGER.info("ENABLE FIELD " + domIdentifier + " VIA HTML DOM");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(script);
    }

    //enable field via Name
    protected void jsExecute_EnableTextFieldByName(String domIdentifier){
        String script = "document.getElementsByName(" + domIdentifier + ")[1].removeAttribute('disabled')";
        LOGGER.info("ENABLE FIELD " + domIdentifier + " VIA HTML DOM");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(script);
    }

    protected void switchHandle(int index){
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(index));
    }

    @AfterClass
    public void tearDown(){
        if(!driver.equals(null)){
            LOGGER.info("SHUTTING DOWN WEB DRIVER");
            driver.close();
            driver.quit();
        }
    }

    @BeforeTest
    public void initializeTestFramework(){
        PropertyHelper.loadLog4jPropFile();
    }

    private void setMaximizeWindow(){
        driver.manage().window().maximize();
    }
}
