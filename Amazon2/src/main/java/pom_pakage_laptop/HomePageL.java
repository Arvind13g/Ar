package pom_pakage_laptop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageL {
	
    WebDriver driver;
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchbar;
    
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchbutton;
    
    public HomePageL(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void sendData() {
        searchbar.sendKeys("Laptop");    
    }
    
    public void clickOnSearch() {
        searchbutton.click();
    }

}
