//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;

import core.BaseTestCase;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/*
Sample only
 */
public class SampleClass extends BaseTestCase {

    @Test
    public void testRun(){

        loadUrl("https://formy-project.herokuapp.com/form");
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
//        driver.findElement(By.id("first-name")).sendKeys("First Name");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
//        driver.findElement(By.id("last-name")).sendKeys("Last Name");
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Submit')]")));
//        driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
//        driver.close();
    }
    

}
