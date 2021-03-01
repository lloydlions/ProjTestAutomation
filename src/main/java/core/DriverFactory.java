package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.InvocationTargetException;

public class DriverFactory {
    private String browser;
    Class<? extends WebDriver> driverClass = null;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public WebDriver initialize() {
        WebDriver driver = null;
        if(browser == null){
            setBrowser("CHROME");
        }

        switch (getBrowser().toLowerCase()){
            case "chrome":
//                driverClass = ChromeDriver.class;
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
//                driverClass = FirefoxDriver.class;
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
//                driverClass = InternetExplorerDriver.class;
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "edge" :
//                driverClass = EdgeDriver.class;
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "opera":
//                driverClass = OperaDriver.class;
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            case "safari":
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

        return driver;
    }
}
