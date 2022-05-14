package StepDefinition;

import PageObjects.SiteWideObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.Locale;

public class SearchStepDefinition {

    SiteWideObj sitewide = new SiteWideObj(Hooks.driver);

    @When("^Logged in user type a search keyword \"(.*)\"$")
    public void search(String skey){
        Hooks.driver.findElement(sitewide.searchInputElement()).sendKeys(skey);
    }

    @And("User clicks on search")
    public void searchSubmit(){
        Hooks.driver.findElement(sitewide.searchInputElement()).sendKeys(Keys.ENTER);
    }



    @Then("^User should be navigated to search result page for \"(.*)\"$")
    public void searchResNav(String skey){

        Assert.assertEquals(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="), true);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/search?q=" + skey);
        System.out.println(Hooks.driver.findElement(sitewide.productTitle()).getText());
    }
    @And("^Search results contains search keyword \"(.*)\"$")
    public void searchAssert(String skey){
        //add for loop here after doing PLP actions
        Assert.assertEquals(Hooks.driver.findElement(sitewide.productTitle()).getText().toLowerCase(Locale.ROOT).contains(skey.toLowerCase(Locale.ROOT)),true);

    }


}
