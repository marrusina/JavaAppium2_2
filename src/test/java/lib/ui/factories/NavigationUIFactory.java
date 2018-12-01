package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.NavigationUI;
import lib.ui.android.AndroidNavigationUI;
import lib.ui.ios.IOSNavigationUI;
import lib.ui.mobile_web.MWNavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NavigationUIFactory
{
    public static NavigationUI get(RemoteWebDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else if (Platform.getInstance().isIOS()){
            return new IOSNavigationUI(driver);
        } else {
            return new MWNavigationUI(driver);
        }
    }

}
