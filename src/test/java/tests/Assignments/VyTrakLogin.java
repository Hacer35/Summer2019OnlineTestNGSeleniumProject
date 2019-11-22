package tests.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class VyTrakLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("user180");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        BrowserUtils.wait(3);
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Successfully logged in");
        }else{
            System.out.println("Invalid entity");
            System.out.println("Expected Title is: "+expectedTitle);
            System.out.println("Actual Title is: "+actualTitle);
        }
/*
        String actualURL = driver.getCurrentUrl();
        String expectedURL= "https://qa2.vytrack.com/";
        if(actualURL.equals(expectedURL)){
            System.out.println("Successfully logged in");
        }else{
            System.out.println("Invalid entity");
            System.out.println("Expected Title is: "+expectedTitle);
            System.out.println("Actual Title is: "+actualTitle);
        }

 */
        driver.quit();
    }
}
