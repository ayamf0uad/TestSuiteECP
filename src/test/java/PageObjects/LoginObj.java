package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObj {

    WebDriver driver;

    public LoginObj(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "Email")
    WebElement emailInput;
    @FindBy(id = "Password")
    WebElement passInput;

    public By logoutElement()
    {
        return By.cssSelector("a[href=\"/logout\"]");
    }
    public By forgetPasswordElement()
    {
        return By.cssSelector("a[href=\"/passwordrecovery\"]");
    }
    public By resetPasswordMsg()
    {
        return By.id("bar-notification");
    }
    public By loginel()
    {
        return By.className("ico-login");
    }




    public void LoginSteps(String email, String password) throws InterruptedException {
        emailInput.clear();
        emailInput.sendKeys(email);
        Thread.sleep(1000);
        passInput.sendKeys(password);
        Thread.sleep(1000);
    }

    public void logClick(){
        passInput.sendKeys(Keys.ENTER);
    }
    public void FPCin(String email){
       emailInput.sendKeys(email);
    }
    public void FPClick(){
        emailInput.sendKeys(Keys.ENTER);
    }

}
