package Accounts;

import TemenosTest.IndCustomers.BaseTest;
import org.testng.annotations.Test;

import static TemenosTest.IndCustomers.Utilities.AccountUtilities.*;
import static TemenosTest.IndCustomers.Utilities.AuthorizeAccountUtilities.authorizeSavAccount;
import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;

public class TestOpenSavingAccount extends BaseTest {

    @Test
    public void openSavingAccount() throws InterruptedException {
        login(browser,"UserName","Password");
        openAccountMenu();
        fillSavingAccountDetails("190447","USD");
        authorizeSavAccount();
    }

}
