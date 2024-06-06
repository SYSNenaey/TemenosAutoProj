package Accounts;

import TemenosTest.IndCustomers.BaseTest;
import org.testng.annotations.Test;

import static TemenosTest.IndCustomers.Utilities.AccountUtilities.*;
import static TemenosTest.IndCustomers.Utilities.AuthorizeAccountUtilities.authorizeAmendAccount;
import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;

public class TestAmendAccount extends BaseTest {

    @Test
    public void amendAccount() throws InterruptedException {
        login(browser,"UserName","Password");
        openAccountMenu();
        amendAccountDetails("190447");
        authorizeAmendAccount();
    }

}
