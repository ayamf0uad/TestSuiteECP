package StepDefinition;

import PageObjects.LoginObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class ForgetPassStepDef {
    LoginObj login = new LoginObj(Hooks.driver);

    @And("User Clicks on forget password")
    public void fPClick(){
        Hooks.driver.findElement(login.forgetPasswordElement()).sendKeys(Keys.ENTER);
    }
    @And("^enter \"(.*)\" and clicks on recover$")
    public void recoverPass(String email){
        login.FPCin(email);
        login.FPClick();
    }
    @Then("User is shown a success message")
    public void resetPasswordSuccess(){
        String expectedRes = "Email with instructions has been sent to you.";
        String actualRes = Hooks.driver.findElement(login.resetPasswordMsg()).getText();
        System.out.println(actualRes);
        Assert.assertTrue(actualRes.contains(expectedRes));

    }

}
