package swt301;

// import driver.driverFactory;

// import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.By;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.Test;
// import org.testng.Assert;

// import java.io.File;
// import java.io.IOException;
// import java.time.Duration;

// public class testcase03 {
//     @Test
//     public void runTestCase() {

//         // 1. Initialize the WebDriver
//         WebDriver driver = driverFactory.getChromeDriver();

//         // 2. Navigate to the website
//         driver.get("http://live.techpanda.org/");
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//         // 3. Find and click on the 'MOBILE' menu
//         WebElement mobileMenu = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
//         mobileMenu.click();

//         // 4. Find and click on 'ADD TO CART' for Sony Xperia mobile
//         WebElement addToCartButton = driver.findElement(By.xpath(
//                 "//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//button[@title='Add to Cart']"));
//         addToCartButton.click();

//         // 5. Find the 'QTY' input field and change its value to 1000
//         WebElement qtyInput = driver.findElement(By.cssSelector("input[title='Qty']"));

//         qtyInput.sendKeys("000");

//         // Find and click the 'UPDATE' button
//         WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
//         updateButton.click();

//         // 6. Verify the error message
//         WebElement errorMessage = wait
//                 .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.error-msg span")));
//         // String expectedErrorMessage = "The requested quantity for Sony Xperia is not
//         // available";
//         // Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
//         String expectedErrorMessage = "Some of the products cannot be ordered in requested quantity.";
//         Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);

//         // 7. Click on 'EMPTY CART' link in the footer of the list of all mobiles
        
//         WebElement emptyCartLink = wait
        
//                 .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Empty Cart']")));
//         emptyCartLink.click();

//         // 8. Verify cart is empty
//         WebElement emptyCartMessage = wait
//                 .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-title h1")));
//         String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
//         Assert.assertEquals(emptyCartMessage.getText(), expectedEmptyCartMessage);

//         // Capture screenshot at the end
//         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
//         try {
//             FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc03.png"));
//             System.out.println("Screenshot captured!");
//         } catch (IOException e) {
//             e.printStackTrace();
//             System.out.println("Failed to capture screenshot!");
//         }
//         // 9. Quit the browser session
//         driver.quit();
//     }
// }
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driver.driverFactory;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class testcase03 {
    public static void main(String[] args) {
        WebDriver driver = driverFactory.getChromeDriver();

        // Step 1: Go to http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on -> MOBILE -> menu
        WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
        mobileMenu.click();

        // Step 3: In the list of all mobile, click on -> ADD TO CART -> for Sony Xperia mobile
        WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/following-sibling::div/button"));
        addToCartButton.click();

        // Step 4: Change -> QTY -> value to 1000 and click -> UPDATE -> button.
        WebElement qtyInput = driver.findElement(By.cssSelector("#qty"));
        qtyInput.clear();
        qtyInput.sendKeys("1000");
        
        WebElement updateButton = driver.findElement(By.cssSelector("button[title='Add to Cart']"));
        updateButton.click();

        // Step 5: Verify the error message
        WebElement errorMessage = driver.findElement(By.cssSelector("li[class='error-msg'] ul li"));
        String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";
        
        if (errorMessage.getText().equals(expectedErrorMessage)) {
            System.out.println("The error message is correct!");
        } else {
            System.out.println("The error message is incorrect!");
        }

        // Step 6: Then click on -> EMPTY CART -> link in the footer of list of all mobiles.
        WebElement emptyCartLink = driver.findElement(By.cssSelector("a[title='Empty Cart']"));
        emptyCartLink.click();

        // Step 7: Verify cart is empty
        WebElement cartMessage = driver.findElement(By.cssSelector(".cart-empty"));
        
        if (cartMessage.getText().contains("SHOPPING CART IS EMPTY")) {
            System.out.println("The cart is empty!");
        } else {
            System.out.println("The cart is not empty!");
        }

        // Capture screenshot at the end
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        
        try {
            FileUtils.copyFile(scrFile, new File("D:\\Workspace/swt301/selium-SWT/src/test/java/screenshots/screenshot_tc03.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }

        // Close the browser
        driver.quit();
    }
}