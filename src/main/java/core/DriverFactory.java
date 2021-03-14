package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import utilities.PropertyHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DriverFactory {
    private String windowLength;
    private String windowHeight;
    Class<? extends WebDriver> driverClass = null;

    // initialize driver; set headless browser
    public WebDriver initialize(){
        final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

        String headless = null;
        String browser = null;
        WebDriver driver = null;
        try {
            browser = PropertyHelper.getPropValue("BROWSER").toUpperCase();
            headless = PropertyHelper.getPropValue("HEADLESS");
            LOGGER.info("BROWSER: " + browser);;

            if(browser == null){
                browser = "CHROME";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            switch (browser){
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    if(headless.equals("yes")){
                        LOGGER.info("ENABLE HEADLESS WEB DRIVER");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--disable-gpu");
                        driver = new ChromeDriver(chromeOptions);
                    }else{
                        driver = new ChromeDriver();
                    }
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    if(headless.equals("yes")){
                        LOGGER.info("ENABLE HEADLESS WEB DRIVER");
                        FirefoxOptions ffOptions = new FirefoxOptions();
                        ffOptions.setHeadless(true);
                        driver = new FirefoxDriver(ffOptions);
                    }else{
                        driver = new FirefoxDriver();
                    }
                    break;
                case "IE":
//                driverClass = InternetExplorerDriver.class;
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "EDGE" :
//                driverClass = EdgeDriver.class;
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "OPERA":
//                driverClass = OperaDriver.class;
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "SAFARI":
                    try {
                        DriverManagerType safari = DriverManagerType.SAFARI;
                        WebDriverManager.getInstance(safari).setup();
                        Class<?> safariClass = Class.forName(safari.browserClass());
                        driver = (WebDriver) safariClass.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return driver;
    }
}
