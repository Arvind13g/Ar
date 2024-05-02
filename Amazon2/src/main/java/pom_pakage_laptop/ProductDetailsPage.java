package pom_pakage_laptop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
    WebDriver driver;
    
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;
    
    @FindBy(xpath = "//span[@id='attach-accessory-cart-subtotal']")
    WebElement FetchSubtotalMainPage;
    
    @FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
    WebElement Close;
    
    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement SeeCart;
    
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickOnAddToCart() {
    	addToCart.click();    
    }
    
    public String fetchSubtotalMainPrice() {
    	return FetchSubtotalMainPage.getText().trim();
    }
    
    public void clickOnClose() {
    	Close.click();    
    }
    
    public void clickOnCart() {
    	SeeCart.click();
    }

}

