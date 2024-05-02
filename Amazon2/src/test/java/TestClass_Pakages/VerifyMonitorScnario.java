package TestClass_Pakages;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pom_pakage_laptop.CartPage;
import pom_pakage_laptop.HomePage;
import pom_pakage_laptop.ProductDetailsPage;
import pom_pakage_laptop.ProductListPage;

public class VerifyMonitorScnario {
    
    WebDriver driver;
    HomePage homePage;
    ProductListPage productListPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    
    int testID ;
    static ExtentTest test;
    static ExtentHtmlReporter reporter;
    
    SoftAssert soft = new SoftAssert();
    
    @SuppressWarnings("deprecation")
    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32\\chromedriver.exe");
        reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
        ExtentReports extend = new ExtentReports();
        extend.attachReporter(reporter);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }
    
    @BeforeClass
    public void createObjects() {
        homePage = new HomePage(driver);
        productListPage = new ProductListPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
    }
    
    @BeforeMethod
    public void performMonitorScenario() throws InterruptedException{
        driver.get("https://www.amazon.in/");
        homePage.sendData();
        homePage.clickOnSearch();
        Thread.sleep(2000);
        
        productListPage.FetchProductPrice();
        productListPage.clickOnProduct();
        
        ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
        String s1 = addr.get(1);
        driver.switchTo().window(s1);
        
        productDetailsPage.clickOnAddToCart();
        Thread.sleep(5000);
        productDetailsPage.fetchSubtotalMainPrice();
        productDetailsPage.clickOnClose();
        Thread.sleep(2000);
        productDetailsPage.clickOnCart();
        
        Thread.sleep(3000);
        cartPage.fetchPriceOnCartPage();
        cartPage.fetchPriceOnSubtotalCartPage();
    }
        
        @Test
        public void verifyPrices() {
        testID = 100;
        String text1 = productListPage.FetchProductPrice();
        String text2 = cartPage.fetchPriceOnCartPage();
        System.out.println("MainPage Price- " + text1);
        System.out.println("CartPage Price- " + text2);
        
        if(text1.equals(text2))
        {
            System.out.println("Monitor Prices Matches");
        }
        else
        {
            soft.fail();
        }
        
        String text3 = productDetailsPage.fetchSubtotalMainPrice();
        String text4 = cartPage.fetchPriceOnSubtotalCartPage();
        System.out.println("Subtotal on MainPage" + text3);
        System.out.println("Subtotal on CartPage" + text4);
        
        if(text3.equals(text4))
        {
        	System.out.println("Monitor Subtotal Prices Matches");
        }
        else
        {
        	soft.fail();
        }
     }
    
        
        @AfterClass
        public void clearObjects() {
            homePage = null ;
            productListPage = null ;
            productDetailsPage = null ;
            cartPage = null ;
        }
        
        @AfterTest
        public void closedBrowser() {
            driver.quit();
            driver = null;
            System.gc();
        }
}
