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
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9bex61']")).click();
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9bexd1']")).click();
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9bexf2']")).click();
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9zef6']")).click();
        driver.findElement(By.xpath("//select[@id='collection_comp-lkla8auc']")).click();
        driver.findElement(By.xpath("//*[text() = 'Personal' and @class='P6sHUt']")).click();
        driver.findElement(By.xpath("//*[@id='comp-lkla555k']")).click();
        driver.findElement(By.xpath("//span[text()='Submit']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
