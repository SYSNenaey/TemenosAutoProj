package TemenosHelperPages.Teller;

import TemenosHelperPages.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CashWithdrawalForeign {
    public static WebDriver cdriver;
    public static void CashWithdrawalForeign() {


cdriver.findElement(By.xpath("//*[@id=\"pane_\"]/ul[1]/li/ul/li[8]")).click();


    }

}
