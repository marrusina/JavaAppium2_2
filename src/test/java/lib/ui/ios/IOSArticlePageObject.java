package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        TITLE_SECOND = "id:General purpose high-level programming language";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
       // MY_LIST_NAME = "xpath://*[@text='Learning programming']";
       // MY_LIST_VIEW = "className:android.widget.ListView";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        CLOSE_SYNC_WINDOW = "id:places auth close";
    }

    public IOSArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
