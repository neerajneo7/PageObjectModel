package PageObjectModel;

import org.junit.Test;
import org.openqa.selenium.By;

public class TestSuit extends BaseTest
{
    HomePage homePage = new HomePage();
    @Test

    public void userShouldBeAbleToNavigateToHomePage()
    {
        homePage.verifyUserIsOnHomePage();
        assertCurrentURL("https://demo.nopcommerce.com/");
    }

    public void userShouldBeAbleToSelectDesiredCurrency()
    {
        homePage.selectEuroCurrency();
    }

    public void checkPrice()
    {
        homePage.priceForDesiredCurrency();
    }
}
