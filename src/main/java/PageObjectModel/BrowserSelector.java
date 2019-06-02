package PageObjectModel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils
{
    LoadProp loadProp = new LoadProp();

    public void setUpBrowser()
    {
        String browser = System.getProperty("browser");
        //String browser = loadProp.getProperty("browser");

        if (browser.equalsIgnoreCase(("chrome")))
        {
            System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDrivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("start-maximized");
            options.addArguments("--disable-setUpBrowser-side-navigation-");
            options.addArguments("disable-blink-features=BlockCredentialedSubresources");
            driver = new ChromeDriver(options);
            // this is to manage your Implicity wait for 20 seconds
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // this is the website you want to visit for your testing purposes
            driver.get("https://demo.nopcommerce.com/");

        }else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","src/test/Resources/BrowserDrivers/geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            // this is to manage your Implicity wait for 20 seconds
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // this is the website you want to visit for your testing purposes
            driver.get("https://demo.nopcommerce.com/");
        }else if (browser.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver","src\\test\\Resources\\BrowserDrivers\\IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            options.setCapability("initialBrowserUrl", "<your-initial-url-that-will-be-loaded>");
            driver = new InternetExplorerDriver(options);
            driver.manage().window().maximize();
            // this is to manage your Implicity wait for 20 seconds
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // this is the website you want to visit for your testing purposes
            driver.get("https://demo.nopcommerce.com/");
        }else
            {
                System.out.println("Browser name is incorrect " + browser);
            }
    }
}
