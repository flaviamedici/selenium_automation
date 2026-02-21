import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class AssertionNotNull{

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.testing101.net/seleniumlocators");
    }

    @Test
    public void testInputField() {
        try{
            WebElement firstNameInput = driver.findElement(By.xpath("//input[@name='first-name']"));
        firstNameInput.sendKeys("John");

        Thread.sleep(2000); // Optional: Wait for a moment to see the effect

        // Assert whether the value is not null
        Assert.assertNotNull(firstNameInput.getAttribute("maxlength"), "Maxlength attribute is not null!");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("an exception occurred: " + e.getMessage());
        }
        
    }   

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

