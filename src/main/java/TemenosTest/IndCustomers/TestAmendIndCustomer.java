package TemenosTest.IndCustomers;

import org.testng.annotations.Test;

import static TemenosTest.IndCustomers.BaseTest.browser;
import static TemenosTest.IndCustomers.Utilities.AmendIndCustomerUtilities.amendIndCustomer;
import static TemenosTest.IndCustomers.Utilities.AuthorizeIndCustomerUtilities.authorizeIndCustomer;
import static TemenosTest.IndCustomers.Utilities.CreateIndCustomerUtilities.createIndCustomerr;
import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;
import static TemenosTest.IndCustomers.Utilities.MenuCreateIndexCustomerUtilities.navToHomeMenu;

public class TestAmendIndCustomer {

    @Test(dataProvider = "RegisterData")
    public void createIndCustomer(String[] params){
        String Title = params[0];
        String GivenName = params[1];
        String FullName = params[2];
        String ShortName = params[3];
        String Sector = params[5];
        login(browser,"UserName","Password");
        navToHomeMenu(browser);
        createIndCustomerr(browser,Title,GivenName,FullName,ShortName,Sector);
        authorizeIndCustomer(browser,  "AuthorizeUserName", "AuthorizePassword");
        amendIndCustomer(browser,"1410014");
        authorizeIndCustomer(browser,"UserName","Password");
    }
}
