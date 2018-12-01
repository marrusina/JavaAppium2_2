package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        //SEARCH_CLEAR_MINI = "id:clear mini";
        //SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://h3[contains(text(),'{SUBSTRING}')]";

        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        //SEARCH_NO_SUBSTRING = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]";
        SEARCH_EMPTY_RESULT_ELEMENT = "css:p.without-results";

    }
    public MWSearchPageObject(RemoteWebDriver driver)
    {
          super(driver);
    }
}
