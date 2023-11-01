package swt301;

// import org.apache.commons.io.FileUtils;
// import org.junit.Assert;
// import org.openqa.selenium.By;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.Test;

// import driver.driverFactory;

// import java.io.File;
// import java.time.Duration;

// public class testcase02 {
//     @Test
//     public void runTestCase() {
//         // 1. Initialize the WebDriver
//         WebDriver driver = driverFactory.getChromeDriver();

//         try {
//             // 1. Go to http://live.techpanda.org/
//             driver.get("http://live.techpanda.org/");

//             // 2. Click on 'MOBILE' menu
//             WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
//             mobileMenu.click();

//             // 3. Read the cost of Sony Xperia mobile
//             WebElement sonyXperiaPriceElement = driver
//                     .findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/../following-sibling::div/p"));
//             String sonyXperiaPrice = sonyXperiaPriceElement.getText();

//             // 4. Click on Sony Xperia mobile
//             WebElement sonyXperiaLink = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]"));
//             sonyXperiaLink.click();

//             // 5. Read the Sony Xperia mobile from the detail page
//             WebElement sonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@id='our_price_display']"));
//             String sonyXperiaDetailPrice = sonyXperiaDetailPriceElement.getText();

//             // 6. Compare the product value in the list and details page
//             if (sonyXperiaPrice.equals(sonyXperiaDetailPrice)) {
//                 System.out.println("Product value in list and details page is equal: " + sonyXperiaPrice);
//             } else {
//                 System.out.println("Product value in list and details page is not equal.");
//             }

//             File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//             String png = ("D:\\Workspace\\swt301\\selium-SWT\\src\\test\\java\\screenshots\\TestCase02.png");
//             FileUtils.copyFile(scrFile, new File(png));
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             // Quit the browser session
//             driver.quit();
//         }
//     }
// }
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.driverFactory;

public class testcase02 {
    public static void main(String[] args) {
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 2: Click on -> MOBILE -> menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 3: In the list of all mobile, read the cost of Sony Xperia mobile (which
        // is $100)
        WebElement sonyXperiaPrice = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span"));
        String listPrice = sonyXperiaPrice.getText();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 4: Click on Sony Xperia mobile
        WebElement sonyXperiaLink = driver
                .findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/a"));
        sonyXperiaLink.click();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 5: Read the Sony Xperia mobile from detail page.
        WebElement detailPriceElement = driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/span"));
        String detailPrice = detailPriceElement.getText();

        // Add sleep
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 6: Compare Product value in list and details page should be equal
        // ($100).
        if (listPrice.equals(detailPrice)) {
            System.out.println("The prices match!");
        } else {
            System.out.println("The prices do not match!");
        }

        // Capture screenshot at the end
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc02.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }

        // Close the browser
        driver.quit();
    }
}