package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

//according to page obj model design
//we have to create corresponded page class
//for each page of app
//login page = login page class
//every page class will store webelements and methods related to that page
public class LoginPage extends BasePage{
    @FindBy(id="prependedInput")//this line will initialize we element
    public WebElement userNameInput;

    @FindBy(id="prependedInput2")//without FinBy, web element will be null
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='alert alert-error']")
    public WebElement warningMessage;




    public LoginPage(){
        //it is mandotory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver obj
        PageFactory.initElements(Driver.get(), this);
    }

    /*
    reusable login method
    just call this to login provide username and password
    @param userName
    @param password
     */
    public void login(String username, String passoword){
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(passoword, Keys.ENTER);
    }

}
