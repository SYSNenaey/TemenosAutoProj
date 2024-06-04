package TemenosTest.IndCustomers.Utilities;

import Browser.Browser;
import TemenosTest.IndCustomers.BaseTest;

public class CreateIndCustomerUtilities extends BaseTest {
   public  String customerNo ;
    public String createIndCustomerr(Browser browser, String Title, String GivenName, String FullName, String ShortName, String Sector, String Monemoic, String gender) throws InterruptedException {
        //browser.temonos.createIndCustomer.clickOnIndividualCustomerBtn();
        browser.temonos.createIndCustomer= browser.temonos.homeMenuNav.clickOnIndividualCustomerBtn();
        browser.temonos.createIndCustomer.switchToTheOpenedNewWindow();
        browser.temonos.createIndCustomer.MaximizeWindow();
        browser.temonos.createIndCustomer.clickOnTitleDropdownList(Title);
        browser.temonos.createIndCustomer.enterGivenName(GivenName);
        browser.temonos.createIndCustomer.enterGBFullNamefield(FullName);
        browser.temonos.createIndCustomer.enterGBShortNameField(ShortName);
        browser.temonos.createIndCustomer.clickOnGenderButton(gender);
        browser.temonos.createIndCustomer.enterMonemoicField(Monemoic);
        browser.temonos.createIndCustomer.enterSectorField(Sector);
        browser.temonos.createIndCustomer.clickOnValidateDealBtn();
        browser.temonos.createIndCustomer.clickOnCommitDealBtn();
        try {
            browser.temonos.createIndCustomer.checkTheCustomerisExistedBeforeAndOverride();
        } catch (Exception e) {
            System.out.println("Accept Override button is not displayed.");
        } finally {
             customerNo =   browser.temonos.createIndCustomer.setCustomerNo();
            browser.temonos.createIndCustomer.closeTheOpenedNewWindow();
            browser.temonos.createIndCustomer.switchToOriginalWindow();
            browser.temonos.logout.Logout();
            browser.temonos.createIndCustomer.switchToOriginalWindow();
        }
        return customerNo;
    }
}
