package TemenosTest.IndCustomers;

import TemenosTest.IndCustomers.Utilities.CreateIndCustomerUtilities;
import org.testng.annotations.Test;

import java.io.IOException;

import static TemenosTest.IndCustomers.Utilities.AuthorizeIndCustomerUtilities.authorizeIndCustomer;
import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;
import static TemenosTest.IndCustomers.Utilities.MenuCreateIndCustomerUtilities.navToHomeMenu;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.




public class TestCreateIndCustomer extends BaseTest {

    public static String[] headers = {"GivenName","FullName","ShortName","Mnemonic"};
    @Test(dataProvider = "excelData")
    public void createIndCustomer(Object... params) throws InterruptedException, IOException {
        String fileName = "testdata2525.xlsx";
        String Title = params[0].toString();
        String Gender = params[1].toString();
        String GivenName = params[2].toString();
        String FullName = params[3].toString();
        String ShortName = params[4].toString();
        String Mnemonic = params[5].toString();
        String Sector = returnSheetName(fileName,0);
        login(browser,"UserName","Password");
        navToHomeMenu(browser);
        CreateIndCustomerUtilities cr = new CreateIndCustomerUtilities();
      String customerNo = cr.createIndCustomerr(browser,Title,GivenName,FullName,ShortName,Sector,Mnemonic,Gender);
      System.out.println(customerNo);
        retrieveOutPutDataAndPassitTOLastColumn(headers,customerNo,"TXN Number",Sector);
        authorizeIndCustomer(browser,  "AuthorizeUserName", "AuthorizePassword");
    }
    @Test
    public void createIndCustomerr() throws InterruptedException, IOException {
        login(browser,"UserName","Password");
        navToHomeMenu(browser);
        String Title = data.getPropertyValue("Title");
        String Gender = data.getPropertyValue("Gender");
        String GivenName = faker.name().name();
        String FullName = faker.name().name();
        String ShortName = faker.name().name();
        String Mnemonic = faker.letterify("A") + faker.number().digits(10);
        String Sector = data.getPropertyValue("Sector");
        CreateIndCustomerUtilities cr = new CreateIndCustomerUtilities();
        String customerNo = cr.createIndCustomerr(browser,Title,GivenName,FullName,ShortName,Sector,Mnemonic,Gender);
        System.out.println(customerNo);
        retrieveOutPutDataAndPassitTOLastColumn(headers,customerNo,"TXN Number",Sector);
        authorizeIndCustomer(browser,  "AuthorizeUserName", "AuthorizePassword");
    }

}

