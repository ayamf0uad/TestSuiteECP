package StepDefinition;

import PageObjects.ProductListingsObj;
import PageObjects.SiteWideObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CurrencyStepDefinition {
    SiteWideObj sitewide = new SiteWideObj(Hooks.driver);

    SoftAssert soft = new SoftAssert();
    Select selectCurrencyObj = new Select(Hooks.driver.findElement(sitewide.selectCurrencyElement()));
    List<WebElement> elements;

    @When("Logged in user clicks on currency dropdown list")
    public void currencyClick() {
        Hooks.driver.findElement(sitewide.selectCurrencyElement()).click();
    }


    @And("user selects another currency")
    public void changeCurrency() throws InterruptedException {
        Thread.sleep(1000);

            selectCurrencyObj.selectByVisibleText("Euro");

    }
    @Then("products' prices should change to this currency")
    public void assertPriceChange() {
        elements = Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));
        for(WebElement element:elements) {
            Assert.assertEquals(Hooks.driver.findElement(sitewide.productPrice()).getText().contains("€"), true);
        }
    }



}
