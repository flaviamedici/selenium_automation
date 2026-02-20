import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class AssertionTrue {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.testing101.net/seleniumlocators");
    }

    @Test
    public void testFillEmailFields() {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='input_comp-lkl9bexf2']"));
        emailField.sendKeys("test@email.com");
        
        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@id='input_comp-lkl9zef6']"));
        confirmEmailField.sendKeys("test@email.com");
        
        // Get values of both fields
        String emailValue = emailField.getAttribute("value");
        String confirmEmailValue = confirmEmailField.getAttribute("value");

        // Assertwhether the values are the same
        Assert.assertTrue(emailValue.equals(confirmEmailValue), "Email and Confirm Email fields do not match!");
    }   

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
