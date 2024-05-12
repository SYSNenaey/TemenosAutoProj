package TemenosHelperPages;

import org.openqa.selenium.By;

import java.util.Set;

public class AuthorizeIndCustomer extends CommonMethods {


    private final By AuthorizeDeleteCustomerBtn = By.xpath("//a[@href=\"javascript:docommand('COS CUSTOMER.NAU');\"]");

    private final By SearchBtn = By.xpath("//a[@title='Selection Screen']");


    public final By IdField = By.cssSelector("input[id='value:1:1:1']");

    private final By FindBtn = By.cssSelector("a[title='Run Selection']");

    private final By authorizeBtn = By.xpath("//a[@title='Authorise']");
    private final By authorizDealeBtn = By.xpath("//a[@title='Authorises a deal']");

    private final By completeTxn = By.xpath("//td[contains(text(),'Txn Complete:')]");


    public void clickOnAuthorizeDeleteCustomerBtnn() {
        FindElement(AuthorizeDeleteCustomerBtn).click();
    }



    public void clickOnSearchBtnclickOnSearchBtn() {
        FindElement(SearchBtn).click();
    }

    public void enterCustomerNOInIDField(String enterCustomerNo) {
        FindElement(IdField).sendKeys(enterCustomerNo);
    }

    public void clickOnFindButton() {
        FindElement(FindBtn).click();
    }

    public void clickOnauthorizeBtn() {
        FindElement(authorizeBtn).click();
    }

    public void clickOnauthorizDealeBtn() {
        FindElement(authorizDealeBtn).click();
    }

    public String getAuthorizeMsg() {
        String AuthorizeMsg = FindElement(completeTxn).getText();
        return AuthorizeMsg;

    }


}
