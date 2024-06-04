package TemenosTest.IndCustomers.Utilities;

import TemenosTest.IndCustomers.BaseTest;
import Browser.Browser;

public class LoginUtilties extends BaseTest {
    public static void login(Browser browser,String UserName, String Password) throws InterruptedException {
        browser.temonos.login.login(data.getPropertyValue(UserName), data.getPropertyValue(Password));
        browser.temonos.homeMenuNav = browser.temonos.login.clickOnSignIn();
    }
}
