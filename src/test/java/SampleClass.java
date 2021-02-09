import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/*
Sample only
 */
public class SampleClass {

    @Test
    public void testRun(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/lib/webdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        driver.findElement(By.id("first-name")).sendKeys("First Name");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
        driver.findElement(By.id("last-name")).sendKeys("Last Name");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Submit')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
        driver.close();
    }
}
