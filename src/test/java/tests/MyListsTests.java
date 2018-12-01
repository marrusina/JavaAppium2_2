package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String
    login = "marrusina",
    password = "11111";

    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
       // SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        SearchPageObject.clickByArticleWithSubstring(" (programming language)");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login,password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );

            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.swipeByArticleToDelete(article_title);
       // MyListsPageObject.waitForArticleToAppearByTitle(article_title);

    }
    @Test
    public void testSaveAndDeleteSecondArticle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(" (programming language)");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login,password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            assertEquals("We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeArticle();

        //second article
        SearchPageObject.initSearchInput();
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()) {
            SearchPageObject.waitForClearMiniButtomToAppear();
            SearchPageObject.clickClearMiniSearch();
            SearchPageObject.waitForClearMiniButtomToDisappear();
        }

        SearchPageObject.typeSearchLine("c#");
        SearchPageObject.clickByArticleWithSubstring("C Sharp");

        ArticlePageObject.waitForSecondTitleElement();

        String article_title_first = ArticlePageObject.getSecondArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addSecondArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticleToMySaved();
        }
        ArticlePageObject.closeSecondArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();

         MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
       if(Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);
       SearchPageObject.clickByArticleWithSubstring("C Sharp");

        ArticlePageObject.waitForSecondTitleElement();

        String article_title_second = ArticlePageObject.getSecondArticleTitle();

        assertEquals(
               "Titles are not the same",
               article_title_first,
               article_title_second);

    }

}
