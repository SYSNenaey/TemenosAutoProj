package TemenosTest.IndCustomers;

import TemenosHelperPages.AppAuth.LoginClass;
import TemenosHelperPages.HomeMenuNav;

public class TestCreateCRM {

    public static void main(String[] args) {

       LoginClass.login("INPUTT","123456");
        HomeMenuNav.MenuCreateCRM();
    }
}
