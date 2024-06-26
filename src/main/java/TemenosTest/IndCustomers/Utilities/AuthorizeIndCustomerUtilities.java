package TemenosTest.IndCustomers.Utilities;

import Browser.Browser;
import TemenosTest.IndCustomers.BaseTest;
import org.testng.Assert;

import static TemenosTest.IndCustomers.Utilities.MenuCreateIndexCustomerUtilities.navToHomeMenu;

public class AuthorizeIndCustomerUtilities extends BaseTest {
    public static void authorizeIndCustomer(Browser browser, String authUsername, String authPassword){
        browser.temonos.login.login(data.getPropertyValue(authUsername), data.getPropertyValue(authPassword));
        browser.temonos.homeMenuNav.HandleAlert();
        browser.temonos.authorizeIndCustomer.clickOnAuthorizeDeleteCustomerBtnn();
        browser.temonos.authorizeIndCustomer.switchToTheOpenedNewWindow();
        browser.temonos.authorizeIndCustomer.MaximizeWindow();
        browser.temonos.authorizeIndCustomer.clickOnSearchBtnclickOnSearchBtn();
        browser.temonos.authorizeIndCustomer.enterCustomerNOInIDField(browser.temonos.createIndCustomer.getCustomerNo());
        browser.temonos.authorizeIndCustomer.clickOnFindButton();
        browser.temonos.authorizeIndCustomer.clickOnauthorizeBtn();
        browser.temonos.authorizeIndCustomer.clickOnauthorizDealeBtn();
        Assert.assertTrue(browser.temonos.authorizeIndCustomer.getAuthorizeMsg().contains("Txn Complete: " + browser.temonos.createIndCustomer.getCustomerNo()));
        browser.temonos.authorizeIndCustomer.closeTheOpenedNewWindow();
        browser.temonos.authorizeIndCustomer.switchToOriginalWindow();
        browser.temonos.logout.Logout();
        browser.temonos.authorizeIndCustomer.switchToOriginalWindow();
    }
}
