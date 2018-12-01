package lib;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase {

   // private static final String PLATFORM_IOS = "ios";
   // private static final String PLATFORM_ANDROID = "android";

    protected RemoteWebDriver driver;
   // ChromeDriverManager.getInstance().setup();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();
    }
    @Override
    protected void tearDown() throws Exception
    {
        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateScreenLandscape()
    {
        if(driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method rotateScreenLandscape() does nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

   protected void backgroundApp(int seconds)
   {
       if(driver instanceof AppiumDriver){
           AppiumDriver driver = (AppiumDriver) this.driver;
           driver.runAppInBackground(seconds);
       } else {
           System.out.println("Method backgroundApp() does nothing for platform" + Platform.getInstance().getPlatformVar());
       }
   }

   protected void openWikiWebPageForMobileWeb()
   {
       if(Platform.getInstance().isMW()) {
           driver.get("https://en.m.wikipedia.org");
       } else {
           System.out.println("Method openWikiWebPageForMobileWeb() do nothing for platform" + Platform.getInstance().getPlatformVar());
       }
   }

   private void skipWelcomePageForIOSApp()
   {
       if(Platform.getInstance().isIOS()) {
           AppiumDriver driver = (AppiumDriver) this.driver;
           WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
           WelcomePageObject.clickSkip();
       }
       }
   }



