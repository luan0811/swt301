package swt301;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;


import static java.lang.Thread.sleep;

@Test
public class testcase10 {

    /*
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Input OrderId and FromDate -> ToDate
5. Click Search button
6. Screenshot capture.
     */
    @Test
    public  void tc10(){
        
        String orderId = "100021115";
        String fromDate = "11/1/2023";
        String toDate = "11/7/2023";
        WebDriver driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php/backendlogin");
        //2. Login the credentials provided
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("user01");
        WebElement password = driver.findElement(By.xpath("//input[@id='login']"));
        password.sendKeys("guru99com");
        driver.findElement(By.xpath("//input[@title='Login']")).click();
        //Go to Sales-> Orders menu
        driver.findElement(By.xpath("//span[normalize-space()='close']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
        //4. Input OrderId and FromDate -> ToDate
        WebElement orderID = driver.findElement(By.xpath("//input[@id='sales_order_grid_filter_real_order_id']"));
        orderID.sendKeys(orderId);
        WebElement dateFrom = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)"));
        dateFrom.sendKeys(fromDate);
        WebElement dateTo = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > table:nth-child(1) > thead:nth-child(2) > tr:nth-child(2) > th:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)"));
        dateTo.sendKeys(toDate);
        //5. 5. Click Search button
        driver.findElement(By.xpath("//span[contains(text(),'Search')]")).click();
        try {
            sleep(2000);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc10.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }

        driver.quit();





        // Wait for the file to be downloaded





    }
}
