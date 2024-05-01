package TemenosTest.IndCustomers;
import TemenosHelperPages.HomeMenuNav;
import TemenosHelperPages.IndCustomers.CreateIndCustomer;
import TemenosHelperPages.AppAuth.LoginClass;
import TemenosHelperPages.AppAuth.LogoutClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class TestCreateIndCustomer {
    public static void main(String[] args) {

        LoginClass.login("INPUTT","123456");
        HomeMenuNav.MenuCreateIndCustomer();
        CreateIndCustomer.CreateIndCustomer();
        LogoutClass.Logout();
        LoginClass.login("AUTHOR","1234567");
    }

}