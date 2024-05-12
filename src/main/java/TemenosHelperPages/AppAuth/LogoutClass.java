package TemenosHelperPages.AppAuth;

import TemenosHelperPages.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutClass {
    private static WebDriver cdriver = WebDriverFactory.getDriver();
    public static void Logout()
    {
        //fetch logout element then click
        WebElement frameElement = cdriver.findElement(By.xpath("(//frame)[1]"));
        cdriver.switchTo().frame(frameElement);
        cdriver.findElement(By.xpath("//*[@id=\"pane_\"]/div[1]/div/table/tbody/tr/td[3]/a")).click();
    }


}
