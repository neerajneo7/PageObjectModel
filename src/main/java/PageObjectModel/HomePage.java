package PageObjectModel;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    private By _homePage = By.xpath("//div[@class='header-logo']");
    private By _currency = By.className("currency-selector");
    private By _pricecurrency = By.className("price actual-price");

    public void verifyUserIsOnHomePage()
    {
        assertCurrentURL("https://demo.nopcommerce.com/");
    }

    public void selectDollarCurrency()
    {
        selectValueFromDropdown(_currency,"US Dollar");
    }

    public void selectEuroCurrency()
    {
        selectValueFromDropdown(_currency,"Euro");

    }
    public void priceForDesiredCurrency(){
        assertTextMessage("$", _pricecurrency);
        System.out.println("$" + _pricecurrency);
    }
}