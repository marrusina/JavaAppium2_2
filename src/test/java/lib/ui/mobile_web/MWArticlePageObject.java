package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        TITLE_SECOND = "css:#content h3";
        FOOTER_ELEMENT = "css:footer";
        //OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath:.//*[contains(text(),'Watch this page')]";

        //OPTIONS_ADD_TO_MY_LIST_BUTTON = "<css:#ca-watch.mw-ui-icon.mw-ui-icon-element.mw-ui-icon-minerva-watch.watch-this-article.view-border-box.mw-ui-icon-mf-watch";
        OPTIONS_REMOVE_FOR_MY_LIST_BUTTON = "css:#page-actions li#ca-watch.mv-ui-icon-mf-watched watched button";
        // MY_LIST_NAME = "xpath://*[@text='Learning programming']";
        // MY_LIST_VIEW = "className:android.widget.ListView";
        //CLOSE_SYNC_WINDOW = "id:places auth close";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
