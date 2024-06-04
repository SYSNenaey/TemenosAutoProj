package TemenosTest.IndCustomers;

import TemenosHelperPages.AppAuth.LoginClass;
import TemenosHelperPages.AppAuth.LogoutClass;
import TemenosHelperPages.HomeMenuNav;
import TemenosHelperPages.IndCustomers.CreateIndCustomer;

import java.io.IOException;

public class TestCashWithdrawalForeign {



    public static void main(String[] args) throws IOException {


        // Create Ind Customer
        Login();
        MenuCreateIndCustomer();
        CreateIndCustomer();



        // Amend Ind Customer

    }
    public static void Login() throws IOException {
        //LoginClass.login("andrew", "123456");

    }

    public static void MenuCreateIndCustomer() {

       // HomeMenuNav.MenuCreateIndCustomer();
    }

    public static void CreateIndCustomer () {

        //CreateIndCustomer.CreateIndCustomer();

    }

    public static void Logout () {

      //  LogoutClass.Logout();

    }

    public void LoginAuth () {

    }
}
