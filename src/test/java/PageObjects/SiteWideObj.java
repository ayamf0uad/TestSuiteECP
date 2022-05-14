package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SiteWideObj {

    WebDriver driver;
    public SiteWideObj(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public By selectCurrencyElement() {
        return By.id("customerCurrency");
    }



    public By productPrice() {
        return By.className("price");
    }


    public By searchInputElement()
    {
        return By.id("small-searchterms");
    }

    public By productTitle()
    {
        return By.className("product-title");
    }

}
