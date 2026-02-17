import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssertionNotEqual {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.testing101.net/seleniumlocators");
    }

    @Test
    public void testCheckBoxState() {
        try {
            WebElement checkbox = driver.findElement(By.xpath("//input[@data-testid='input' and @type='checkbox']"));

            //Scroll the checkbox into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

            //Verify the initial state of the checkbox
            Assert.assertNotEquals(checkbox.isSelected(), true, "Checkbox is initially checked");

            //Click on the checkbox
            checkbox.click();

            //Wait for a brief moment to see the effect (Optional)
            Thread.sleep(2000);

            //Verify the state of the checkbox after clicking
            Assert.assertNotEquals(checkbox.isSelected(), false, "Checkbox is not checked after clicking");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
