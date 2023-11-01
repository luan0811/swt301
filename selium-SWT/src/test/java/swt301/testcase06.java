package swt301;

import POM.PurchasePage;
import driver.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class testcase06 {
    @Test
    public void testVerifyUserToPurchaseProduct() {
        WebDriver driver = driverFactory.getChromeDriver();

            driver.get("http://live.techpanda.org/");

            PurchasePage purchasePage = new PurchasePage(driver);
            purchasePage.clickMyAccountLink();
            purchasePage.clickLoginAccountLink();
            //Enter value to login
            purchasePage.enterEmailLogin("luan2@gmail.com");
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


        driver.quit();
    }
}