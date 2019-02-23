package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamsPage extends NavBarPage{
    @FindBy(xpath ="//a[@href='/hogwarts'][@class='team-name']")
    WebElement webElement;

    public TeamsPage(WebDriver webDriver){
        super(webDriver);
    }
    public  HogwartsPage goTeamPage(){
        webElement.click();
        return new HogwartsPage(webDriver);
    }
}
