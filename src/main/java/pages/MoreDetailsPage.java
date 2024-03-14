package pages;

import org.openqa.selenium.By;

public class MoreDetailsPage extends BasePage{
    public MoreDetailsPage() {
        super(By.xpath("//span[@itemprop='name' and contains(text(), 'Порядок оплаты')]"));
    }
}
