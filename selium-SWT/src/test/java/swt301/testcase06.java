package swt301;

import POM.PurchasePage;
import driver.driverFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testcase06 {
    @Test
    public void tc06() {
        WebDriver driver = driverFactory.getChromeDriver();

            driver.get("http://live.techpanda.org/");

            PurchasePage purchasePage = new PurchasePage(driver);
            purchasePage.clickMyAccountLink();
            purchasePage.clickLoginAccountLink();
            //Enter value to login
            purchasePage.enterEmailLogin("luan3@gmail.com");
            purchasePage.enterPasswordLogin("123456");
            purchasePage.clickLoginButton();

            purchasePage.clickWishList();
            purchasePage.clickAddToCartButton();
            purchasePage.inputEstimate("Vietnam", "HCM", 700000);
            purchasePage.clickEstimate();
            purchasePage.clickShippingCostButton();
            boolean check = purchasePage.addShippingCost();
            Assert.assertTrue(check);
//

            purchasePage.clickShippingCostButton();
            purchasePage.clickUpdateButton();
            purchasePage.clickCheckoutButton();
            purchasePage.inputAddress("HCM HCM HCM");
            purchasePage.inputCity("Ha Noi");
            purchasePage.inputState();
            purchasePage.inputZip("1234534");
            purchasePage.inputPhone("0932343463");
            purchasePage.clickContinueBtn1();
            purchasePage.clickContinueBtn2();
            purchasePage.clickCheckMoneyOrder();
            purchasePage.clickContinueBtn3();
            purchasePage.clickPlaceOrder();


             File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc06.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }
        driver.quit();
    }
}