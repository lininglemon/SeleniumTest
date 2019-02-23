package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage extends NavBarPage {
    public SignInPage(WebDriver webDriver){
        super(webDriver);
    }
    public String isSignIn(){
        String text = "";
        WebElement webElement = webDriver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        if(webElement.isDisplayed()){
            text=webElement.getText();
        }
        return text;
    }
}
