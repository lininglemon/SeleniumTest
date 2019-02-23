package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HogwartsPage extends NavBarPage{
    public HogwartsPage(WebDriver webDriver){
        super(webDriver);
    }
    public SignInPage gotoFirstTopic(){
        List<WebElement> webElements = webDriver.findElements(By.xpath("//div[@class='panel topics']//a[contains(@href,'/topics/')]"));
        webElements.get(0).click();
        return new SignInPage(webDriver);
    }
}
