package SE_HomeworkAndTasks;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase_02 {
    /*
    Guideline:
Please create test scripts from 1 through 5 in
the same class, with implementing @Before method
for driver setup, and @After method for driver close.
Also, do the same thing for tests cases from 9
through 12.
*/
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get(" https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
    }
    /*
Test case #1
Step 1. Go to “https://practice-cybertekschool.
herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter “wrong_dob” into date of birth input
box.
Step 4. Verify that warning message is displayed:
“The date of birth is not valid”
*/
    @Test
    public void Test1(){
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
        String message= driver.findElement(By.xpath("//small[@data-bv-result='INVALID']")).getText();
        Assert.assertEquals(message,"The date of birth is not valid");
        System.out.println(message);

    }
    /*
Test case #2
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for
programming languages are displayed: c++, java,
JavaScript
*/
    @Test
    public void Test2(){
        boolean c = driver.findElement(By.cssSelector("input[id='inlineCheckbox1']")).isDisplayed();
        System.out.println(c);
        boolean j= driver.findElement(By.cssSelector("input[id='inlineCheckbox2']")).isDisplayed();
        System.out.println(j);
        boolean js= driver.findElement(By.cssSelector("input[id='inlineCheckbox3']")).isDisplayed();
        System.out.println(js);

    }

    /*
Test case #3
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first
name input box.
Step 4. Verify that warning message is displayed:
“first name must be more than 2 and less than 64
characters long”
*/
    @Test
    public void Test3(){
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("a");
        String message= driver.findElement(By.cssSelector("small[data-bv-result='INVALID']")).getText();
        System.out.println(message);
    }

    /*
Test case #4
Step 1. Go to https://practicecybertekschool.
herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last
name input box.
Step 4. Verify that warning message is displayed:
“The last name must be more than 2 and less than
64 characters long”
*/
    @Test
    public void Test4(){
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("b");
        String message= driver.findElement(By.cssSelector("small[data-bv-result='INVALID']")).getText();
        System.out.println(message);
    }

    /*
Test case #5
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed
registration!”
Note: for using dropdown, please refer to the
documentation: https://selenium.dev/selenium/
docs/api/java/org/openqa/selenium/support/ui/
Select.html or, please watch short video about dropdowns
that is posted on canvas.
*/
    @Test
    public void Test5(){
        Faker faker = new Faker();
        WebElement firstnamebox = driver.findElement(By.cssSelector("input[name='firstname']"));
        WebElement lastnamebox = driver.findElement(By.cssSelector("input[name='lastname']"));
        WebElement usernamebox = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement emailbox = driver.findElement(By.cssSelector("[name='email']"));
        WebElement passwordbox = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement phonenumberbox = driver.findElement(By.cssSelector("input[name='phone']"));
        WebElement DOB = driver.findElement(By.cssSelector("input[name='birthday']"));
        WebElement gender = driver.findElement(By.cssSelector("input[value='female']"));
        WebElement java = driver.findElement(By.cssSelector("input[value='java']"));

        firstnamebox.sendKeys(faker.name().firstName());
        lastnamebox.sendKeys(faker.name().lastName());
        usernamebox.sendKeys("cs3292511");
        emailbox.sendKeys("email@email.com");
        passwordbox.sendKeys("aaaaaaaa");
        phonenumberbox.sendKeys("571-000-0000");
        DOB.sendKeys("01/01/2000");
        gender.click();
        java.click();

        WebElement department = driver.findElement(By.cssSelector("select[name='department']"));
        Select selectDepartment = new Select(department);
        selectDepartment.selectByValue("DE");

        WebElement job = driver.findElement(By.cssSelector("select[name='job_title']"));
        Select selectJob = new Select(job);
        selectJob.selectByVisibleText("SDET");

        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(3);

        String message = driver.findElement(By.xpath("html/body/div/div[2]/div/div/div/p")).getText();
        System.out.println(message);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
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
Step 12. Verify that email is from: “do-notreply@
practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for
subscribing to practice.cybertekschool.com!”
*/
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
    /*
Test case #7
Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your
computer.
Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”
Step 6. Verify that uploaded file name is displayed.
Note: use element.sendKeys(“/file/path”) with
specifying path to the file for uploading. Run this
method against “Choose File” button.
*/
    @Test
    public void Test7(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys(" C:\\Users\\hacer\\OneDrive\\Pictures\\Screenshots\\2019-11-15.png");
        driver.findElement(By.id("file-submit")).click();
        String actual = driver.findElement(By.id("uploaded-files")).getText();
        String expected = "2019-11-15.png";
        Assert.assertEquals(actual,expected);
        driver.quit();
    }

    /*
    Test case #8
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into
country input box.
Step 4. Verify that following message is displayed:
“You selected: United States of America”
*/
    @Test
    public void Test8(){
        driver=BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
    }

    /*
    Optional: If you want to to be a real selenium hero,
use @DataProvider for for tests cases from 9
through 12.
Please use following documentation: https://
testng.org/doc/documentationmain.
html#parameters-dataproviders

Test case #9
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “200”.
Step 4. Verify that following message is displayed:
“This page returned a 200 status code”

Test case #10
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 2. And click on “Status Codes”.
Step 3. Then click on “301”.
Step 4. Verify that following message is displayed:
“This page returned a 301 status code”
Test case #11
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “404”.
Step 5. Verify that following message is displayed:
“This page returned a 404 status code”
Test case #12
Step 1. Go to “https://practicecybertekschool.
herokuapp.com”
Step 3. And click on “Status Codes”.
Step 4. Then click on “500”.
Step 5. Verify that following message is displayed:
“This page returned a 500 status code”
     */

}
