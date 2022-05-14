package StepDefinition;

import PageObjects.ProductListingsObj;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class CompareStepDefinition {
    ProductListingsObj plp = new ProductListingsObj(Hooks.driver);
    Actions actions = new Actions(Hooks.driver);
    private static ArrayList<WebElement> elements;
    SoftAssert soft;

    @And("user clicks on add to comparlist button of products")
    public void addtoComparelist() throws InterruptedException {

        elements = (ArrayList<WebElement>) Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));

        for (WebElement element : elements ){

            element.findElement(By.xpath(".//button[contains(text(),'Add to compare list')]")).click();
            System.out.println("added to compare list");
            Thread.sleep(1000);

        }

    }

    @Then("user is shown an add comparlist success notification")
    public void assertAddedtoCL(){
        Assert.assertEquals(Hooks.driver.findElement(plp.successBar()).getText().contains("The product has been added to your product comparison"), true);
        //System.out.println(Hooks.driver.findElement(plp.cartqty()).getText());

    }
    @And ("clicking on success bar's link navigates user to compare page")
    public void comparePageNav(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"/compareproducts\"]")).click();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/compareproducts");
    }

}
