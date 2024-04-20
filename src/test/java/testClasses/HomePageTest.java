package testClasses;

import baseTest.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDetailsPage;

// Test class for testing functionality related to the Home page
public class HomePageTest extends BaseTest {

    // Test method to verify mouse hover and click functionality on the Home page
    @Test
    public void T01_HomePageTest() throws InterruptedException {
        // Open the browser and navigate to the application URL
        OpenBrowser();

        // Instantiate HomePage object with the WebDriver instance from BaseTest
        HomePage homePage = new HomePage(BaseTest.driver);
        homePage.assertPageTitle("Essence - Fashion Ecommerce Template");

        // Perform mouse hover action on the 'Pages' menu item
        homePage.mousehoverOnPagesMenu();
        Thread.sleep(5000);

        // Click on the 'Contact' link under the 'Pages' menu
        homePage.clickPageMenuContact();
    }

    // PlaceOrder test method for testing order placement functionality on the Home page
    @Test
    public void T02_PlaceOrderTest() {

        // Open the browser and navigate to the application URL
        OpenBrowser();

        // Instantiate HomePage object with the WebDriver instance from BaseTest
        HomePage homePage = new HomePage(BaseTest.driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(BaseTest.driver);
        CheckOutPage checkOutPage = new CheckOutPage(BaseTest.driver);

        // Perform mouse hover action on the 'Pages' menu item
        homePage.mousehoverOnPagesMenu();

        // Click on PagesMenu Product Details
        homePage.clickPageMenuProductDetails();

        // Click on AddToCart
        productDetailsPage.clickAddToCart();

        // Click Cart button
        productDetailsPage.clickCart();

        // Click CheckOut
        productDetailsPage.clickCheckOut();

        // Add address
        checkOutPage.enterFirstName("Hiraa");
        checkOutPage.enterLastName("Nachwani");
        //checkOutPage.selectCountryName("India");
        checkOutPage.enterStreetAddress("Vrindavan, Shiv Kailasa, Mihan");
        checkOutPage.enterPostalCode("441108");
        checkOutPage.enterTownCity("Nagpur");
        checkOutPage.enterProvince("Maharashtra");
        checkOutPage.enterPhoneNumber("9999999999");
        checkOutPage.enterEmailAddress("hiraa.nachwani@gmail.com");

        // Check terms and conditions checkbox
        checkOutPage.checkTermsAndConditions();

        // Click on Cash On Delivery link
        checkOutPage.clickCashOnDelievery();

        // Click on Place Order link
        checkOutPage.clickPlaceOrder();
    }

    // Method to run after each test have completed, quits the browser
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}