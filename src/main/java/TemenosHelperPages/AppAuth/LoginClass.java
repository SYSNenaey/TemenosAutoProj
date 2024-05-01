package TemenosHelperPages.AppAuth;

import TemenosHelperPages.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginClass {
    //Use Driver
    private static WebDriver cdriver = WebDriverFactory.getDriver();

    public static void login (String username , String password) {
        // Initialize WebDriver
        //WebDriver clogindriver = new ChromeDriver();

        // Open the URL
        cdriver.get("http://localhost:9091/R22MBR/");
        cdriver.manage().window().maximize();

        // Find username field and enter username
        cdriver.findElement(By.id("signOnName")).sendKeys(username);

        // Find password field and enter password
        cdriver.findElement(By.id("password")).sendKeys(password);

        // Click on the sign-in button
        cdriver.findElement(By.id("sign-in")).click();
        //return clogindriver ;


    }
//    public static void Driverquit () {
//        // Close the WebDriver
//
//        WebDriver clogindriver =LoginClass.login("INPUTT","123456");
//        clogindriver.quit();
//}
}
