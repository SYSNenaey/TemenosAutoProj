package TemenosTest.IndCustomers;

import Browser.Browser;
import TemenosHelperPages.WebDriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Locale;

import org.openqa.selenium.WebDriverException;

public class BaseTest {

    private static ExtentReports extent;
    private static ExtentTest test;
    public static ExtentSparkReporter spark;
    protected WebDriverFactory webDriverFactory;

    protected static ReadProprtiesFile data;

    protected static Browser browser;

    public static Faker faker;

    Locale locale = new Locale("en");

    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports();
        test = extent.createTest(getClass().getSimpleName());
        spark = new ExtentSparkReporter(new File("target/".concat(test.toString())));
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void Setup() throws IOException {
        webDriverFactory = new WebDriverFactory();
        browser = new Browser();
        faker = new Faker(locale);
        data = new ReadProprtiesFile("src/main/java/Resources/Temenos-config.proprties");
        webDriverFactory.navigateTo(data.getPropertyValue("TemonosLink"));
        System.out.println("Running before each Test");
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

    @AfterMethod()
    public void tearDown() {
        WebDriverFactory.resetCache();
       WebDriverFactory.quit();
        System.out.println("close the browser After each Test");
    }

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
    @DataProvider(name = "RegisterData")
    public Object[][] readDataFromExcel() throws IOException {
        String excelFilePath = "datafiles/temnos data.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        Object[][] data = new Object[rows][cols];
        for (int r = 0; r < rows; r++) {
            XSSFRow row = sheet.getRow(r + 1);
            Object[] rowData = new Object[cols];
            for (int c = 0; c < cols; c++) {
                XSSFCell cell = row.getCell(c);
                switch (cell.getCellType()) {
                    case STRING:
                        rowData[c] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        rowData[c] = Integer.toString((int) (cell.getNumericCellValue()));
                        break;
                    case BOOLEAN:
                        rowData[c] = cell.getBooleanCellValue();
                        break;
                }
            }
            data[r] = rowData;
        }
        return data;
    }
}


