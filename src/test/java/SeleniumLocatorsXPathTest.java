import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SeleniumLocatorsXPathTest {
    @Test
    public void findElements() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--start-maximize");
        
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.testing101.net/seleniumlocators");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select")).click();
        driver.findElement(By.xpath("//*[text() = 'Personal' and @class='P6sHUt']")).click();
        driver.findElement(By.xpath("//button//span[text()='Submit']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
