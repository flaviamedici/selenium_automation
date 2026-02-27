/// Test case for sorting products in an online shop
/// 1. Open https://www.testing101.net/ website
/// 2. Select Java/Shop option on the Navigation menu
/// 3. Click on the Sort by Drop-down menu
/// 4. Select "Price: Low to High" from the dropdown options
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;


public class Sorting_filter {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe" );

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.testing101.net/");

        // Step 2: Locate and hover over "Automation"
        WebElement element = driver.findElement(By.xpath("//p[@id='comp-jy5vlzj82label']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000); // Wait for the dropdown to appear (adjust as needed)

        // Step 3: Wait for "Shop" option to appear and click it
        WebElement shopOption = driver.findElement(By.xpath("//p[@id='comp-jy5vlzj8moreContainer4label']"));

        shopOption.click();
        Thread.sleep(3000); // Wait for the shop page to load (adjust as needed)

        // Step 4: Wait for the Sort by dropdown to be clickable and click it
        WebElement recommendedElement = driver.findElement(By.xpath("//div[@class='sVuWXdQ' and @data-hook='floating-dropdown-base-selected-value']"));
        recommendedElement.click();
          
        Thread.sleep(2000); // Wait for the dropdown options to appear (adjust as needed)
        // Step 5: Select "Price: Low to High" from the dropdown options
        WebElement priceLowToHighOption = driver.findElement(By.xpath("//span[contains(text(), 'Price (low to high)')]"));
        priceLowToHighOption.click();
        Thread.sleep(3000); // Wait for the products to be sorted (adjust as needed)   

    }
}