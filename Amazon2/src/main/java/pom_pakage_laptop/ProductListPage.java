package pom_pakage_laptop;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	
    WebDriver driver;
    
    @FindBy(xpath = "(//span[@class='a-price-whole'])[4]")
    WebElement productPriceMainPage;
    
    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    WebElement productSelect;
    
    
    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public String FetchProductPrice() {
    	return productPriceMainPage.getText().trim();    
    }
    
    public void clickOnProduct() {
    	productSelect.click();    
    }
    
}


