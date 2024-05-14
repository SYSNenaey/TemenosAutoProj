package TemenosHelperPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private static WebDriver cdriver;

    public WebDriverFactory(){
            initializeDriver();
    }


    public void initializeDriver(){

        String browserType = System.getProperty("browserType","chrome");
        switch (browserType){
            case "chrome":
                ChromeOptions chromeCapabilities = new ChromeOptions();
                chromeCapabilities.addArguments("--start-maximized");
                cdriver = new ChromeDriver(chromeCapabilities);
                break;

//            case "edge":
//                EdgeOptions options = new EdgeOptions();
            //               driver = new EdgeDriver(options);
        }

    }
    public static WebDriver getDriver() {
        return cdriver;
    }



    public void navigateTo(String URL){
        cdriver.navigate().to(URL);
    }

    public static void resetCache(){
        cdriver.manage().deleteAllCookies();
    }

    public static void quit(){
        if (cdriver != null) {
            cdriver.quit();
            cdriver = null;
        }
    }
}
