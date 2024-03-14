import browser.DriverManager;
import constants.SettingsConstants;
import form.PaymentForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.MoreDetailsPage;
import utils.JsonUtils;
import utils.RandomUtils;

public class MtsTest {

    @Test
    public void testMts(){
        DriverManager.getDriver().get(JsonUtils.getJsonValue(SettingsConstants._configJsonFile, SettingsConstants._mainPageKey));
        DriverManager.getDriver().manage().window().maximize();

        var mainPage = new MainPage();
        mainPage.clickAcceptCookiesButton();

        Assert.assertTrue(mainPage.isPageOpened(), "Main page is not opened");
        Assert.assertEquals(mainPage.getListOfPaymentMethods(), JsonUtils.getJsonValues(SettingsConstants._paymentsMethodJsonFile,
                SettingsConstants._paymentMethods), "Payments method are not as expected");

        mainPage.clickMoreDetailsLink();
        var moreDetailsErrorPage = new MoreDetailsPage();
        Assert.assertTrue(moreDetailsErrorPage.isPageOpened(), "More details page is not opened or does not contain error message");

        DriverManager.getDriver().navigate().back();

        var randomSum = RandomUtils.getRandomNumber(100, 1000);

        mainPage.fillNoCommissionForm(randomSum);
        mainPage.clickContinueButton();

        var paymentForm = new PaymentForm();
        Assert.assertTrue( paymentForm.getThePriceFromTheLabel().contains(String.valueOf(randomSum)), "The sum value is not as expected");


        DriverManager.getDriver().quit();
    }
}
