package SeleniumHomeworkAndTasks;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

import javax.swing.*;

public class testCase1 {
    /*
    Test case #1
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed: “Thank you for signing up.
Click the button below to return to the home page.”
Home button should be displayed.
     */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practicecybertekschool.com");
        driver.findElement(By.xpath("//a[@href=\"/sign_up\"]")).click();
        driver.findElement(By.name("full_name")).sendKeys("User");
        driver.findElement(By.name("email")).sendKeys("user@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);
        String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualResult= driver.findElement(By.name("signup_message")).getText();
        if(expectedResult.equals(actualResult)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
            System.out.println("Expected result is: "+expectedResult);
            System.out.println("Actual result is: "+actualResult);
        }
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']")).click();
        BrowserUtils.wait(3);
        String expectedHomePage = "http://practice.cybertekschool.com/";
        String actualHomePage = driver.getCurrentUrl();
        if(expectedHomePage.equals(actualHomePage)){
            System.out.println("Home page is displayed successfully");
        }else{
            System.out.println("Home page could not be shown up.");
        }

        driver.quit();
    }

}
