package TemenosTest.IndCustomers.Utilities;

import Browser.Browser;
import TemenosTest.IndCustomers.BaseTest;

public class MenuCreateIndexCustomerUtilities extends BaseTest {
    public static void navToHomeMenu(Browser browser) throws InterruptedException {
        //browser.temonos.homeMenuNav.HandleAlert();
        //browser.temonos.homeMenuNav.switchToTheSecondFrame();
        browser.temonos.homeMenuNav.OpenCustomerMenu();
    }
}
