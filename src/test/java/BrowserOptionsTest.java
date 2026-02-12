import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserOptionsTest {
    @Test
    public void openGoogleChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--start-maximize");
        //options.addArguments("--window-size=500,500");
        //options.addArguments("lang=fr");
        options.addArguments("lang=en");
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();

    }
}
