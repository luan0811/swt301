package swt301;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class testcase09 {
    /* 1. Go to http://live.techpanda.org/

2. Go to Mobile and add IPHONE to cart

3. Enter Coupon Code

4. Verify the discount generated */
@Test
    public void tc09(){
        
        WebDriver driver = new ChromeDriver();
        driver.get("http://live.techpanda.org/");
        //2. Go to Mobile and add IPHONE to cart
        WebElement Mobilemenu = driver.findElement(By.linkText("MOBILE"));
        Mobilemenu.click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/button[1]")).click();
        //3. Enter Coupon Code
        WebElement Coupon = driver.findElement(By.id("coupon_code"));
        Coupon.sendKeys("GURU50");
        driver.findElement(By.xpath("//span[contains(text(),'Apply')]")).click();
        //4. 4. Verify the discount generated
        WebElement originalPrice = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']"));
        WebElement discountedPriceElement = driver.findElement(By.xpath("//strong//span[@class='price'][normalize-space()='$500.00']"));

        String originalPriceText = originalPrice.getText();
        String discountedPriceText = discountedPriceElement.getText();

        assert !originalPriceText.equals(discountedPriceText) : "Total price is not discounted";

        System.out.println("Original Price: " + originalPriceText);
        System.out.println("Discounted Price: " + discountedPriceText);

File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc09.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }



        driver.quit();
    }
}
