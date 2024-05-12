package TemenosHelperPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public abstract class CommonMethods {


    public WebDriver cdriver = WebDriverFactory.getDriver();

    private Set<String> windowHandles;

    private String originalWindowHandle;
    private String lastWindowHandle;

    public WebElement FindElementByTextPath(String dynamicXpath){
       WebElement element =  cdriver.findElement(By.xpath("//*[contains(text(),\""+dynamicXpath+"\"))]"));
               return element;
    }

    public void getAlertTextAndAcceptThisAlert(){
        WebDriverWait wait = new WebDriverWait(cdriver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void SwitchFrameByWebElement(WebElement frame){
        WebDriverWait wait = new WebDriverWait(cdriver,Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOf(frame));
        cdriver.switchTo().frame(frame);
    }

    public WebElement FindElement(By locator){
        WebDriverWait wait = new WebDriverWait(cdriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return WebDriverFactory.getDriver().findElement(locator);
    }
    public WebElement FindElementtoBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(cdriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return WebDriverFactory.getDriver().findElement(locator);
    }


    public void MaximizeWindow(){
        cdriver.manage().window().maximize();
    }

    public void switchToTheOpenedNewWindow() {
        // Get all window handles
        windowHandles = cdriver.getWindowHandles();
        originalWindowHandle = cdriver.getWindowHandle();
        System.out.println(windowHandles);
        // Switch to the last opened window
        lastWindowHandle = (String) windowHandles.toArray()[windowHandles.size() - 1];
        System.out.println(lastWindowHandle);
        cdriver.switchTo().window(lastWindowHandle);
    }

    public void switchToOriginalWindow() {
        // Switch to original window
        cdriver.switchTo().window(originalWindowHandle);
        System.out.println(originalWindowHandle);
    }

    public void closeTheOpenedNewWindow(){
        cdriver.close();
    }

}
