package pages;

import basePages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends BasePage {

WebDriver driver;
    // Constructor for ContactPage class
    public ContactPage(WebDriver driver) {
        super(driver);
        // Assigning the WebDriver instance passed as parameter to the local driver variable
        this.driver = driver;
        // Initializing elements using PageFactory to enable Page Object Model
        PageFactory.initElements(driver, this);
    }

    // Method to accept an alert
    public void acceptAlert() {
        // Switching to the alert and accepting it
        driver.switchTo().alert().accept();
    }

}
