package TemenosHelperPages.AppAuth;

import TemenosHelperPages.CommonMethods;
import TemenosHelperPages.HomeMenuNav;
import org.openqa.selenium.By;

public class LoginClass extends CommonMethods {


    private final By UserName = By.id("signOnName");
    private final By Password = By.id("password");
    private final By SignInBtn = By.id("sign-in");


    public void login(String username, String password) throws InterruptedException {

        // Open the URL from ProprtyFile

        // Find username field and enter username
        FindElement(UserName).sendKeys(username);

        // Find password field and enter password
        FindElement(Password).sendKeys(password);


        }
    public HomeMenuNav clickOnSignIn() throws InterruptedException {
        FindElement(SignInBtn).click();
        return new HomeMenuNav();
        //return clogindriver ;
    }
//    public static void Driverquit () {
//        // Close the WebDriver
//
//        WebDriver clogindriver =LoginClass.login("INPUTT","123456");
//        clogindriver.quit();
//}
}
