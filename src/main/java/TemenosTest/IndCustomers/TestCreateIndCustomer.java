package TemenosTest.IndCustomers;

import Browser.Browser;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static TemenosTest.IndCustomers.Utilities.AmendIndCustomerUtilities.amendIndCustomer;
import static TemenosTest.IndCustomers.Utilities.AuthorizeIndCustomerUtilities.authorizeIndCustomer;
import static TemenosTest.IndCustomers.Utilities.CreateIndCustomerUtilities.createIndCustomerr;
import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;
import static TemenosTest.IndCustomers.Utilities.MenuCreateIndexCustomerUtilities.navToHomeMenu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class TestCreateIndCustomer extends BaseTest {

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
    }
}
