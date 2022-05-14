package StepDefinition;

import PageObjects.ProductListingsObj;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class SwitchCatStepDef {
    ProductListingsObj plp = new ProductListingsObj(Hooks.driver);
    Actions actions = new Actions(Hooks.driver);
    private static List<WebElement> elements;
    private static List<WebElement> subelements;
    JavascriptExecutor executor = (JavascriptExecutor) Hooks.driver;
    //executor.executeScript("arguments[0].scrollIntoView(true);", element1);
    SoftAssert soft;
    @When("user hovers over a category from nav menu")
    public void menuHover() throws InterruptedException {

        elements = Hooks.driver.findElements(plp.topMenuElem());
        for (int i=0; i< 6; i++ ){
            String CurrentUrl = Hooks.driver.getCurrentUrl();
            System.out.println(i);
            //Thread.sleep(1000);
            elements = Hooks.driver.findElements(plp.topMenuElem());
            actions.moveToElement(elements.get(i)).build().perform();
            Thread.sleep(1000);
            System.out.println("sublist of i = "+ Hooks.driver.findElements(plp.sublist()).get(i).isDisplayed());

            if(Hooks.driver.findElements(plp.sublist()).get(i).isDisplayed()){
                for (int j=0 ; j<9; j++){
                    subelements = Hooks.driver.findElements(plp.subMenuElem1());
                    System.out.println("subelment of j = "+ subelements.get(j).isDisplayed());
                    if(subelements.get(j).isDisplayed()){
                        System.out.println("found one!");
                    actions.moveToElement(subelements.get(j)).perform();
                    subelements.get(j).click();}
                }

            } else {elements.get(i).click();
            }
            String NewUrl = Hooks.driver.getCurrentUrl();
           Assert.assertNotEquals(NewUrl,CurrentUrl);

        }


    }
    @Then("user should be navigated to this new subcategory")
    public void assertnav(){
        Assert.assertNotEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");

    }
}
