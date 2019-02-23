package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NavBarPage {
    @FindBy(tagName="input")
    WebElement webElement ;
WebDriver webDriver;
    public NavBarPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
    }

    public void searchKeyWord(String value){
        webElement.clear();
        webElement.sendKeys(value);
        Actions actions = new Actions(webDriver);
        actions.sendKeys(Keys.ENTER).perform();
        Reporter.log(value,true);
    }

}
