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
        //First Name
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9bex61']")).sendKeys("Mary");;
        //Last Name
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9bexd1']")).sendKeys("Smith");
        //Email
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9bexf2']")).sendKeys("test@email.com");;
        //Confirm Email
        driver.findElement(By.xpath("//*[@id='input_comp-lkl9zef6']")).sendKeys("test@email.com");;
        //Dropdown
        driver.findElement(By.xpath("//select[@id='collection_comp-lkla8auc']")).click();
        driver.findElement(By.xpath("//*[text() = 'Personal' and @class='P6sHUt']")).click();
        //Accept terms checkbox
        driver.findElement(By.xpath("//*[@id='comp-lkla555k']")).click();
        //Submit button
        driver.findElement(By.xpath("//span[text()='Submit']")).click();

        Thread.sleep(5000);
        driver.quit();

    }
}
