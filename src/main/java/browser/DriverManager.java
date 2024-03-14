package browser;

import elements.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    public static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            return driver;
        }
        else
            return driver;
    }
    public static WebElement findElement(BaseElement baseElement){
        var locator = baseElement.locator;
        return DriverManager.getDriver().findElement(locator);
    }
}

