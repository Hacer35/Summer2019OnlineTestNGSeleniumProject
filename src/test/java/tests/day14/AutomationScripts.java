package tests.day14;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class AutomationScripts {
    @Test
    public void test1(){
        //since remotewebdriver is a parent class for Chrome, IE, Firefox, etc..
        //we can use it as a reference type
        //thus, we don't have to casting to use jsexecutor interface
        //since RemoteWebDriver implements WebDriver and JavascriptExecutor interface
        //we don't need to do casting
        //if would use WebDriver as a reference type instead of RemoteWebDriver
        //Then we would need to cast driver object
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //since every browser natively supports javascript
        //we can take advantage of javascript, whenver selenium methods are not working
        //and JavascriptExecutor interface allows to run js code along with java as part of automation
        //JavascriptExecutor is very useful for scrolling
        WebDriverManager.chromedriver().setup();
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement submitBtn = driver.findElement(By.id("_submit"));
        WebElement userName = driver.findElement(By.id("prependedInput"));
        WebElement password = driver.findElement(By.id("prependedInput2"));
        //setAttribute('value', 'text'),  same thing as a sendKeys("text")
        driver.executeScript("arguments[0].setAttribute('value', 'storemanager85')", userName);
        driver.executeScript("arguments[0].setAttribute('value', 'UserUser123')", password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //arguments[0] = first web element after , (in our case: submitBtn)
        driver.executeScript("arguments[0].click()", submitBtn);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
