package pom_pakage_laptop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
    WebDriver driver;
    
    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")
    WebElement fetchCartPrice;
    
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
    WebElement fetchSubtotalCartPrice;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String fetchPriceOnCartPage() {
    	return fetchCartPrice.getText().replace("\\.00$", "");
    }
    
    public String fetchPriceOnSubtotalCartPage() {
    	return fetchSubtotalCartPrice.getText().trim();
    }

}
