package swt301;
import POM.ReOrderPage;
import driver.driverFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class testcase08 {

    public static void main(String[] args) {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        ReOrderPage reOrderPage = new ReOrderPage(driver);
        reOrderPage.clickAccount();
        reOrderPage.clickLogin();
        reOrderPage.inputEmailAndPassword("bomaythichdo@example.com", "password123");
        reOrderPage.clickLoginSubmit();
        reOrderPage.clickReorderBtn();
        boolean check1 = reOrderPage.addShippingCost();
        reOrderPage.inputQuantity(100);
        reOrderPage.updateQuantity();
       // reOrderPage.clickShippingCostButton();
        boolean check = reOrderPage.addShippingCost();
        if(check1!=check) {
            Assert.assertEquals(check1,check);
        }
       // reOrderPage.clickShippingCostButton();
        reOrderPage.clickEstimate();
        reOrderPage.clickProceedBtn();
        reOrderPage.clickContinueBtn1();
        reOrderPage.clickContinueBtn2();
        reOrderPage.clickCheckMoneyOrder();
        reOrderPage.clickContinueBtn3();
        reOrderPage.clickPlaceOrder();

        // Capture screenshot at the end
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc08.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }
        driver.quit();
    }
}