package TemenosHelperPages.IndCustomers;

import TemenosHelperPages.CommonMethods;
import TemenosHelperPages.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class CreateIndCustomer extends CommonMethods {

    private final By IndividualCustomerBtn = By.xpath("//*[@id=\"pane_\"]/ul[1]/li/ul/li[2]/ul/li[1]/a");
    private final By titledropdownLocator = By.id("fieldName:TITLE");
    private final By GivenName = By.id("fieldName:GIVEN.NAMES");
    private final By GB_Full_Name_field = By.id("fieldName:NAME.1:1");
    private final By GB_Short_Name_field = By.id("fieldName:SHORT.NAME:1");
    private final By Mnemoic_field = By.id("fieldName:MNEMONIC");
    private final By Sector_field = By.id("fieldName:SECTOR");
    private final By GenderRadioBtn = By.id("radio:tab1:GENDER");

    private final By ValidateDealBtn = By.xpath("//*[@id=\"goButton\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/a/img");
    private final By CommitDealBtn = By.xpath("//*[@id=\"goButton\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/a/img");

    private final By acceptOverRide = By.id("errorImg");

    private final By completeTxn = By.xpath("//td[contains(text(),'Txn Complete:')]");

    private String CustomerNo;




    public void clickOnIndividualCustomerBtn() {
        FindElement(IndividualCustomerBtn).click();
    }

    public void enterGivenName(String GivenNameTxt) {
        FindElement(GivenName).sendKeys(GivenNameTxt);
    }

    public void enterGBFullNamefield(String GB_Full_Name_Txt) {
        FindElement(GB_Full_Name_field).sendKeys(GB_Full_Name_Txt);
    }

    public void enterMonemoicFieldAutomatically(){
        FindElement(Mnemoic_field).sendKeys(generateRandomMenmonicvalue());
    }
    public void enterMonemoicField(String menmonic){
        FindElement(Mnemoic_field).sendKeys(menmonic);
    }

    public String generateRandomMenmonicvalue(){
        int Num_Length = 10;
        StringBuilder st = new StringBuilder();
        Random random = new Random();
        st.append("A");
        for(int i =0; i<Num_Length; i++){
            st.append(random.nextInt(10));
        }
        return st.toString();

    }

    public void enterSectorField(String enterSectorTxt) {
        FindElement(Sector_field).sendKeys(enterSectorTxt);
    }

        public void enterGBShortNameField(String enterGBShortNameTxt) {
            FindElement(GB_Short_Name_field).clear();
            FindElement(GB_Short_Name_field).sendKeys(enterGBShortNameTxt);
        }

    public void clickOnGenderButton() {
        FindElement(GenderRadioBtn).click();
    }

    public void clickOnValidateDealBtn() {
        FindElement(ValidateDealBtn).click();
    }

    public void clickOnCommitDealBtn() {
        FindElement(CommitDealBtn).click();
    }

    public void clickOnTitleDropdownList(String TitleText) {
        WebElement titledropdownElement = FindElement(titledropdownLocator);
        Select titledropdown = new Select(titledropdownElement);
        titledropdown.selectByVisibleText(TitleText);
    }





    public void checkTheCustomerisExistedBeforeAndOverride(){
        WebElement acceptOverRideBtn = FindElement(acceptOverRide);
            if(acceptOverRideBtn.isDisplayed()){
                acceptOverRideBtn.click();
            }
    }

    public String setCustomerNo(){
        CustomerNo =  FindElement(completeTxn).getText().replaceAll("[^0-9]", "").substring(0, 6);
        return CustomerNo;
    }

    public String getCustomerNo(){
        return CustomerNo;
    }
}
