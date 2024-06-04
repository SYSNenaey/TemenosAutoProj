//package TemenosTest.IndCustomers;
//
//import TemenosHelperPages.IndCustomers.CreateIndCustomer;
//import TemenosTest.IndCustomers.Utilities.AmendIndCustomerUtilities;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//import static TemenosTest.IndCustomers.Utilities.AmendIndCustomerUtilities.amendIndCustomer;
//import static TemenosTest.IndCustomers.Utilities.AuthorizeIndCustomerUtilities.authorizeIndCustomer;
//import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;
//import static TemenosTest.IndCustomers.Utilities.MenuCreateIndexCustomerUtilities.navToHomeMenu;
//
//public class TestAmendIndCustomer extends BaseTest{
//
//    @Test
//    public void amendIndCustomerr() throws InterruptedException {
//        login(browser,"UserName","Password");
//        navToHomeMenu(browser);
//        amendIndCustomer(browser,"190377");
//        authorizeIndCustomer(browser,"UserName","Password");
//    }
//    @Test(dataProvider = "RegisterData")
//    public void e2eAmend(String[] params) throws InterruptedException, IOException {
//        String fileName = "testdata2525.xlsx";
//        String Title = params[0].toString();
//        String Gender = params[1].toString();
//        String GivenName = params[2].toString();
//        String FullName = params[3].toString();
//        String ShortName = params[4].toString();
//        String Mnemonic = params[5].toString();
//        String Sector = returnSheetName(fileName,1);
//        login(browser,"UserName","Password");
//        login(browser,"UserName", "Password");
//        navToHomeMenu(browser);
//        createIndCustomerr(browser,Title,GivenName,FullName,ShortName,Sector,Mnemonic,Gender);
//        authorizeIndCustomer(browser, "AuthorizeUserName", "AuthorizePassword");
//        amendIndCustomer(browser, customerNo);
//        authorizeIndCustomer(browser,"UserName", "Password");
//    }
//
//
//}
