import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
@Test
    public void findElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--start-maximize");
        
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.testing101.net/");
        Thread.sleep(3000);

        //Find the sapn element with the specificed text
        WebElement spanElement = driver.findElement(By.xpath("//span[text()='Software Testing 101']"));
        
        //Assert that the text of the span element is as expected
        Assert.assertEquals(spanElement.getText(), "Software Testing 101");


    }
}