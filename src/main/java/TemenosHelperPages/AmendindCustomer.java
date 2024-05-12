package TemenosHelperPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AmendindCustomer extends CommonMethods {
    private final By AmendCustomerBtn = By.xpath("//a[@href=\"javascript:docommand('COS CUST.AMEND');\"]");

    private final By CustomerNoField = By.xpath("//input[@id='value:1:1:1']");

    public final By FindBtn = By.xpath("//a[@href='javascript:void(0)']");

    private final By AmendEditIcon = By.cssSelector("a[title=\"Amend\"]");
    private final By AmendRankDroplist = By.xpath("//*[@id=\"tab1\"]/tbody/tr[10]/td[7]/a[1]/img");
    private final By selectRank = By.cssSelector("tr[id='dropDownRow2']");
    private final By FrameElements = By.xpath("//frame");


    public void clickOnAmendCustomerBtnCustomerBtnn() {
        FindElement(AmendCustomerBtn).click();
    }

    public void switchToTheFirstFrame() {
        WebElement frameElementOne = cdriver.findElements(By.tagName("frame")).getFirst();
        SwitchFrameByWebElement(frameElementOne);
    }

    public void enterCustomerNOInCustomerField(String enterCustomerNo) {
        FindElement(CustomerNoField).clear();
        FindElementtoBeClickable(CustomerNoField).sendKeys(enterCustomerNo);
    }

    public void clickOnFindButton() {
        FindElement(FindBtn).click();
    }

    public void clickOnAmendEditIcon() {
        FindElement(AmendEditIcon).click();
    }

    public void switchToTheSecondFrame() {
        List<WebElement> frameElement2 = cdriver.findElements(FrameElements);
        WebElement SecondFrameElement = frameElement2.get(1);
        SwitchFrameByWebElement(SecondFrameElement);
    }

    public void SelectAmendRankDroplist() {
        FindElement(AmendRankDroplist).click();
        FindElement(selectRank).click();
    }

//    public String getAuthorizeMsg() {
//        String AuthorizeMsg = FindElement(completeTxn).getText();
//        return AuthorizeMsg;
//
//    }
}
