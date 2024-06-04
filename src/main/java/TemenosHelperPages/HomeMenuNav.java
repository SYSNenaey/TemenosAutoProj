package TemenosHelperPages;

import TemenosHelperPages.IndCustomers.CreateIndCustomer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeMenuNav extends CommonMethods {
    private WebDriver cdriver = WebDriverFactory.getDriver();

    private final By FrameElements = By.xpath("//frame");

    private final By UserMenuArrow = By.cssSelector("#pane_ > ul:nth-child(1) > li > span");

    private final By CustomerMenuArrow = By.cssSelector("#pane_ > ul:nth-child(1) > li > ul > li:nth-child(2) > span");
    private final By IndividualCustomerBtn = By.xpath("//*[@id=\"pane_\"]/ul[1]/li/ul/li[2]/ul/li[1]/a");
    private final By AuthorizeDeleteCustomerBtn = By.xpath("//a[@href=\"javascript:docommand('COS CUSTOMER.NAU');\"]");
    private final By AmendCustomerBtn = By.xpath("//a[@href=\"javascript:docommand('COS CUST.AMEND');\"]");

    public void HandleAlert() throws InterruptedException {
        try {
            getAlertTextAndAcceptThisAlert();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present, continuing script execution...");
        }finally {
            switchToTheSecondFrame();
            OpenCustomerMenu();
        }

    }


    public void OpenCustomerMenu() throws InterruptedException {
        switchToTheSecondFrame();
        clickOnUserMenuArrow();
        clickOnCustomerMenuArrow();
    }
    public CreateIndCustomer clickOnIndividualCustomerBtn() {
        FindElement(IndividualCustomerBtn).click();
        return new CreateIndCustomer();
    }
    public AuthorizeIndCustomer clickOnAuthorizeDeleteCustomerBtnn() {
    FindElement(AuthorizeDeleteCustomerBtn).click();
    return new AuthorizeIndCustomer();
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
    public AmendindCustomer clickOnAmendCustomerBtnCustomerBtnn() {
        FindElement(AmendCustomerBtn).click();
        return new AmendindCustomer();
    }

    public static void MenuAuthorizeCustomer() {

    }

}