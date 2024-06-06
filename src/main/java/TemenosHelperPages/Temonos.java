package TemenosHelperPages;

import TemenosHelperPages.Accounts.AmendAccount;
import TemenosHelperPages.Accounts.AuthorizeAndDeleteAccount;
import TemenosHelperPages.Accounts.Accounts;

import TemenosHelperPages.AppAuth.LoginClass;
import TemenosHelperPages.AppAuth.LogoutClass;
import TemenosHelperPages.IndCustomers.CreateIndCustomer;

public class Temonos {

    public LoginClass login = new LoginClass();
    public LogoutClass logout = new LogoutClass();

    public HomeMenuNav homeMenuNav;

    public CreateIndCustomer createIndCustomer;
    public AuthorizeIndCustomer authorizeIndCustomer;
    public AmendindCustomer amendindCustomer;
    public Accounts currentAccount;
    public Accounts savingAccount;
    public AmendAccount amendAccount;
    public AuthorizeAndDeleteAccount authorizeAndDeleteAccount;


}
