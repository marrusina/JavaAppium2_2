package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
        FOLDER_BY_NAME_TEMPLATE,
        ARTICLE_BY_TITLE_TEMPLATE,
        SAVED_BUTTON,
        REMOVE_FROM_SAVED_BUTTON;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TEMPLATE.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXpathByTitle(String article_title) {
            return ARTICLE_BY_TITLE_TEMPLATE.replace("{TITLE}", article_title);
        }

    private static String getRemoveButtonByTitle(String article_title)
    {
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)

    {
        String folder_name_xpath = getSavedArticleXpathByTitle(name_of_folder);
        this.waitForElementPresent(
                folder_name_xpath,
                "Cannot find folder by name",
                30
        );
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name",
                30
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title" + article_title, 50);

    }


    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present" + article_title, 35);

    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);

        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(
                    article_xpath,
                    "Cannot find saved article and click"
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove article from saved",
                    25
            );
        }
        if (Platform.getInstance().isMW()) {

            driver.navigate().refresh();
            driver.navigate().refresh();
        }
        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperConer(article_xpath, "Cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }



}
