package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeSuite;
import sun.java2d.loops.ProcessPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DriverFactory {
    private String browser;
    private String headless;
    private String windowLength;
    private String windowHeight;
    Class<? extends WebDriver> driverClass = null;
    FileInputStream fi;
    Properties prop;

    public String getPropValue(String key) throws Exception {
        fi = new FileInputStream("./src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fi);

        return prop.getProperty(key);
    }

    public String getBrowserType(){
        try{
            if(browser == null){
                browser = "chrome";
            }else{
                browser = getPropValue("browser");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return browser;
    }

    public WebDriver initialize(){
        WebDriver driver = null;

        try {
            switch (getBrowserType().toUpperCase()){
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    if(getPropValue("headless").equals("yes")){
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
                    if(getPropValue("headless").equals("yes")){
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
