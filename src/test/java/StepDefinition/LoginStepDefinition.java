package StepDefinition;

import PageObjects.LoginObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinition {

    LoginObj login = new LoginObj(Hooks.driver);

    @Given("User navigates to login page")
    public void userlogNav() {
        Hooks.driver.findElement(login.loginel()).click();
    }

    @When("^User enters a valid \"(.*)\" and \"(.*)\"$")
    public void validCred(String email, String password) throws InterruptedException {
        login.LoginSteps(email, password);
    }
    @And("User clicks on login")
    public void loginClick(){

        login.logClick();
    }
    @Then("User should login successfully")
    public void successLogin(){
        String expectedRes = "Log out";
        String actualRes = Hooks.driver.findElement(login.logoutElement()).getText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        Assert.assertEquals(actualRes.contains(expectedRes), true);

    }
    @And("Navigates to HP")
    public void navToHP(){
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
    }
}
