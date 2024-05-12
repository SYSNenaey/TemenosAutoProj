package TemenosHelperPages.IndCustomers;

import TemenosHelperPages.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class CreateIndCustomer {
    private static WebDriver cdriver = WebDriverFactory.getDriver();

    public static void CreateIndCustomer()
    {
     // Click on Menu Link
        cdriver.findElement(By.xpath("//*[@id=\"pane_\"]/ul[1]/li/ul/li[2]/ul/li[1]/a")).click();
        // Get all window handles
        Set<String> windowHandles = cdriver.getWindowHandles();
        String originalWindowHandle = cdriver.getWindowHandle();
        // Switch to the last opened window
        String lastWindowHandle = (String) windowHandles.toArray()[windowHandles.size() - 1];
        cdriver.switchTo().window(lastWindowHandle);

        // Maximize Window
        cdriver.manage().window().maximize();

        // Locate the title dropdown element by its ID
        WebElement titledropdownElement = cdriver.findElement(By.id("fieldName:TITLE"));
        // Create a Select object
        Select titledropdown = new Select(titledropdownElement);
        // Select the option by visible text
        titledropdown.selectByVisibleText("Doctors");
        cdriver.findElement(By.id("fieldName:GIVEN.NAMES")).sendKeys("andrew6");
        cdriver.findElement(By.id("fieldName:NAME.1:1")).sendKeys("andrew6");
        cdriver.findElement(By.id("fieldName:SHORT.NAME:1")).sendKeys("andrew6");
        cdriver.findElement(By.id("radio:tab1:GENDER")).click();
        cdriver.findElement(By.id("fieldName:MNEMONIC")).sendKeys("A1258656576");
        cdriver.findElement(By.id("fieldName:SECTOR")).sendKeys("1001");
        cdriver.findElement(By.xpath("//*[@id=\"goButton\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/a/img")).click();
        cdriver.findElement(By.xpath("//*[@id=\"goButton\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/a/img")).click();
        cdriver.close();
        // Switch to original window
        cdriver.switchTo().window(originalWindowHandle);
    }
}
