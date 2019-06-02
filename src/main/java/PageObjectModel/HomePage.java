package PageObjectModel;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    private By _homePage = By.xpath("//div[@class='header-logo']");
    private By _pricecurrency = By.className("price actual-price");
    private By _currencySelector = By.id("customerCurrency");
    private By _currencyEuro = By.xpath("//option[contains(.,'Euro')]");
    private By _register = By.className("ico-register");

    public void verifyUserIsOnHomePage()
    {

        assertCurrentURL("https://demo.nopcommerce.com/");
    }

    public void selectDollarCurrency()
    {
        selectValueFromDropdown(_currencySelector,"US Dollar");
    }

    public void selectEuroCurrency()
    {

        elementShouldBeClickable(By.id("customerCurrency"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        elementShouldBeClickable(By.xpath("//*[@id=\"customerCurrency\"]/option[2]"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void priceForDesiredCurrency(){
        assertTextMessage("$", _pricecurrency);
        System.out.println("$" + _pricecurrency);
    }

    public void clickOnRegister()
    {
        elementShouldBeClickable(_register);
    }
}