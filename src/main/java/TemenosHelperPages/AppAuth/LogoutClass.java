package TemenosHelperPages.AppAuth;

import TemenosHelperPages.CommonMethods;
import TemenosHelperPages.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutClass extends CommonMethods {
  //  private static WebDriver cdriver = WebDriverFactory.getDriver();


    private final By FirstFrame = By.xpath("(//frame)[1]");
    private final By SignOffBtn = By.xpath("//*[@id=\"pane_\"]/div[1]/div/table/tbody/tr/td[3]/a");
    public void Logout()
    {

        //fetch logout element then click
        WebElement frameElement = FindElement(FirstFrame);
        SwitchFrameByWebElement(frameElement);
        FindElement(SignOffBtn).click();
    }


}
