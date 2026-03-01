//Test case
//1. Open https://www.testing101.net/
//2.Select Java/Shop option on the Navigation menu
//3. CLick on the Product 1 title
//4. Click on the Add to Cart button
//5. Click on the All Products breadcrumbs
//6. Click on the Product 2 title
//7. Select the color and click on the Add to Cart button

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(fExtentReportListener.class)

public class MiniCart {

    WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium_sample\\chromedriver-win32\\chromedriver.exe");

        // Instantiate ChromeDriver
        driver = new ChromeDriver();

        // Maximize the Chrome window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://www.testing101.net/");

        //Use this line of code in case the test script is failed due to Consent Pop-up
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//p[text()='Consent']")).click();
    }

    @Test
    public void testPricesOrder() throws InterruptedException {
        Thread.sleep(2000);
        // Hover over the element by XPath
        WebElement element = driver.findElement(By.xpath("//li[@id='comp-jy5vlzj82']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);

        // Click on the "Shop" element of the Java drop-down menu by XPath
        Thread.sleep(2000);
        WebElement shopElement = driver.findElement(By.xpath("//p[@id='comp-jy5vlzj8moreContainer4label']"));
        shopElement.click();
        Thread.sleep(2000);

        //Product
        WebElement product1 = driver.findElement(By.xpath("//p[text()='ChatGPT']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product1);
        product1.click();
        Thread.sleep(2000);

        //CLick add to cart button
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(span, 'Add to Cart')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        addToCartButton.click();
        Thread.sleep(2000);

        //CLick to close the cart sidebar
        WebElement closeCartButton = driver.findElement(By.xpath("//button[@data-hook='Header.closeButton']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeCartButton);
        closeCartButton.click();
        Thread.sleep(2000);

        WebElement allProductsLink = driver.findElement(By.xpath("//a[text()='All Products']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allProductsLink);
        allProductsLink.click();
        Thread.sleep(2000);

        WebElement product2 = driver.findElement(By.xpath("//p[text()='Latte']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product2);
        product2.click();
        Thread.sleep(2000);

        //color picker
        new Actions(driver).click(driver.findElement(By.xpath("//div[@data-hook='color-picker-item-tooltip']//div[@style='background-color: rgb(0, 0, 0);']"))).perform();

        WebElement addToCartButton2 = driver.findElement(By.xpath("//button[@data-hook='add-to-cart']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton2);
        addToCartButton2.click();
        Thread.sleep(2000);
        
        // Get the web elements for order total and item prices
        WebElement orderTotalElement = driver.findElement(By.xpath("//span[@data-hook='Footer.estimatedTotalValue']"));
        WebElement itemPriceElement1 = driver.findElement(By.xpath("(//div[@class='OoDGxd'])[1]"));
        WebElement itemPriceElement2 = driver.findElement(By.xpath("(//div[@class='OoDGxd'])[2]"));

        // Get the text values of the elements
        String orderTotal = orderTotalElement.getText().trim();
        String itemPrice1 = itemPriceElement1.getText().trim();
        String itemPrice2 = itemPriceElement2.getText().trim();

        // Parse the text values to extract the numerical values
        double orderTotalValue = Double.parseDouble(orderTotal.replace("US$", "").replace(".", ""));
        double itemPrice1Value = Double.parseDouble(itemPrice1.replace("US$", "").replace(".", ""));
        double itemPrice2Value = Double.parseDouble(itemPrice2.replace("US$", "").replace(".", ""));

        // Calculate the expected total
        double expectedTotal = itemPrice1Value + itemPrice2Value;

        // Assert that the order total equals the sum of the item prices
        Assert.assertEquals(orderTotalValue, expectedTotal, "Order total does not match the sum of item prices");
     
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
