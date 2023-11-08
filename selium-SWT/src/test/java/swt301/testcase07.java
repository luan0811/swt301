package swt301;

import POM.SavePDFPage;
import driver.driverFactory;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class testcase07 {
    public static void main(String[] args){
        WebDriver driver = driverFactory.getChromeDriver();

        driver.get("http://live.techpanda.org/");
        SavePDFPage loginPage = new SavePDFPage(driver);
        loginPage.clickMyAccountLink();
        loginPage.enterEmail("bomaythichdo@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        SavePDFPage pdfPage = new SavePDFPage(driver);
        pdfPage.clickViewOrder();
        pdfPage.clickPrintOrder();

        // Capture screenshot at the end
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("src/main/resources/screenshots/screenshot_tc07.png"));
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot!");
        }
        driver.quit();
    }
}