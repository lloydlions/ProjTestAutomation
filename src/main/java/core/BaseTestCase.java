package core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.PropertyHelper;

public class BaseTestCase {
    final Logger LOGGER = LogManager.getLogger(BaseTestCase.class);
    WebDriver driver;
    String url;
    WebDriverWait wait = null;
    Actions actions;

    public void loadUrl(String url){
        driver = new DriverFactory().initialize();
        try {
            if(url.equals(null)) {
                url = PropertyHelper.getPropValue("URL");
            }

            LOGGER.info("LAUNCH " + url);
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadUrl(){
        driver = new DriverFactory().initialize();
        try {
            url = PropertyHelper.getPropValue("URL");

            LOGGER.info("LAUNCH " + url);
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    ACTIONS VIA WEB ELEMENT CLASS
     */

    //send keys by ID
    public void inputValueByID(String identifier,String inputString){
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
    public void inputValueByXPATH(String identifier,String inputString){
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
    public void clickElementByID(String identifier){
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
    public void clickElementByXPATH(String identifier){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identifier)));
            driver.findElement(By.xpath(identifier)).click();

            LOGGER.info("LOCATE ELEMENT " + identifier + " THEN PERFORM CLICK");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //select text by drop down Id
    public void selectDropDownIdThenSelectByText(String identifier, String value){
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
    public void selectDropDownXpathThenSelectByText(String identifier, String value){
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
    public void selectDropDownIdThenSelectByValue(String identifier, String value){
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
    public void selectDropDownXpathThenSelectByValue(String identifier, String value){
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
    public void enterDateByValues(String identifier, String date, String time){
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

    public void keyEvent_SelectAll(){
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

    public void keyEvent_Copy(){
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

    public void keyEvent_Paste(){
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

    public void keyEvent_PressTab(){
        try {
            actions = new Actions(driver);
            actions.sendKeys(Keys.TAB);
            actions.build().perform();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dragElementThenDropToById(String sourceId, String destinationId){
        try {
            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sourceId)));
            WebElement sourceElement = driver.findElement(By.id(sourceId));

            wait = new WebDriverWait(driver,Integer.parseInt(PropertyHelper.getPropValue("TIMEOUTHANDLER")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(destinationId)));
            WebElement destinationElement = driver.findElement(By.id(destinationId));

            actions = new Actions(driver);
            actions.dragAndDrop(sourceElement,destinationElement)

            LOGGER.info("DRAG " + sourceElement + " TO " + destinationElement);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    ACTIONS VIA JAVASCRIPT EXECUTOR
     */

    public void jsExecute_clickById(String identifier){
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

    public void jsExecute_clickByXpath(String identifier){
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

    @AfterTest
    public void tearDown(){
        LOGGER.info("SHUTTING DOWN WEB DRIVER");
        driver.close();
        driver.quit();
    }

    @BeforeTest
    public void initializeTestFramework(){
        PropertyHelper.loadLog4jPropFile();
    }

}
