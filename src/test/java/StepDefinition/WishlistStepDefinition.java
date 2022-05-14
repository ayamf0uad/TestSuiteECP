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

public class WishlistStepDefinition {
    ProductListingsObj plp = new ProductListingsObj(Hooks.driver);
    Actions actions = new Actions(Hooks.driver);
    private static ArrayList<WebElement> elements;
    SoftAssert soft;

    @And("user clicks on add to wishlist button of products")
    public void addtoWishlist() throws InterruptedException {

        elements = (ArrayList<WebElement>) Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));

        for (WebElement element : elements ){

            element.findElement(By.xpath(".//button[contains(text(),'Add to wishlist')]")).click();
            System.out.println("Added to wishlist");
            Thread.sleep(1000);

        }

    }

    @Then("user is shown an add wishlist success notification")
    public void assertAddedtoWL(){
        Assert.assertEquals(Hooks.driver.findElement(plp.successBar()).getText().contains("The product has been added to your wishlist"), true);

    }
    @And ("clicking on success bar's link navigates user to wishlist page")
    public void wishlistNav(){

        Hooks.driver.findElement(By.cssSelector("a[href=\"/wishlist\"]")).click();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/wishlist");
    }

}
