package elements;

import browser.DriverManager;
import org.openqa.selenium.By;

public class BaseElement {
    public final By locator;

    public BaseElement(By locator){
        this.locator = locator;
    }

    public void click(){
        DriverManager.getDriver().findElement(this.locator).click();
    }
}
