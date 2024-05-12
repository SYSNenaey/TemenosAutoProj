package TemenosTest.IndCustomers;

import Browser.Browser;
import TemenosHelperPages.WebDriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.WebDriverException;

public class BaseTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    public static ExtentSparkReporter spark;
    protected WebDriverFactory webDriverFactory;

    protected static ReadProprtiesFile data;

    protected static Browser browser;

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports();
        test = extent.createTest(getClass().getSimpleName());
        spark = new ExtentSparkReporter(new File("target/".concat(test.toString())));
        extent.attachReporter(spark);
    }

    @BeforeTest
    public void Setup() throws IOException {
        webDriverFactory = new WebDriverFactory();
        browser = new Browser();
        data = new ReadProprtiesFile("src/main/java/Resources/Temenos-config.proprties");
        webDriverFactory.navigateTo(data.getPropertyValue("TemonosLink"));
    }


    @AfterMethod
    public void AfterStep(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentTestNGUtil.getExtentColor(Status.FAIL)));
            test.fail(result.getThrowable());
            try {
                getScreenshotAndSaveToFile(result.getName() + "_failure");
                test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Passed ", ExtentTestNGUtil.getExtentColor(Status.PASS)));
            getScreenshotAndSaveToFile(result.getName() + "_PASSED");
            test.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentTestNGUtil.getExtentColor(Status.SKIP)));
        }
        extent.flush();
    }

    public String getBase64Screenshot() {
        return ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

//    @AfterTest()
//    public void tearDown() {
//        WebDriverFactory.resetCache();
//        WebDriverFactory.quit();
//    }

    public void getScreenshotAndSaveToFile(String fileName) {
        try {
            File srcFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshots/" + fileName + ".png");
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }
}


