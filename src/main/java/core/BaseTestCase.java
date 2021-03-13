package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Optional;
import org.testng.log4testng.Logger;
import utilities.PropertyHelper;

public class BaseTestCase {
    final static Logger LOGGER = Logger.getLogger(BaseTestCase.class);
    WebDriver driver;
    String url;

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

            LOGGER.info("Launch " + url);
            driver.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown(){
        LOGGER.info("SHUTTING DOWN WEB DRIVER");
        driver.close();
        driver.quit();
    }
}
