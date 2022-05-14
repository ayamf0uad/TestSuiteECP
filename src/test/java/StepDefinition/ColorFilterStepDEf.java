package StepDefinition;

import PageObjects.ProductListingsObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class ColorFilterStepDEf {
    ProductListingsObj plp = new ProductListingsObj(Hooks.driver);
    Actions actions = new Actions(Hooks.driver);

    @When("that the user has navigated to a PLP page with color filter available")
    public void apparelnav(){
        actions.moveToElement(Hooks.driver.findElement(plp.apparelElem())).perform();
        Hooks.driver.findElement(plp.shoesElem()).click();
    }
    @And("user selects a color")
    public void pickColor(){
        Hooks.driver.findElement(plp.redcheck()).click();
    }

    @Then("listings are filtered to only show products with this color")
    public void filterAssert(){

        Assert.assertTrue(Hooks.driver.findElement(plp.productRed()).isDisplayed());

    }
}
