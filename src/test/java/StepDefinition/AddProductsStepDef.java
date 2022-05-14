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

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AddProductsStepDef {
    ProductListingsObj plp = new ProductListingsObj(Hooks.driver);
    Actions actions = new Actions(Hooks.driver);
    private static ArrayList<WebElement> elements;
    SoftAssert soft;
    @When("^the user has navigated to a category page: \"(.*)\"$")
    public void plpnav(String url){
        Hooks.driver.navigate().to(url);
    }
    @And ("user clicks on add to cart button of products")
    public void addProducts() throws InterruptedException {


        elements = (ArrayList<WebElement>) Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));

        for (WebElement element : elements ){

            element.findElement(By.xpath(".//button[contains(text(),'Add to cart')]")).click();
            System.out.println("Added to cart");
            Thread.sleep(1000);
            Assert.assertEquals(Hooks.driver.findElement(plp.successBar()).getText().contains("The product has been added to your shopping cart"), true);
            Thread.sleep(1000);
        } }
    @Then("user is shown an add to cart success notification")
    public void assertAddedProducts(){
        //Assert.assertEquals(Hooks.driver.findElement(plp.successBar()).getText().contains("The product has been added to your shopping cart"), true);

        System.out.println(Hooks.driver.findElement(plp.flyoutC()).getText());
       // Assert.assertTrue(Hooks.driver.findElement(plp.flyoutC()).getText().contains("There are"));
        //soft.assertEquals(Hooks.driver.findElement(plp.cartqty()).getText(), "(3)");

    }
    @And ("clicking on success bar's link navigates user to cart page")
    public void comparePageNav(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"/compareproducts\"]")).click();
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");
    }


}
