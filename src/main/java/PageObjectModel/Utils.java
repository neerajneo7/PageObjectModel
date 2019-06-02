package PageObjectModel;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import javax.xml.bind.Element;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {

    //Take screenshot of the browser
    public static void screenshotOfTheBrowser(String screenshotName) {
        //This takes the screen shot of the browser and will store the image in specified location
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            //+screenshotName will give the different name everytime the screen shot has been captured so it is
            //different name everytime to overcome the overwriting the shots.
            FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName+ ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }

    //Take screenshot of full display(full)
    public static void screenshotOfFullCurrentDisplay(String nameOfScreenshot) {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(fpScreenshot.getImage(), "PNG", new File("./Screenshots/" + nameOfScreenshot + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //Date stamp short
    public static void dateStampShort()
    {
        try {
            Date shortdate = new Date();
            String strDateFormat = "dd/MMM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            System.out.println("Current Time : " + sdf.format(shortdate));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assertTextMessage(String expected, By by)
    {
        String actual = driver.findElement(by).getText();
        Assert.assertEquals(expected,actual);
        System.out.println(expected + actual);
    }

    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }

    public static void assertCurrentURL(String url)
    {

        Assert.assertTrue(driver.getCurrentUrl().equals(url));
        System.out.println(url);
    }

    //Get Selected Value From Dropdown
    public static void selectValueFromDropdown(By by, String value)
    {
        Select select = new Select(driver.findElement(by));

       select.selectByVisibleText(value);
       // select.selectByIndex(2);

    }

    //Clicking element
    public static void elementShouldBeClickable(By by)
    {
        try
        {
            driver.findElement(by).click();

        }catch(ElementClickInterceptedException e)
        {
            System.out.println("Error Message" + e.getMessage());
        }
    }
}