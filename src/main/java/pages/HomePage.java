package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends NavBarPage {
@FindBy(xpath ="//a[contains(@href, '/teams')]")
WebElement webElement;
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public TeamsPage clickHref(){
       webElement.click();
       return new TeamsPage(webDriver);
    }
    public void gotoSearchResult(String value){
        searchKeyWord(value);
    }
}
