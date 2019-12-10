package SE_HomeworkAndTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase_02b {
    /*
Test case #6
Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed:
“Thank you for signing up. Click the button below to
return to the home page.”
Step 9. Navigate back to the “https://
www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from
“do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for
subscribing to practice.cybertekschool.com!”
*/
    private WebDriver driver;
    @Test
    public void Test6(){
        driver= BrowserFactory.getDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        WebElement givenemail = driver.findElement(By.className("animace"));
        String emailaddress = givenemail.getText();

        driver.navigate().to("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        String name = "Hacer Han";
        driver.findElement(By.name("full_name")).sendKeys(name);
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(emailaddress);
        driver.findElement(By.className("radius")).click();
        String actual = driver.findElement(By.name("signup_message")).getText();
        actual=actual.trim();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected,"cannot signup ");
        /*
        Alternative way:
        //Verify that Sign Up message is displayed
        WebElement SignUpText = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(SignUpText.isDisplayed(), "Sign Up Message is not displayed");
         */
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        BrowserUtils.wait(10);


        String actual2= driver.findElement(By.xpath("//td[contains(text(),'do-not-reply@practice.cybertekschool.com')]")).getText();
        actual2=actual2.trim();
        String expected2="do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actual2,expected2, "email is not received");

        String actual3= driver.findElement(By.xpath("//td[contains(text(),'Thanks for subscribing to practice.cybertekschool.com!')]")).getText();
        actual3=actual3.trim();
        String expected3="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actual3,expected3, "wrong email is sent");

        driver.quit();



    }
}
