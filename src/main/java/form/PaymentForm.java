package form;

import browser.DriverManager;
import elements.LabelElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.DriverUtils;

public class PaymentForm extends BasePage {
    public LabelElement sumLabel = new LabelElement(By.xpath("//div[@class='header__payment-amount']/span"));
    public PaymentForm() {
        super(By.xpath("//div[@class='header__payment-amount']"));
    }

    public String getThePriceFromTheLabel(){
        DriverUtils.getWebDriverWait(10000).until(ExpectedConditions.visibilityOfElementLocated(sumLabel.locator));
        DriverUtils.waitForPageLoad();
        return DriverManager.findElement(sumLabel).getText();
    }
}
