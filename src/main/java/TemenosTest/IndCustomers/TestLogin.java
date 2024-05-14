package TemenosTest.IndCustomers;

import org.testng.annotations.Test;

import static TemenosTest.IndCustomers.Utilities.LoginUtilties.login;

public class TestLogin extends BaseTest{

    @Test
    public void loginTest(){
        login(browser,"UserName","Password");
    }
}
