import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        WebElement confirmEmailField = driver.findElement(By.xpath("//input[@id='input_comp-lkl9bexf3']"));
        confirmEmailField.sendKeys("test@email.com");
        
    }   
}
