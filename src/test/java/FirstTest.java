import lib.CoreTestCase;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class FirstTest extends CoreTestCase {

    @Test
    public void testCancelSearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Java";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertFalse("Not enough search results",amount_of_search_results<=1);

        assertTrue(
                "We found too few results",
                amount_of_search_results > 1
        );

        SearchPageObject.waitForCancelButtomToAppear();
        SearchPageObject.clickCancelSearch();
        //SearchPageObject.waitForSearchLineTodisappear();

    }

    @Test
    public void testCheckArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("c++");
        SearchPageObject.clickByArticleWithSubstring("General purpose high-level programming language");
        SearchPageObject.assertthereIsResultOfSearch();


    }
    @Test
    public void testSaveAndDeleteArticle()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        //second article
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("c++");
        SearchPageObject.clickByArticleWithSubstring("General purpose high-level programming language");

        ArticlePageObject.waitForTitleElement();
        String article_title_first = ArticlePageObject.getArticleTitle();
        ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

       // NavigationUI NavigationUI = ArticlePageObject.getArticleTitle(driver);
       // NavigationUI.clickMyLists();

       // MyListsPageObject MyListsPageObject = ArticlePageObject.getArticleTitle(driver);
       // MyListsPageObject.openFolderByName(name_of_folder);
       // MyListsPageObject.swipeByArticleToDelete(article_title);

       // int amount_of_search_results = SearchPageObject.getAmountOfFoundArticlesAfterDeletion();
        //assertTrue(
       //         "We found some results",
       //         amount_of_search_results > 0
       // );
        SearchPageObject.clickByArticleWithSubstring("general purpose high-level programming language");
        String article_title_second = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Titles are not the same",
                article_title_first,
                article_title_second
        );

    }


}





