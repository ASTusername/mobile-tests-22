package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    private final SearchPage searchPage = new SearchPage();
    private final MainPage mainPage = new MainPage();

    @Test
    @Tag("android")
    @DisplayName("Проверка наличия результатов поиска")
    void successfulSearchTest() {
        step("Type search", () -> {
            mainPage.clickSearchButton();
            searchPage.enterSearchText("Appium");
        });
        step("Verify content found", () ->
                searchPage.getSearchResultsCount().shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @Tag("android")
    @DisplayName("Открытие первого результата поиска")
    void openPageTest() {
        step("Type search", () -> {
            mainPage.clickSearchButton();
            searchPage.enterSearchText("Appium");
        });
        step("Verify content found", () ->
                searchPage.getSearchResultsCount().shouldHave(sizeGreaterThan(0)));
        step("Open page with article", mainPage::clickFirstArticle
        );
        step("Verify error after opening the articles", () ->
                mainPage.verifyErrorAfterOpeningArticle("Error")
        );
    }
}
