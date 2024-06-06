package TemenosTest.IndCustomers.Utilities;

import Browser.Browser;
import TemenosTest.IndCustomers.BaseTest;
import org.testng.Assert;

import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;

public class AmendIndCustomerUtilities extends BaseTest {
    public static void amendIndCustomer(Browser browser, String customerNo) throws InterruptedException {
        login(browser,"AuthorizeUserName","AuthorizePassword");
        browser.temonos.homeMenuNav.OpenCustomerMenu();
        browser.temonos.amendindCustomer = browser.temonos.homeMenuNav.clickOnAmendCustomerBtnCustomerBtnn();
        browser.temonos.amendindCustomer.switchToTheOpenedNewWindow();
        browser.temonos.amendindCustomer.MaximizeWindow();
        browser.temonos.amendindCustomer.switchToTheFirstFrame();
        browser.temonos.amendindCustomer.enterCustomerNOInCustomerField(customerNo);
        browser.temonos.amendindCustomer.clickOnFindButton();
        browser.temonos.amendindCustomer.clickOnAmendEditIcon();
        browser.temonos.amendindCustomer.switchToTheOpenedNewWindow();
        browser.temonos.amendindCustomer.switchToTheSecondFrame();
        browser.temonos.amendindCustomer.SelectAmendRankDroplist();
        browser.temonos.createIndCustomer.clickOnTitleDropdownList("Dr");
        browser.temonos.createIndCustomer.enterGBShortNameField("Ayman");
        browser.temonos.createIndCustomer.clickOnValidateDealBtn();
        browser.temonos.createIndCustomer.clickOnCommitDealBtn();
        browser.temonos.createIndCustomer.checkTheCustomerisExistedBeforeAndOverride();
        Assert.assertTrue(browser.temonos.authorizeIndCustomer.getAuthorizeMsg().contains("Txn Complete: " + browser.temonos.createIndCustomer.getCustomerNo()));
        browser.temonos.authorizeIndCustomer.closeTheOpenedNewWindow();
        browser.temonos.authorizeIndCustomer.switchToOriginalWindow();
        browser.temonos.logout.Logout();
        browser.temonos.authorizeIndCustomer.switchToOriginalWindow();
    }
}
