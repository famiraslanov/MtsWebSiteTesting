package pages;

import browser.DriverManager;
import constants.SettingsConstants;
import elements.Button;
import elements.LabelElement;
import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;
import utils.JsonUtils;
import utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage{
    public Button acceptCookiesButton = new Button(By.xpath("//button[@id = 'cookie-agree']"));
    public LabelElement paymentPartnersDiv = new LabelElement(By.xpath("//div[contains(@class, 'pay__partners')]"));
    public Link moreDetailsLink = new Link(By.xpath("//a[contains(@href, 'bezopasnost')]"));
    public LabelElement numberInputLabel = new LabelElement(By.xpath("//input[@id='connection-phone']"));
    public LabelElement emailInputLabel = new LabelElement(By.xpath("//input[@id='connection-email']"));
    public LabelElement sumInputLabel = new LabelElement(By.xpath("//input[@id='connection-sum']"));
    public Button continueButton = new Button(By.xpath("//button[contains(@class, 'button__default ')]"));


    public MainPage() {
        super(By.xpath("//h2[text()='Онлайн пополнение ']"));
    }

    public void clickAcceptCookiesButton(){
        acceptCookiesButton.click();
    }

    public void fillNoCommissionForm(int sum){
        DriverManager.findElement(numberInputLabel).sendKeys(JsonUtils.getJsonValue(SettingsConstants._appdataJsonFile, SettingsConstants._testPhoneNumber));
        DriverManager.findElement(emailInputLabel).sendKeys(JsonUtils.getJsonValue(SettingsConstants._appdataJsonFile, SettingsConstants._testEmail));
        DriverManager.findElement(sumInputLabel).sendKeys(String.valueOf(sum));
    }

    public void clickContinueButton(){
        DriverManager.findElement(continueButton).click();
    }
    public void clickMoreDetailsLink(){
        DriverUtils.scrollThePageUntilElementFound(DriverManager.findElement(moreDetailsLink));
        moreDetailsLink.click();
    }


    public List<String> getListOfPaymentMethods(){
        WebElement ulElement = DriverManager.findElement(paymentPartnersDiv).findElement(By.tagName("ul"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        List<WebElement> imageElements = new ArrayList<>();

        for (WebElement liElement : liElements){
            imageElements.add(liElement.findElement(By.tagName("img")));
        }

        List<String> altAttributes = new ArrayList<>();

        for (WebElement imageElement : imageElements) {
            String alt = imageElement.getAttribute("alt");
            altAttributes.add(alt);
        }

        return altAttributes;
    }
}


