package lib.ui;
import io.appium.java_client.AppiumDriver;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject{

    protected static String
            TITLE,
            TITLE_SECOND,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FOR_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OKEY_BUTTON,
            MY_LIST_NAME,
            MY_LIST_VIEW,
            CLOSE_SYNC_WINDOW,
            CLOSE_ARTICLE_BUTTON;
    public ArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article by title", 15);
    }
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    public WebElement waitForSecondTitleElement()
    {
        return this.waitForElementPresent(TITLE_SECOND, "Cannot find second article by title", 25);
    }
    public String getSecondArticleTitle()
    {
        WebElement title_element = waitForSecondTitleElement();
        if(Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }

    }
        public void swipeToFooter()
    {
        if(Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else if (Platform.getInstance().isIOS()) {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
            "Cannot find the end of article",
            80);
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }
    }
    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                60
        );
        this.waitForElementPresent(
                MY_LIST_VIEW,
                "Cannot open view",
                60
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                60
        );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                60
        );
        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                60
        );
        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot input 'Learning programming'",
                30
        );
        this.waitForElementAndClick(
                MY_LIST_OKEY_BUTTON,
                "Cannot press OK button",
                60
        );
    }
    public void addSecondArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                60
        );
        waitForElementPresent(
                MY_LIST_VIEW,
                "Cannot open view",
                60
        );
        waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                60
        );
        waitForElementPresent(
                MY_LIST_NAME,
                "Cannot find list Learning programming for saving the second article",
                15
        );
        waitForElementAndClick(
                MY_LIST_NAME,
                "Cannot find list Learning programming for saving the second article",
                15
        );
    }

    public void addArticleToMySaved() {
        if (Platform.getInstance().isMW()) {
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find options to add article to reading list", 35);
    }

    public void removeArticleFromSavedIfItAdded()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FOR_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FOR_MY_LIST_BUTTON,
                    "Cannot click button to remove article from saved",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from the list before"
            );
        }

    }

    public void closeArticle()
    {
        if (Platform.getInstance().isIOS()){
            this.waitForElementAndClick(CLOSE_SYNC_WINDOW, "The window is still on the screen", 20);
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    30
            );
        } else if (Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    20
            );
        } else {
            System.out.println("Method closeArticle() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void closeSecondArticle()
    {
        if (Platform.getInstance().isIOS()){
           // this.waitForElementAndClick(CLOSE_SYNC_WINDOW, "The window is still on the screen", 20);
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    30
            );
        } else if (Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    20
            );
        } else {
            System.out.println("Method closeSecondArticle() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void closeIOS()
    {
        this.closeIOSMessage();
    }


}