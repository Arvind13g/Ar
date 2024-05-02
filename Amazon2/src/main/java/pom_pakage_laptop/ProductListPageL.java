package pom_pakage_laptop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPageL {
	
    WebDriver driver;
     
    @FindBy(xpath = "(//img[@class='s-image'])[1]")
    WebElement productSelect;
    
    
    public ProductListPageL(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void clickOnProduct() {
    	productSelect.click();    
    }
    
}


