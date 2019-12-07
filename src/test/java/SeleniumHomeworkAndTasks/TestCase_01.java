package SeleniumHomeworkAndTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase_01 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get(" https://practice-cybertekschool.herokuapp.com");
        //driver.manage().window().maximize();
        //wait = new WebDriverWait(driver,15);

    }
    /*
    Test case #1
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Sign Up For Mailing List”
    Step 3. Enter any valid name
    Step 4. Enter any valid email
    Step 5. Click on “Sign Up” button
    Expected result: Following message should be displayed:
    “Thank you for signing up. Click the button below to return to the home page.”
    Home button should be displayed.
    */
    @Test
    public void Test1(){
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        BrowserUtils.wait(2);
        name.sendKeys("Aname");
        BrowserUtils.wait(2);
        email.sendKeys("Aemail@gamil.com");
        BrowserUtils.wait(2);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(2);
        String expectedresult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualresult = driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(expectedresult,actualresult,"passed");
        driver.findElement(By.id("wooden_spoon")).click();

    }

    /*
    Test case #2
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Verify that number of listed examples is equals to 48.
    Hint: use findElemnts() and size() methods.
    */
    @Test
    public void Test2(){
       int actualSize = driver.findElements(By.className("list-group-item")).size();
       Assert.assertEquals(actualSize,48);
        System.out.println("actual size is: "+actualSize);
    }

    /*
    Test case #3
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Multiple Buttons”
    Step 3. Click on “Button 1”Verify that result message is displayed:
    “Clicked on button one!”
    */
    @Test
    public void Test3(){
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary'][1]")).click();
        System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());

    }

    /*
    Test case #4
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “123” into first name input box.
    Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”
    */
    @Test
    public void Test4(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys("123");
        String message= driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(message,"first name can only consist of alphabetical letters");
        System.out.println(message);
    }

    /*
    Test case #5
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “123” into last name input box.
    Step 4. Verify that warning message is displayed:
    “The last name can only consist of alphabetical letters and dash”
*/
    @Test
    public void Test5(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("123");
        String message= driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(message,"The last name can only consist of alphabetical letters and dash");
        System.out.println(message);
    }

    /*
    Test case #6
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “user” into username input box.
    Step 4. Verify that warning message is displayed:
    “The username must be more than 6 and less than 30 characters long”
    */
    @Test
    public void Test6(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@data-bv-field='username']")).sendKeys("user");
        String message = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(message,"The username must be more than 6 and less than 30 characters long");
        System.out.println(message);
    }

    /*
    Test case #7
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “testers@email” into email input box.
    Step 4. Verify that warning message is displayed:
    “email address is not a validEmail format is not correct”
    */
    @Test
    public void Test7(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testers@email");
        List<WebElement> list = driver.findElements(By.xpath("//small[@data-bv-result='INVALID']"));
        String message = "";
        for (WebElement each : list){
             message += each.getText();
        }
        Assert.assertEquals(message,"email address is not a validEmail format is not correct");

        System.out.println(message);

    }

    /*
    Test case #8
    Step 1. Go to https://practice-cybertekschool.herokuapp.com
    Step 2. Click on “Registration Form”
    Step 3. Enter “5711234354” into phone number input box.
    Step 4. Verify that warning message is displayed:
     “Phone format is not correct”
     */
    @Test
    public void Test8(){
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//input[@name='phone'6]")).sendKeys("5711234354");
        String message = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(message,"Phone format is not correct");
        System.out.println(message);

    }

    @AfterMethod
    public void teardown (){
        driver.quit();

    }
}
