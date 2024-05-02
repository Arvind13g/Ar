package pom_pakage_laptop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPageHK {
	
WebDriver driver;
    
    @FindBy(xpath = "(//span[@class='a-price-whole'])[5]")
    WebElement productPriceMainPage;
    
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;
    
    @FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
    WebElement Close;
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement Clear;
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchbar2;
    
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchbutton2;
    
    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    WebElement productSelect2;
    
    
//    @FindBy(xpath = "//a[@id='nav-cart']")
//    WebElement SeeCart;
    
    public ProductDetailsPageHK(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String FetchProductPrice() {
    	return productPriceMainPage.getText();    
    }
    
    public void clickOnAddToCart() {
    	addToCart.click();    
    }
    
    public void clickOnClose() {
    	Close.click();    
    }
    
    public void cleardata() {
    	Clear.clear();
    }
    
    public void sendData() {
        searchbar2.sendKeys("Keyboard");    
    }
    
    public void clickOnSearch() {
        searchbutton2.click();
    }
    
    public void clickOnProduct() {
    	productSelect2.click();    
    }
    
//    public void clickOnCart() {
//    	SeeCart.click();
//    }

}
