package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.util.List;

abstract public class SearchPageObject extends MainPageObject{
     protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BUTTON,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_BY_TWO_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCH_NO_SUBSTRING,
             SEARCH_CLEAR_MINI,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    //teplates methods
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElementByTwoElements(String substring, String description)
    {
        return SEARCH_RESULT_BY_TWO_TPL.replace("{SUBSTRING}",substring ).replace("{DESCRIPTION}",description);

    }

   //templates methods

    public void initSearchInput()
    {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search element", 5);
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search element");
    }

    public void NoworksSelenium()
    {
        this.waitForElementPresent(SEARCH_NO_SUBSTRING, "No xpath for IOS", 15);
    }


    public void waitForClearMiniButtomToAppear()
    {
        this.waitForElementPresent(SEARCH_CLEAR_MINI, "Cannot find search cancel button", 5);
    }

    public void waitForClearMiniButtomToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CLEAR_MINI, "Search cancel button is still present", 5);
    }

    public void clickClearMiniSearch()
    {
        this.waitForElementAndClick(SEARCH_CLEAR_MINI, "Cannot find and click search cansel button", 5);
    }

    public void waitForCancelButtomToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtomToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void clickCancelSearch()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cansel button", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT, search_line, "Cannot find any type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result" + substring,30);
    }

    public void waitForElementByTitleAndDescription(String substring, String description)
    {
        String search_result_by_two = getResultSearchElementByTwoElements(substring, description);
        this.waitForElementPresent(search_result_by_two,"Cannot find by two elements" + substring + description,15);
    }


    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find search result with substring" + substring, 15);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request",
                5
        );

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);

    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "Cannot find empty result element", 15);

    }

    public void assertthereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any result");
    }

    public void assertthereIsResultOfSearch()
    {
        this.assertElementPresent(SEARCH_RESULT_ELEMENT, "We supposed not to find any result");
    }

}



