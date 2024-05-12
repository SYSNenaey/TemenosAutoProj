package TemenosHelperPages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeMenuNav extends CommonMethods {
    private static WebDriver cdriver = WebDriverFactory.getDriver();

    private final By FrameElements = By.xpath("//frame");

    private final By UserMenuArrow = By.cssSelector("#pane_ > ul:nth-child(1) > li > span");

    private final By CustomerMenuArrow = By.cssSelector("#pane_ > ul:nth-child(1) > li > ul > li:nth-child(2) > span");


    public void HandleAlert() {
        try {
            getAlertTextAndAcceptThisAlert();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present, continuing script execution...");
        }

    }


    public void OpenCustomerMenu() {
        clickOnUserMenuArrow();
        clickOnCustomerMenuArrow();
    }


    public void clickOnUserMenuArrow() {
        FindElement(UserMenuArrow).click();
    }

    public void clickOnCustomerMenuArrow() {
        FindElement(CustomerMenuArrow).click();
    }

    public void switchToTheSecondFrame() {
        List<WebElement> frameElement2 = cdriver.findElements(FrameElements);
        WebElement SecondFrameElement = frameElement2.get(1);
        SwitchFrameByWebElement(SecondFrameElement);
    }

    public void switchToTheFirstFrame() {
        WebElement frameElementOne = cdriver.findElements(By.tagName("frame")).getFirst();
        SwitchFrameByWebElement(frameElementOne);
    }


    public static void MenuAuthorizeCustomer() {

    }

}