package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmupFindHowMuchLink {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/");
        //to find all link ==> ctrl+f => search every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));

        /*
        findElement VS findElements
     findElement=> if there is no element found, you will exeption ==> NoSuchElementExeption
                => only 1 webelement
     findElements=> 0 or more elements
     if list is empty, that means that element is not there
     in this way, we can ensure that element does not present
         */

        // //a[.='Home'] or //a[text()='Home'] - find link with text name Home
        System.out.println("Number of links: " + links.size());

        //what if I want to print text of all links, one by one
        //loop through the collection of links
        for (WebElement webElement : links) {
            //print text of every link
            System.out.println(webElement.getText());
        }
        driver.quit();
    }
}
