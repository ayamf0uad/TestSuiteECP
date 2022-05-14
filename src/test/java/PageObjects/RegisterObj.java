package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegisterObj {

    WebDriver driver;
    public RegisterObj(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement firstNameElement(){
        By firstName = By.id("FirstName");
        WebElement firstNameElement = driver.findElement(firstName);
        return firstNameElement;
    }

    public WebElement lastNameElement(){
        By lastName = By.id("LastName");
        WebElement lastNameElement = driver.findElement(lastName);
        return lastNameElement;
    }

    public WebElement emailElement(){
        By email = By.id("Email");
        WebElement emailElement = driver.findElement(email);
        return emailElement;
    }

    public WebElement passwordElement(){
        By password = By.id("Password");
        WebElement passwordElement = driver.findElement(password);
        return passwordElement;
    }

    public WebElement confirmPasswordElement(){
        By confirmPassword = By.id("ConfirmPassword");
        WebElement confirmPasswordElement = driver.findElement(confirmPassword);
        return confirmPasswordElement;
    }

    public By successRegel() {return By.className("result");}

    public By continueBtn() {return By.cssSelector("a[href=\"/\"]");}

    public By fnErr() {return By.id("FirstName-error");}
    public By lnErr() {return By.id("LastName-error");}
    public By emailErr() {return By.id("Email-error");}
    public By validEmailErr() {return By.id("Email-error");}
    public By passMatchErr() {return By.id("ConfirmPassword-error");}
    public By validPassErr() {return By.id("Password-error");}
    public By existingEmailErr() {return By.className("message-error");}


    public void RegSteps(String firstName, String lastName, String email, String password, String confirmPassword) throws InterruptedException {
        firstNameElement().clear();
        firstNameElement().sendKeys(firstName);
        Thread.sleep(1000);
        lastNameElement().sendKeys(lastName);
        Thread.sleep(1000);
        emailElement().sendKeys(email);
        Thread.sleep(1000);
        passwordElement().sendKeys(password);
        Thread.sleep(1000);
        confirmPasswordElement().sendKeys(confirmPassword);
        Thread.sleep(1000);
    }

}
