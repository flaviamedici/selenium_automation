import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class eAssertions {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe" );

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
    }

    @Test
    public void testSpanText() throws InterruptedException {
        // Open the website
        driver.get("https://www.testing101.net/");

        // Find the span element with the specified text
        WebElement spanElement = driver.findElement(By.xpath("//span[text()='Software Testing 101']"));

        // Assert that the text of the span element is as expected
        Assert.assertEquals(spanElement.getText(), "Software Testing 101");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
