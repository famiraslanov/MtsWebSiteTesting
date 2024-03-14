package pages;

import browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

public abstract class BasePage {
    public final By locator;

    public BasePage(By locator){
        this.locator = locator;
    }
    public boolean isPageOpened() {
        DriverUtils.waitForPageLoad();
        DriverUtils.getWebDriverWait(3000).until(ExpectedConditions.visibilityOfElementLocated(locator));

        try {
            DriverManager.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
