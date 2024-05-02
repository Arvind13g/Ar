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

import pom_pakage_laptop.CartPageHK;
import pom_pakage_laptop.CartPageL;
import pom_pakage_laptop.HomePageHK;
import pom_pakage_laptop.HomePageL;
import pom_pakage_laptop.ProductDetailsPageHK;
import pom_pakage_laptop.ProductDetailsPageHK2;
import pom_pakage_laptop.ProductDetailsPageL;
import pom_pakage_laptop.ProductListPageHK;
import pom_pakage_laptop.ProductListPageL;

public class VerifyHeadphoneAndKeyboard {
    
    WebDriver driver;
    HomePageHK homePagehk;
    ProductListPageHK productListPagehk;
    ProductDetailsPageHK productDetailsPagehk;
    ProductDetailsPageHK2 productDetailsPagehk2;
    CartPageHK cartPagehk;
    
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
        homePagehk = new HomePageHK(driver);
        productListPagehk = new ProductListPageHK(driver);
        productDetailsPagehk = new ProductDetailsPageHK(driver);
        productDetailsPagehk2 = new ProductDetailsPageHK2(driver);
        cartPagehk = new CartPageHK(driver);
    }
    
    @BeforeMethod
    public void performMonitorScenario() throws InterruptedException{
        driver.get("https://www.amazon.in/");
        homePagehk.sendData();
        homePagehk.clickOnSearch();
        Thread.sleep(2000);
       
        productListPagehk.clickOnProduct();
        
        ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
        String s1 = addr.get(1);
        driver.switchTo().window(s1);
        Thread.sleep(3000);
        
        productDetailsPagehk.FetchProductPrice();
        productDetailsPagehk.clickOnAddToCart();
        Thread.sleep(5000);
    
        productDetailsPagehk.clickOnClose();
        Thread.sleep(2000);
        
        productDetailsPagehk.cleardata();
        productDetailsPagehk.sendData();
        productDetailsPagehk.clickOnSearch();
        Thread.sleep(3000);
        productDetailsPagehk.clickOnProduct();
        
        ArrayList<String> addr1 = new ArrayList<String>(driver.getWindowHandles());
        String s2 = addr1.get(2);
        driver.switchTo().window(s2);
        Thread.sleep(3000);
        
        productDetailsPagehk2.FetchProductPrice();
        productDetailsPagehk2.clickOnAddToCart();
        Thread.sleep(5000);
        
        productDetailsPagehk2.fetchSubtotalMainPrice();
        productDetailsPagehk2.clickOnClose();
        Thread.sleep(2000);
        
        productDetailsPagehk2.clickOnCart();
        Thread.sleep(3000);
        
        cartPagehk.fetchPriceOnCartPage1();
        cartPagehk.fetchPriceOnCartPage2();
        cartPagehk.fetchPriceOnSubtotalCartPage();
    }
        
        @Test
        public void verifyMainPrices() {
        testID = 100;
        String text1 = productDetailsPagehk.FetchProductPrice();
        String text2 = cartPagehk.fetchPriceOnCartPage1();
        System.out.println("MainPage Price- " + text1);
        System.out.println("CartPage Price- " + text2);
        
        if(text1.equals(text2))
        {
            System.out.println("Headphone Prices Matches");
        }
        else
        {
            soft.fail();
        }
        
        String text3 = productDetailsPagehk2.FetchProductPrice();
        String text4 = cartPagehk.fetchPriceOnCartPage2();
        System.out.println("Subtotal on MainPage" + text3);
        System.out.println("Subtotal on CartPage" + text4);
        
        if(text3.equals(text4))
        {
        	System.out.println("Keyboard Prices Matches");
        }
        else
        {
        	soft.fail();
        }
        
        String text5 = productDetailsPagehk2.fetchSubtotalMainPrice();
        String text6 = cartPagehk.fetchPriceOnSubtotalCartPage();
        System.out.println("Subtotal on MainPage" + text5);
        System.out.println("Subtotal on CartPage" + text6);
        
        if(text5.equals(text6))
        {
        	System.out.println("All Subtotal Prices Matches");
        }
        else
        {
        	soft.fail();
        }
     }
    
        
        @AfterClass
        public void clearObjects() {
            homePagehk = null ;
            productListPagehk = null ;
            productDetailsPagehk = null ;
            cartPagehk = null ;
        }
        
        @AfterTest
        public void closedBrowser() {
            driver.quit();
            driver = null;
            System.gc();
        }
}
