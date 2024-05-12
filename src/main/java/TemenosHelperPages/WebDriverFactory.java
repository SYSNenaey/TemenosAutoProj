package TemenosHelperPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static WebDriver cdriver;
    public static WebDriver getDriver() {
        if (cdriver == null) {

            // Initialize ChromeDriver
            cdriver = new ChromeDriver();
        }
        return cdriver;
    }
}
