package TemenosHelperPages.IndCustomers;

import TemenosHelperPages.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateIndCustomer extends CommonMethods {

    //private final By IndividualCustomerBtn = By.xpath("//*[@id=\"pane_\"]/ul[1]/li/ul/li[2]/ul/li[1]/a");
    private final By titledropdownLocator = By.id("fieldName:TITLE");
    private final By GivenName = By.id("fieldName:GIVEN.NAMES");
    private final By GB_Full_Name_field = By.id("fieldName:NAME.1:1");
    private final By GB_Short_Name_field = By.id("fieldName:SHORT.NAME:1");
    private final By Mnemoic_field = By.id("fieldName:MNEMONIC");
    private final By Sector_field = By.id("fieldName:SECTOR");
    private final By femaleRadioBtn = By.xpath("//input[@value='FEMALE']");
    private final By maleRadioBtn = By.xpath("//input[@value='MALE']");




    private final By ValidateDealBtn = By.xpath("//*[@id=\"goButton\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[2]/a/img");
    private final By CommitDealBtn = By.xpath("//*[@id=\"goButton\"]/tbody/tr/td/table/tbody/tr/td/div/table/tbody/tr/td[1]/a/img");

    private final By acceptOverRide = By.id("errorImg");

    private final By completeTxn = By.xpath("//td[contains(text(),'Txn Complete:')]");

    private String CustomerNo;




//    public CreateIndCustomer clickOnIndividualCustomerBtn() {
//        FindElement(IndividualCustomerBtn).click();
//        return new CreateIndCustomer();
//    }

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

    public void clickOnGenderButton(String gender) {
        gender = gender.toLowerCase();
        System.out.println(gender);
        if (gender.equals("male")){
            FindElement(maleRadioBtn).click();

        } else if (gender.equals("female")) {
            FindElement(femaleRadioBtn).click();
        }
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
