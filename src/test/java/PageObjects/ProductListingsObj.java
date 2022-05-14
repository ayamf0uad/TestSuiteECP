package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductListingsObj {
    WebDriver driver;
    public ProductListingsObj(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public By topMenuElem() {return By.xpath(".//ul[@class=\"top-menu notmobile\"]/li/a");}
    public By topMenuElem1() {return By.xpath(".//div[@class=\"menu-toggle\"]/following-sibling::ul/li/a");}
   public By sublist(){return By.className("sublist");}
   // public By sublist(){return By.xpath(".//ul[@class=\"sublist first-level\"]");}

    //ul[@class="top-menu notmobile"]/li//ul[@class="sublist first-level"]
    public By startTopMenuEl() {return By.xpath(".//a[contains(text(),'Electronics')]");}
    public By subMenuElem() {return By.xpath(".//ul[@class=\"sublist first-level\"]/li/a");}
    public By subMenuElem1() {return By.xpath(".//ul[@class=\"top-menu notmobile\"]/li/ul[@class=\"sublist first-level\"]/li/a");}
    public By apparelElem() {return By.xpath(".//a[contains(text(),'Apparel')]");}
    public By shoesElem() {return By.xpath(".//a[contains(text(),'Shoes')]");}
    public By redcheck(){return By.id("attribute-option-15");}
    public By productRed(){return By.cssSelector("a[href=\"/adidas-consortium-campus-80s-running-shoes\"]");}
    public By awesomeTag(){return By.cssSelector("a[href=\"/awesome\"]");}
    public By coolTag(){return By.cssSelector("a[href=\"/cool\"]");}
    public By tagA(){return By.className("page-title");}
    public By successBar(){return By.className("bar-notification");}
    public By cartqty(){return By.xpath(".//div[@class=\"count\"]//a");}
    public By flyoutC(){return By.className("flyout-cart");}
}
