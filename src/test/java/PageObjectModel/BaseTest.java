package PageObjectModel;

import org.junit.After;
import org.junit.Before;

public class BaseTest extends Utils
{

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProp loadProp = new LoadProp();
    @Before

    public void openBrowser()
    {
        browserSelector.setUpBrowser();



    }

    @After
    public void closeBrowser()
    {
        screenshotOfFullCurrentDisplay();
        //driver.quit();
    }

}
