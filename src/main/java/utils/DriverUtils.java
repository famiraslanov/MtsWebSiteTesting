package utils;

import browser.DriverManager;
import elements.BaseElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverUtils {
    private DriverUtils(){

    }

    static WebDriverWait webDriverWait;

    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));
        wait.until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public static void scrollThePageUntilElementFound(WebElement element){
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static WebDriverWait getWebDriverWait(long millis){
        if (webDriverWait == null)
            return webDriverWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofMillis(millis));
        else
            return webDriverWait;
    }

}


