package StepDefinition;

import PageObjects.RegisterObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterStepDefintion {

    RegisterObj register = new RegisterObj(Hooks.driver);

    @And("User navigates to registration page")
    public void userRegNav() {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("^User enters valid credentials '(.*)' and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void valid_data(String fn, String ln, String e, String p, String cp) throws InterruptedException {
        register.RegSteps(fn,ln,e,p,cp);
    }

    @And("User clicks register button")
    public void userClick() throws InterruptedException {
        register.confirmPasswordElement().sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("User can register successfully")
    public void successReg(){
        String expectedRes = "Your registration completed";
        String actualRes = Hooks.driver.findElement(register.successRegel()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }
    @And("navigates to success reg page")
    public void successResNav(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
    }

    @Then("First name error message appears")
    public void blankFN(){
        String expectedRes = "First name is required.";
        String actualRes = Hooks.driver.findElement(register.fnErr()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }

    @Then("Last name error message appears")
    public void blankLN(){
        String expectedRes = "Last name is required.";
        String actualRes = Hooks.driver.findElement(register.lnErr()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }

    @Then("Email error message appears")
    public void blankEmail(){
        String expectedRes = "Email is required.";
        String actualRes = Hooks.driver.findElement(register.emailErr()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }

    @Then("Invalid email error message appears")
    public void invalidEmail(){
        String expectedRes = "Wrong email";
        String actualRes = Hooks.driver.findElement(register.validEmailErr()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }

    @Then("Password match error message appears")
    public void passMatch(){
        String expectedRes = "The password and confirmation password do not match.";
        String actualRes = Hooks.driver.findElement(register.passMatchErr()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }

    @Then("Valid password error message appears")
    public void validPass(){
        String expectedRes = "Password must meet the following rules:\n" +
                "must have at least 6 characters";
        String actualRes = Hooks.driver.findElement(register.validPassErr()).getText();
        System.out.println(actualRes);
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }

    @Then("Email exists error message appears")
    public void ExiEmail(){
        String expectedRes = "The specified email already exists";
        String actualRes = Hooks.driver.findElement(register.existingEmailErr()).getText();
        System.out.println(actualRes);
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);
    }


}
