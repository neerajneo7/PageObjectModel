package PageObjectModel;

import org.junit.After;
import org.junit.Before;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils
{

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProp loadProp = new LoadProp();
    @BeforeMethod

    public void openBrowser()
    {
        browserSelector.setUpBrowser();


}

    @AfterMethod
    public void closeBrowser(ITestResult result)
    {
        // ITestResult is the inbuilt interface and getStatus will get the status of the failed shot
        if (ITestResult.FAILURE == result.getStatus())
        {
         // result.getname will capture the screenshot of the method that has failed and give that method name.
            screenshotOfTheBrowser(result.getName());
        }
     driver.quit();
    }

}
