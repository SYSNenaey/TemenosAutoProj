package TemenosTest.IndCustomers;

import Browser.Browser;
import TemenosHelperPages.WebDriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Bool;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

import static TemenosTest.IndCustomers.TestCreateIndCustomer.headers;

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
    // String customerNo =
    String filePath= "datafiles/testdata2525.xlsx";

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
    /// read data from excel
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


    @DataProvider(name = "excelData")
    public Iterator<Object[]> getDataFromExcel() throws IOException {

        String fileName = "testdata2525.xlsx";
        fillExcel("1001", headers, 3, fileName, 2);

        FileInputStream file = new FileInputStream(fileName);
        XSSFWorkbook workbook1 = new XSSFWorkbook(file);
        int sheets = workbook1.getNumberOfSheets();
        List<List<Object>> data = new ArrayList<>();
        for (int i = 0; i < sheets; i++) {
            if (workbook1.getSheetName(i).equalsIgnoreCase("1001")) {
                XSSFSheet sheet = workbook1.getSheetAt(i);
                int rowCount = sheet.getLastRowNum();
                int colCount = sheet.getRow(0).getLastCellNum();
                for (int l = 1; l <= rowCount; l++) {
                    Row row = sheet.getRow(l);
                    List<Object> rowData = new ArrayList<>();
                    for (int j = 0; j < colCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    rowData.add(cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    rowData.add(cell.getNumericCellValue());
                                    break;
                                default:
                                    rowData.add(null);
                            }
                        } else {
                            rowData.add(null);
                        }

                    }
                    data.add(rowData);
                }

            }
        }
        workbook1.close();
        file.close();
        List<Object[]> dataArray = new ArrayList<>();
        for (List<Object> row : data) {
            dataArray.add(row.toArray(new Object[0]));
        }
        return dataArray.iterator();
    }


    public void fillExcel(String sheetName, String[] headers, int numRows, String fileName, int preDefinedColumns) throws IOException {
        FileInputStream file = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        // Write headers in row 0 starting from column 2
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            headerRow = sheet.createRow(0);
        }
        for (int i = 0; i < headers.length; i++) {
            headerRow.createCell(i + preDefinedColumns).setCellValue(headers[i]);
        }

        Faker faker = new Faker(new Locale("en-US")); // Use English locale for Faker
        for (int rowIdx = 1; rowIdx <= numRows; rowIdx++) {
            Row dataRow = sheet.getRow(rowIdx);
            if (dataRow == null) {
                dataRow = sheet.createRow(rowIdx);
            }
            for (int colIdx = preDefinedColumns; colIdx < headers.length + preDefinedColumns; colIdx++) {
                String header = headers[(colIdx - preDefinedColumns)].toLowerCase(); // Convert header to lowercase for Faker method
                String fakeData = null;
                switch (header) {
                    case "givenname":
                        fakeData = faker.name().name();
                        break;
                    case "fullname":
                        fakeData = faker.name().fullName();
                        break;
                    case "shortname":
                        fakeData = faker.name().firstName();
                        break;
                    case "mnemonic":
                        fakeData = faker.letterify("A") + faker.number().digits(10);
                        break;
                }
                dataRow.createCell(colIdx).setCellValue(fakeData);
            }
        }

        file.close();
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }
    public String returnSheetName(String fileName, int sheetIndx) throws IOException {
        FileInputStream file = new FileInputStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        String sheetName = String.valueOf(workbook.getSheetName(sheetIndx));
        return sheetName;
    }



    int rowIndex = 1;
        public void retrieveOutPutDataAndPassitTOLastColumn(String[] headers, String testResult, String headerTitle,String SheetName) throws IOException {
        System.out.println(testResult);
        FileInputStream file = new FileInputStream("testdata2525.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(SheetName);
        int lastRowIndex = sheet.getLastRowNum();
        int columnIndex = headers.length + 2;
        Row headerRow = sheet.getRow(0);
        Cell headerCell = headerRow.createCell(headers.length + 2);
        headerCell.setCellValue(headerTitle);
                  Row row = sheet.getRow(rowIndex);
            Cell resultCell = row.createCell(columnIndex);
            resultCell.setCellValue(testResult);
        rowIndex++;
        FileOutputStream fileOut = new FileOutputStream("testdata2525.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    /*@DataProvider(name = "excelData")
    public Iterator<Object[]> getDataFromExcel() throws IOException {

        generateExcel("TestData", headers, 3, "testdata2525.xlsx");

        FileInputStream file = new FileInputStream("testdata2525.xlsx");
        XSSFWorkbook workbook1 = new XSSFWorkbook(file);
        int sheets = workbook1.getNumberOfSheets();
        List<List<Object>> data = new ArrayList<>();
        for (int i = 0; i < sheets; i++) {
            if (workbook1.getSheetName(i).equalsIgnoreCase("TestData")) {
                XSSFSheet sheet = workbook1.getSheetAt(i);
                int rowCount = sheet.getLastRowNum();
                int colCount = sheet.getRow(0).getLastCellNum();
                for (int l = 1; l <= rowCount; l++) {
                    Row row = sheet.getRow(l);
                    List<Object> rowData = new ArrayList<>();
                    for (int j = 0; j < colCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    rowData.add(cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    rowData.add(cell.getNumericCellValue());
                                    break;
                                default:
                                    rowData.add(null);
                            }
                        } else {
                            rowData.add(null);
                        }
                    }
                    data.add(rowData);
                }

            }
        }
        workbook1.close();
        file.close();
        List<Object[]> dataArray = new ArrayList<>();
        for (List<Object> row : data) {
            dataArray.add(row.toArray(new Object[0]));
        }
        return dataArray.iterator();
    }


    public void generateExcel(String sheetName, String[] headers, int numRows, String fileName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        Row headerRow = sheet.createRow(0);
        for (int i = 2; i < headers.length; i++) {
            headerRow.createCell(i).setCellValue(headers[i]);
        }

        Faker faker = new Faker(new Locale("en-US")); // Use English locale for Faker
        for (int rowIdx = 1; rowIdx <= numRows; rowIdx++) {
            Row dataRow = sheet.createRow(rowIdx);
            for (int colIdx = 2; colIdx < headers.length; colIdx++) {
                String header = headers[colIdx].toLowerCase(); // Convert header to lowercase for Faker method
                String fakeData;
                switch (header) {
                    case "givenname":
                        fakeData = faker.name().name();
                        break;
                    case "fullname":
                        fakeData = faker.name().fullName();
                        break;
                    case "shortname":
                        fakeData = faker.name().firstName();
                        break;
                    case "mnemonic":
                        fakeData = faker.letterify("A") + faker.number().digits(10);
                        break;
                    default:
                        fakeData = "No Faker method for " + headers[colIdx];
                }

                dataRow.createCell(colIdx).setCellValue(fakeData);
            }
        }

        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }



/*public void fillExistingExcelWithFakerData(String sheetName, String[] headers, String fileName) throws IOException {
    FileInputStream file = new FileInputStream(fileName);
    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheet(sheetName);

    Faker faker = new Faker(new Locale("en-US")); // Use English locale for Faker
    int lastRowIndex = sheet.getLastRowNum();
    int firstDataColumn = 2; // Assuming first two columns are pre-filled

    for (int rowIdx = 1; rowIdx <= lastRowIndex; rowIdx++) {
        Row dataRow = sheet.getRow(rowIdx);
        for (int colIdx = firstDataColumn; colIdx < headers.length; colIdx++) {
            Cell cell = dataRow.getCell(colIdx, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.BLANK) {
                String header = headers[colIdx].toLowerCase(); // Convert header to lowercase for Faker method
                String fakeData;
                switch (header) {
                    case "givenname":
                        fakeData = faker.name().name();
                        break;
                    case "fullname":
                        fakeData = faker.name().fullName();
                        break;
                    case "shortname":
                        fakeData = faker.name().firstName();
                        break;
                    case "mnemonic":
                        fakeData = faker.letterify("A") + faker.number().digits(10);
                        break;
                    default:
                        fakeData = "No Faker method for " + headers[colIdx];
                }

                cell.setCellValue(fakeData);
            }
        }
    }

    file.close();

    FileOutputStream fileOut = new FileOutputStream(fileName);
    workbook.write(fileOut);
    fileOut.close();
    workbook.close();
}
    @DataProvider(name = "excelData")
    public Iterator<Object[]> getDataFromExcel() throws IOException {
        String fileName = "testdata2525.xlsx";
        fillExistingExcelWithFakerData("Sector 1001", headers, fileName);

        FileInputStream file = new FileInputStream(fileName);
        XSSFWorkbook workbook1 = new XSSFWorkbook(file);
        int sheets = workbook1.getNumberOfSheets();
        List<List<Object>> data = new ArrayList<>();
        for (int i = 0; i < sheets; i++) {
            if (workbook1.getSheetName(i).equalsIgnoreCase("TestData")) {
                XSSFSheet sheet = workbook1.getSheetAt(i);
                int rowCount = sheet.getLastRowNum();
                int colCount = sheet.getRow(0).getLastCellNum();
                for (int l = 1; l <= rowCount; l++) {
                    Row row = sheet.getRow(l);
                    List<Object> rowData = new ArrayList<>();
                    for (int j = 0; j < colCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    rowData.add(cell.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    rowData.add(cell.getNumericCellValue());
                                    break;
                                default:
                                    rowData.add(null);
                            }
                        } else {
                            rowData.add(null);
                        }
                    }
                    data.add(rowData);
                }
            }
        }
        workbook1.close();
        file.close();
        List<Object[]> dataArray = new ArrayList<>();
        for (List<Object> row : data) {
            dataArray.add(row.toArray(new Object[0]));
        }
        return dataArray.iterator();
    }

 */

}


