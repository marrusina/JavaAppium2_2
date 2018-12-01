package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.Platform;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static String
        //MY_LISTS_LINK = "//android.widget.ImageButton[@content-desc='Navigate up']";
    MY_LISTS_LINK,
    MY_HOME_LINK,
    OPEN_NAVIGATION;
    //MY_NAV_TAB_LAYOUT = "id:org.wikipedia:id/fragment_main_nav_tab_layout";


    public NavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openNavigation()
    {
        if (Platform.getInstance().isMW()) {
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 55);
        } else {
            System.out.println("Method openNavigation() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists() {
        //this.waitForElementPresent(
        //         MY_LISTS_LINK,
        //        "Cannot load tab with my lists",
        //         60
        //  );
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    50
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find my lists link",
                    50
            );

        }
    }

}
