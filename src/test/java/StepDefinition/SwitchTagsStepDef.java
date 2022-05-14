package StepDefinition;

import PageObjects.ProductListingsObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SwitchTagsStepDef {

    ProductListingsObj plp = new ProductListingsObj(Hooks.driver);
    Actions actions = new Actions(Hooks.driver);

    @When("user navigates to a product listing page and filter by tags")
    public void tagPLPNav(){
        actions.moveToElement(Hooks.driver.findElement(plp.apparelElem())).perform();
        Hooks.driver.findElement(plp.shoesElem()).click();
        Hooks.driver.findElement(plp.awesomeTag()).click();
    }
    @And ("user clicks on another tag")
    public void tagClick(){
        Hooks.driver.findElement(plp.coolTag()).click();
    }
    @Then("user is navigated to the related page of this tag")
    public void assertag(){
        Assert.assertTrue(Hooks.driver.findElement(plp.tagA()).getText().contains("cool"));
    }

}
