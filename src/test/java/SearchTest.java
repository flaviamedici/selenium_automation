import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe" );

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode


        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();
        driver.get("https://www.testing101.net/");
    }

    @Test
    public void testSearchResults() {
       try{
           WebElement searchInput = driver.findElement(By.xpath("//*[@id='input_search-box-input-comp-kr39u5ly']"));
           searchInput.sendKeys("ChatGPT");
           searchInput.submit();
           Thread.sleep(3000); // Wait for search results to load (adjust as needed)

           List<WebElement> searchResults = driver.findElements(By.xpath("//a[contains(@title, 'ChatGPT')]"));
           
           for (WebElement result : searchResults) {
                boolean containsChatGPT = result.getText().contains("ChatGPT");
                Assert.assertTrue(containsChatGPT, "Search result does not contain 'ChatGPT': " + result.getText());
                System.out.println("Search result contains 'ChatGPT': " + containsChatGPT);
                
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
