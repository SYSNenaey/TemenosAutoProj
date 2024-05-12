package TemenosTest.IndCustomers;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class TestCreateIndCustomer extends BaseTest {

    @Test
    public void testCreateIndCustomer() {
        // Create Ind Customer
        Login();
        MenuCreateIndCustomer();
        CreateIndCustomer();
        AuthorizeMainCustomer();
        AmendCustomer();
        // Amend Ind Customer
    }

    public void Login() {
        browser.temonos.login.login(data.getPropertyValue("UserName"), data.getPropertyValue("Password"));
    }

    public void MenuCreateIndCustomer() {
        //LoginClass.login("INPUTT","123456");
        browser.temonos.homeMenuNav.HandleAlert();
        browser.temonos.homeMenuNav.switchToTheSecondFrame();
        browser.temonos.homeMenuNav.OpenCustomerMenu();
        //CreateIndCustomer.CreateIndCustomer();
        //LogoutClass.Logout();
        //LoginClass.login("AUTHOR","1234567");
    }

    public void CreateIndCustomer() {

        browser.temonos.createIndCustomer.clickOnIndividualCustomerBtn();

        browser.temonos.createIndCustomer.switchToTheOpenedNewWindow();
        browser.temonos.createIndCustomer.MaximizeWindow();

        browser.temonos.createIndCustomer.clickOnTitleDropdownList("Doctors");

        browser.temonos.createIndCustomer.enterGivenName("andrew6");

        browser.temonos.createIndCustomer.enterGBFullNamefield("andrew6");

        browser.temonos.createIndCustomer.enterGBShortNameField("andrew6");

        browser.temonos.createIndCustomer.clickOnGenderButton();

        browser.temonos.createIndCustomer.enterMonemoicFieldAutomatically();

        browser.temonos.createIndCustomer.enterSectorField("1001");

        browser.temonos.createIndCustomer.clickOnValidateDealBtn();

        browser.temonos.createIndCustomer.clickOnCommitDealBtn();

        browser.temonos.createIndCustomer.checkTheCustomerisExistedBeforeAndOverride();


        browser.temonos.createIndCustomer.setCustomerNo();
        browser.temonos.createIndCustomer.closeTheOpenedNewWindow();

        browser.temonos.createIndCustomer.switchToOriginalWindow();
        browser.temonos.logout.Logout();
        browser.temonos.createIndCustomer.switchToOriginalWindow();
        browser.temonos.login.login(data.getPropertyValue("AuthorizeUserName"), data.getPropertyValue("AuthorizePassword"));
        //LoginClass.login("INPUTT","123456");
        //HomeMenuNav.MenuCreateIndCustomer();
        //LogoutClass.Logout();
        //LoginClass.login("AUTHOR","1234567");
    }

    public void AuthorizeMainCustomer() {
        MenuCreateIndCustomer();
        AuthorizeCustomer();
        browser.temonos.login.login(data.getPropertyValue("AuthorizeUserName"), data.getPropertyValue("Password"));
        // Assert.assertEquals(browser.temonos.authorizeIndCustomer.getAuthorizeMsg(),"Txn Complete");


    }

    public void AuthorizeCustomer(){
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

    public void AmendCustomer() {
        MenuCreateIndCustomer();
        browser.temonos.amendindCustomer.clickOnAmendCustomerBtnCustomerBtnn();
        browser.temonos.amendindCustomer.switchToTheOpenedNewWindow();
        browser.temonos.amendindCustomer.MaximizeWindow();
        browser.temonos.amendindCustomer.switchToTheFirstFrame();
        browser.temonos.amendindCustomer.enterCustomerNOInCustomerField(browser.temonos.createIndCustomer.getCustomerNo());
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
        browser.temonos.login.login(data.getPropertyValue("UserName"), data.getPropertyValue("Password"));
        MenuCreateIndCustomer();
        AuthorizeCustomer();
        // browser.temonos.authorizeIndCustomer.clickOnauthorizeBtn();
        //  browser.temonos.authorizeIndCustomer.clickOnauthorizDealeBtn();
        //Assert.assertTrue(browser.temonos.authorizeIndCustomer.getAuthorizeMsg().contains("Txn Complete: " + browser.temonos.createIndCustomer.getCustomerNo()));
        //  browser.temonos.authorizeIndCustomer.closeTheOpenedNewWindow();
        //  browser.temonos.authorizeIndCustomer.switchToOriginalWindow();
        // Assert.assertEquals(browser.temonos.authorizeIndCustomer.getAuthorizeMsg(),"Txn Complete");


    }

    public static void Logout() {
        //LoginClass.login("INPUTT","123456");
        //HomeMenuNav.MenuCreateIndCustomer();
        //CreateIndCustomer.CreateIndCustomer();
        browser.temonos.logout.Logout();
        //LoginClass.login("AUTHOR","1234567");
    }

    public void LoginAuth() throws IOException {
        //LoginClass.login("INPUTT","123456");
        //HomeMenuNav.MenuCreateIndCustomer();
        //CreateIndCustomer.CreateIndCustomer();
        //LogoutClass.Logout();
        browser.temonos.login.login("AUTHOR", "1234567");
    }
}
